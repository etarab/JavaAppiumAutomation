package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchPageObject extends MainPageObject {

    private static final String
            ONE_OF_MANY_RESULT_TITLE_TPL = "//*[@resource-id = 'org.wikipedia:id/search_results_list']/android.view.ViewGroup[{NUMBER}]//*[@resource-id = 'org.wikipedia:id/page_list_item_title']",
            SEARCH_RESULT_TITLE = "//*[@resource-id = 'org.wikipedia:id/page_list_item_title']",
            SEARCH_INIT_ELEMENT = "//*[contains(@text,'Search Wikipedia')]",
            SEARCH_INPUT = "org.wikipedia:id/search_src_text",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[contains(@text,'{SUBSTRING}]')]",
            SEARCH_PLACE_HOLDER = "Search Wikipedia",
            ARTICLE_TITLE_RESULT_TPL = "//*[contains(@text,'{SEARCHLANG} (programming language)')]",
            ARTICLE_TITLE_DESCRIPTION_RESULT_TPL = "//*[@text = '{TITLE}']/following-sibling::android.widget.TextView[@text='{DESCRIPTION}']";

    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }

    private static String getResultSearchElement(String substring){
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}",substring);
    }

    public void initSearchInput(){
        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT),"Cannot search input after click",5);
        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT),"Cannot find and click search init element", 5);
        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT),"Cannot search input after click",5);
    }

    public void typeSearchLine(String search_line){
        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT),"Cannot find search input",10);
        this.waitForElementAndSendKeys(By.xpath(SEARCH_INIT_ELEMENT),"Cannot find and type to search input",search_line,5);
    }

    public void waitForSearchResult(String substring){
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath), "Cannot find search result with substring " + substring);
    }
    public void clickByArticleWithSubstring(String substring){
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(By.xpath(search_result_xpath), "Cannot find and click search result with substring " + substring,10);
    }
    public void checkSearchFieldText(){
        this.assertElementHasText(By.id(SEARCH_INPUT),
                "Unexpected text. Compare search plate text finished with failed",
                SEARCH_PLACE_HOLDER);
    }
    public void checkMoreThanOneElementsOnResult(){
        this.waitForElementPresent(By.xpath(SEARCH_RESULT_TITLE),
                "Search results not found",5);
        this.checkMoreThanOneElementsOnScreen(By.xpath(SEARCH_RESULT_TITLE),
                "Just one element on screen");
    }
    public void searchInputClear(){
        this.waitForElementAndClear(
                By.id(SEARCH_INPUT),
                "can't find search field");
        this.assertElementHasText(By.id(SEARCH_INPUT),
                "Search field clearing is not works",
                "Search Wikipedia");
    }
    public int countSearchResultsOnScreen(){
        this.waitForElementPresent(By.xpath(SEARCH_RESULT_TITLE),
                "Can't find some search results",10);
        return this.countElementOnScreen(By.xpath(SEARCH_RESULT_TITLE));
    }
    private String getItemFromResultList(int number_of_title){
        String number = Integer.toString(number_of_title);
        return ONE_OF_MANY_RESULT_TITLE_TPL.replace("{NUMBER}",number);
    }

    public String getSearchResultTitleString(int number_of_title){
        WebElement title_element = this.waitForElementPresent(By.xpath(getItemFromResultList(number_of_title)),
                "Can't find title element for compare strings",10);
        return title_element.getAttribute("text");
    }
    public String getSearchResultTitleString(){
        return getSearchResultTitleString(1);
    }
    public String getItemFromResultListByTitle(String searchLang){
        return ARTICLE_TITLE_RESULT_TPL.replace("{SEARCHLANG}",searchLang);
    }
    public void openLanguageArticlePage(String searchLang){
        this.waitForElementAndClick(By.xpath(getItemFromResultListByTitle(searchLang)),
                "Can't find "+ searchLang +" page");
    }
    public void waitArticleTitleInResult(String searchLang){
        this.waitForElementPresent(By.xpath(getItemFromResultListByTitle(searchLang)),
                "Can't find "+ searchLang +" page");
    }
    public String getLangArticleTitle(String searchLang){
        WebElement titleElement = this.waitForElementPresent(By.xpath(getItemFromResultListByTitle(searchLang)),
                "Cannot find article with "+searchLang+" programming lang",
                5);
        return titleElement.getAttribute("text");

    }
    public String getItemFromResultListByTitleDescription(String search_title, String search_description){
        return ARTICLE_TITLE_DESCRIPTION_RESULT_TPL.replace("{TITLE}",search_title).replace("{DESCRIPTION}",search_description);
    }
    public void waitForElementByTitleAndDescription(String search_title, String search_description){
        this.waitForElementPresent(By.xpath(getItemFromResultListByTitleDescription(search_title,search_description)),
                "Can't find title '"+ search_title +"' or description of article '"+search_description+"' in search results",10);
    }
    public void searchArticle(String searching_word){
        this.initSearchInput();
        this.typeSearchLine(searching_word);
    }

}
