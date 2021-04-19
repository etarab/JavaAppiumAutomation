//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.lang.reflect.Array;
import java.net.URL;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FirstTest extends ActionsHelper{


    String skip_button = "//*[contains(@text,'SKIP')]";
    String search_field_id = "org.wikipedia:id/search_src_text";

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "and80");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "/Users/etarabuhin/Documents/JavaAppiumAutomationHomework/apks/org.wikipedia.apk");
        ActionsHelper.driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() {
        driver.rotate(ScreenOrientation.PORTRAIT);
        driver.quit();
    }

    @Test
    public void firstTest() {
                System.out.println("First test run");
    }

    @Test
    public void compareTextTest(){
        assertElementHasText(By.id("org.wikipedia:id/primaryTextView"),
                "Unexpected text. Compare finished with failed.",
                "The Free Encyclopedia\n" +
                        "…in over 300 languages");

        waitForElementAndClick(By.xpath(this.skip_button),
                "Can't find SKIP button on start screen");

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Can't find 'Search Wikipedia' field");

        assertElementHasText(By.id(search_field_id),
                "Unexpected text. Compare search plate text finished with failed",
                "Search Wikipedia");
    }

    @Test
    public void clearSearch(){

        waitForElementAndClick(
                By.xpath(this.skip_button),
                "Can't find SKIP button on start screen");

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Can't find 'Search Wikipedia' field");
        waitForElementAndSendKeys(
                By.id(search_field_id),
                "Can't find search field",
                "Appium");

        // проверрка, что результат поиска не пустой
        waitForElementPresent(By.xpath("//*[@resource-id = 'org.wikipedia:id/page_list_item_title']"),
                "Search results not found");

        checkCountElementsOnScreen(By.xpath("//*[@resource-id = 'org.wikipedia:id/page_list_item_title']"),
                "Just one element on screen",
                1);

        waitForElementAndClear(
                By.id(search_field_id),
                "can't find search field");

        assertElementHasText(By.id(search_field_id),
                "Search field clearing is not works",
                "Search Wikipedia");


    }

    @Test
    public void checkSearchResultsTitles(){

        String searchWord = "Java";

        skipFirstScreen();

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Can't find 'Search Wikipedia' field");

        waitForElementAndSendKeys(
                By.id(search_field_id),
                "Can't find search field",
                searchWord);
        waitForElementPresent(By.xpath("//*[@resource-id = 'org.wikipedia:id/page_list_item_title']"),
                "Can't find some result elements");

        for (int i = 1; i <= countElementOnScreen(By.xpath("//*[@resource-id = 'org.wikipedia:id/page_list_item_title']")); i++) {

            String k = Integer.toString(i);
            String xpath = "//*[@resource-id = 'org.wikipedia:id/search_results_list']/android.view.ViewGroup["+k+"]//*[@resource-id = 'org.wikipedia:id/page_list_item_title']";
            WebElement title_element = waitForElementPresent(By.xpath(xpath),
                    "Can't find title element for compare strings");
            String result_title = title_element.getAttribute("text");
            Assert.assertTrue("'"+result_title+"' not contain searching word '"+searchWord+"'",
                    result_title.contains(searchWord));

        }

    }

    @Test
    public void checkSwipeAction(){

        String searchWord = "Java";

        waitForElementAndClick(
                By.xpath(this.skip_button),
                "Can't find SKIP button on start screen");

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Can't find 'Search Wikipedia' field");

        waitForElementAndSendKeys(
                By.id(search_field_id),
                "Can't find search field",
                searchWord);
        waitForElementPresent(By.xpath("//*[@resource-id = 'org.wikipedia:id/page_list_item_title']"),
                "Can't find some result elements");

        waitForElementAndClick(By.xpath("//*[contains(@text,'Java (programming language)')]"),
                "Can't find Java page");
        swipeScreenUp(2000);
        swipeScreenUp(2000);
    }

    @Test
    public void addAndDeleteItemsToReadingList(){

        String[] searchLang = new String[]{"Java","Python"};
        final String readingListName = "Test list";
        String[] articleTitle = new String[searchLang.length];
        int deletingElement = 0;

        skipFirstScreen();

        for (int i = 0; i < searchLang.length; i++) {
            searchArticle(searchLang[i]);
            WebElement titleElement = waitForElementPresent(By.xpath("//*[contains(@text,'"+searchLang[i]+" (programming language)')]"),
                    "Can't find "+ searchLang[i] +" page");
            String titleText = titleElement.getAttribute("text");
            articleTitle[i] = titleText;
            waitForElementAndClick(By.xpath("//*[contains(@text,'"+searchLang[i]+" (programming language)')]"),
                    "Can't find "+ searchLang[i] +" page");
            addingToReadingList(10);
        }
        waitForElementPresent(By.xpath("//*[@resource-id='org.wikipedia:id/page_toolbar_button_show_overflow_menu']"),
                "Can't find three dots",
                10);
        waitForElementAndClick(By.xpath("//*[@resource-id='org.wikipedia:id/page_toolbar_button_show_overflow_menu']"),
                "Can't find three dots");
        waitForElementAndClick(By.xpath("//*[@resource-id='org.wikipedia:id/overflow_feed']"),
                "Can't find Explore button");
        waitForElementPresent(By.xpath("//*[@resource-id='org.wikipedia:id/smallLabel'][contains(@text,'Saved')]"),
                "you know",
                10);
        waitForElementAndClick(By.xpath("//*[@resource-id='org.wikipedia:id/smallLabel'][contains(@text,'Saved')]"),
                "Can't find way to saved articles");
        waitForElementPresent(By.xpath("//*[@resource-id='org.wikipedia:id/item_title'][contains(@text,'Saved')]"),
                "Can't find expected reading list",
                10);
        waitForElementAndClick(By.xpath("//*[@resource-id='org.wikipedia:id/item_title'][contains(@text,'Saved')]"),
                "Can't find expected reading list");
        waitForElementPresent(By.xpath("//*[contains(@text,'" + articleTitle[deletingElement] + "')]"),
                "Can't find some element for delete",
                20);

        swipeElementLeft(By.xpath("//*[contains(@text,'" + articleTitle[deletingElement] + "')]"),
                "Can't find some element for delete",
                1000);

        for (int i = 0; i < countElementOnScreen(By.id("org.wikipedia:id/page_list_item_title")); i++) {

            String title = "";
            WebElement title_element = waitForElementPresent(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title']["+(i+1)+"]"),
                    "Can't find element from reading list",
                    15);
            title = title_element.getAttribute("text");
            System.out.println(title);

            if (i != deletingElement){
                Assert.assertEquals(articleTitle[i],title);
                System.out.println(articleTitle[i]);
            }else{
                Assert.assertNotEquals(articleTitle[i] + " was delete",
                        title,
                        articleTitle[i]);
            }
        }


    }

    @Test
    public void checkArticleTitleExist(){
        String title = "//*[@resource-id='pcs']/android.view.View[1]/android.view.View[1]";

        skipFirstScreen();
        searchArticle("java");
        waitForElementAndClick(By.xpath("//*[contains(@text,'Java (programming language)')]"),
                "Cannot find existing article");
        assertElementPresent(By.xpath(title));

    }

    @Test
    public void checkTitleAfterRotation(){
        skipFirstScreen();
        searchArticle("Java");
        waitForElementAndClick(By.xpath("//*[contains(@text,'Java (programming language)')]"),
                "Cannot find existing article");
        String title_before_rotation = waitForElementAndGetAttribute(By.xpath("//*[@resource-id='pcs']/android.view.View[1]/android.view.View[1]"),
                "text",
                "Cannot take title by attribute",
                15);
        driver.rotate(ScreenOrientation.LANDSCAPE);
        waitForElementPresent(By.xpath("//*[@resource-id='pcs']/android.view.View[1]/android.view.View[1]"),
                "test",
                20);
        String title_after_rotation = waitForElementAndGetAttribute(By.xpath("//*[@resource-id='pcs']/android.view.View[1]/android.view.View[1]"),
                "text",
                "Cannot take title by attribute",
                15);
        Assert.assertEquals("Titles not equals",title_before_rotation, title_after_rotation);
    }

    private void addingToReadingList(long timeOut){
        waitForElementPresent(By.xpath("//*[@resource-id='org.wikipedia:id/article_menu_bookmark'][contains(@text,'Save')]"),
                "shit happens",
                timeOut);
        waitForElementAndClick(By.xpath("//*[@resource-id='org.wikipedia:id/article_menu_bookmark'][contains(@text,'Save')]"),
                "Can't find save article button");


    }
    private void searchArticle(String searchingWord){
        waitForElementPresent(By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Can't find 'Search Wikipedia' field",
                15);
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Can't find 'Search Wikipedia' field");
        //ввести в поле поиска слово
        waitForElementPresent(By.id(search_field_id),
                "Can't find search field",
                15);
        waitForElementAndSendKeys(
                By.id(search_field_id),
                "Can't find search field",
                searchingWord);
        waitForElementPresent(By.xpath("//*[@resource-id = 'org.wikipedia:id/page_list_item_title']"),
                "Can't find some result elements");
    }
    private void skipFirstScreen(){
        waitForElementAndClick(
                By.xpath(skip_button),
                "Can't find SKIP button on start screen");
    }
}
