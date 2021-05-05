package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyListsPageObject extends MainPageObject{
    private static final String
            ARTICLE_TITLE_OOM_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title'][{NUMBER}]",
            ARTICLE_TITLE_ITEM = "id:org.wikipedia:id/page_list_item_title",
            ARTICLE_TITLE_ON_RL = "xpath://*[contains(@text,'{TITLE}')]",
            DEFAULT_READING_LIST = "xpath://*[@resource-id='org.wikipedia:id/item_title'][contains(@text,'Saved')]";

    public MyListsPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void goToDefaultReadingList(){
        this.waitForElementPresent(DEFAULT_READING_LIST,
                "Can't find expected reading list",
                10);
        this.waitForElementAndClick(DEFAULT_READING_LIST,
                "Can't find expected reading list");
    }
    private String getArticleTitleElement(String articleTitle){
        return ARTICLE_TITLE_ON_RL.replace("{TITLE}",articleTitle);
    }
    public void deleteElementFromReadingList(String articleTitle){
        this.waitForElementPresent(getArticleTitleElement(articleTitle),
                "Can't find some element for delete",
                20);
        this.swipeElementLeft(getArticleTitleElement(articleTitle),
                "Can't find some element for delete",
                1000);
    }
    public int countSearchResultsOnScreen(){
        this.waitForElementPresent(ARTICLE_TITLE_ITEM,
                "Can't find some search results",10);
        return this.countElementOnScreen(ARTICLE_TITLE_ITEM);
    }
    private String getTitleItemFromList(int number_of_title){
        String number = Integer.toString(number_of_title);
        return ARTICLE_TITLE_OOM_TPL.replace("{NUMBER}",number);
    }
    public String getArticleTitleString(int number_of_title){
        WebElement title_element = this.waitForElementPresent(getTitleItemFromList(number_of_title),
                "Can't find title element for compare strings",10);
        return title_element.getAttribute("text");
    }



}
