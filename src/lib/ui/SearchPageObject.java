package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchPageObject extends MainPageObject {

    private static final String
            ONE_OF_MANY_RESULT_TITLE_TPL = "xpath://*[@resource-id = 'org.wikipedia:id/search_results_list']/android.view.ViewGroup[{NUMBER}]//*[@resource-id = 'org.wikipedia:id/page_list_item_title']",
            SEARCH_RESULT_TITLE = "xpath://*[@resource-id = 'org.wikipedia:id/page_list_item_title']",
            SEARCH_INIT_ELEMENT = "xpath://*[contains(@text,'Search Wikipedia')]",
            SEARCH_INPUT = "id:org.wikipedia:id/search_src_text",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[contains(@text,'{SUBSTRING}]')]",
            SEARCH_PLACE_HOLDER = "Search Wikipedia",
            ARTICLE_TITLE_RESULT_TPL = "xpath://*[contains(@text,'{SEARCHLANG} (programming language)')]";

    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }

    private static String getResultSearchElement(String substring){
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}",substring);
    }

    public void initSearchInput(){
        this.waitForElementPresent(SEARCH_INIT_ELEMENT,"Cannot search input after click",5);
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT,"Cannot find and click search init element", 5);
        this.waitForElementPresent(SEARCH_INIT_ELEMENT,"Cannot search input after click",5);
    }

    public void typeSearchLine(String search_line){
        this.waitForElementPresent(SEARCH_INPUT,"Cannot find search input",5);
        this.waitForElementAndSendKeys(SEARCH_INPUT,"Cannot find and type to search input",search_line,5);
    }

    public void waitForSearchResult(String substring){
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with substring " + substring);
    }
    public void clickByArticleWithSubstring(String substring){
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(search_result_xpath, "Cannot find and click search result with substring " + substring,10);
    }
    public void checkSearchFieldText(){
        this.assertElementHasText(SEARCH_INPUT,
                "Unexpected text. Compare search plate text finished with failed",
                SEARCH_PLACE_HOLDER);
    }
    public void checkMoreThanOneElementsOnResult(){
        this.waitForElementPresent(SEARCH_RESULT_TITLE,
                "Search results not found",5);
        this.checkMoreThanOneElementsOnScreen(SEARCH_RESULT_TITLE,
                "Just one element on screen");
    }
    public void searchInputClear(){
        this.waitForElementAndClear(
                SEARCH_INPUT,
                "can't find search field");
        this.assertElementHasText(SEARCH_INPUT,
                "Search field clearing is not works",
                "Search Wikipedia");
    }
    public int countSearchResultsOnScreen(){
        this.waitForElementPresent(SEARCH_RESULT_TITLE,
                "Can't find some search results",10);
        return this.countElementOnScreen(SEARCH_RESULT_TITLE);
    }
    private String getItemFromResultList(int number_of_title){
        String number = Integer.toString(number_of_title);
        return ONE_OF_MANY_RESULT_TITLE_TPL.replace("{NUMBER}",number);
    }

    public String getSearchResultTitleString(int number_of_title){
        WebElement title_element = this.waitForElementPresent(getItemFromResultList(number_of_title),
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
        this.waitForElementAndClick(getItemFromResultListByTitle(searchLang),
                "Can't find "+ searchLang +" page");
    }
    public String getLangArticleTitle(String searchLang){
        WebElement titleElement = this.waitForElementPresent(getItemFromResultListByTitle(searchLang),
                "Cannot find article with "+searchLang+" programming lang",
                5);
        return titleElement.getAttribute("text");

    }
    public void searchArticle(String searching_word){
        this.initSearchInput();
        this.typeSearchLine(searching_word);
    }

}
