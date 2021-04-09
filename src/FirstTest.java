//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest {
    private AppiumDriver driver;

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
        this.driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


    }

    @After
    public void tearDown() {
        this.driver.quit();
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

        String search_word = "Appium";

        waitForElementAndClick(
                By.xpath(this.skip_button),
                "Can't find SKIP button on start screen");

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Can't find 'Search Wikipedia' field");

        waitForElementAndSendKeys(
                By.id(search_field_id),
                "Can't find search field",
                search_word);
        waitForElementPresent(By.xpath("//*[@resource-id = 'org.wikipedia:id/page_list_item_title']"),
                "Can't find some result elements");

        int count_elements = driver.findElements(By.xpath("//*[@resource-id = 'org.wikipedia:id/page_list_item_title']")).size();

        for (int i = 1; i <= count_elements; i++) {

            String k = Integer.toString(i);
            String xpath = "//*[@resource-id = 'org.wikipedia:id/search_results_list']/android.view.ViewGroup["+k+"]//*[@resource-id = 'org.wikipedia:id/page_list_item_title']";
            WebElement title_element = waitForElementPresent(By.xpath(xpath),
                    "Can't find title element for compare strings");
            String result_title = title_element.getAttribute("text");
            Assert.assertTrue("'"+result_title+"' not contain searching word '"+search_word+"'",
                    result_title.contains(search_word));

        }

    }

    private void checkCountElementsOnScreen(By by, String error_message, int expected_count) {
        int count_elements = driver.findElements(by).size();
        Assert.assertTrue(error_message, count_elements>expected_count);
    }


    private void assertElementHasText(By by, String error_message, String expected_text){
        WebElement title_element = waitForElementPresent(by, error_message);
        String title_text = title_element.getAttribute("text");
//        System.out.println(title_text);
        Assert.assertEquals(error_message,
                expected_text,
                title_text);
    };

    private void waitForElementAndClear(By by, String error_message){
        WebElement element = waitForElementPresent(by, error_message);
        element.clear();
    };
    private void waitForElementAndSendKeys(By by, String error_message, String value){
        WebElement element = waitForElementPresent(by, error_message);
        element.sendKeys(value);
    };
    private void waitForElementAndClick(By by, String error_message){
        WebElement element = waitForElementPresent(by, error_message);
        element.click();
    };
    private WebElement waitForElementPresent(By by, String error_message){
        return waitForElementPresent(by, error_message, 5);
    };
    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds ){
        WebDriverWait wait = new WebDriverWait(driver,timeoutInSeconds);
        wait.withMessage(error_message + "\n");

        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }
}
