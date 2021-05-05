package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ArticlePageObject extends MainPageObject{

    private static final String
        OPTIONS_BTN = "xpath://*[@resource-id='org.wikipedia:id/page_toolbar_button_show_overflow_menu']",
        EXPLORE_BTN = "xpath://*[@resource-id='org.wikipedia:id/overflow_feed']",
        ARTICLE_TITLE = "xpath://*[@resource-id='pcs']/android.view.View[1]/android.view.View[1]";

    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    public void returnToMainPage(){
        this.waitForElementPresent(OPTIONS_BTN,
                "Can't find three dots",
                10);
        this.waitForElementAndClick(OPTIONS_BTN,
                "Can't find three dots");
        this.waitForElementAndClick(EXPLORE_BTN,
                "Can't find Explore button");
    }
    public  String getArticleTitleString(){
        this.waitForElementPresent(ARTICLE_TITLE,
                "Cannot find title by attribute",
                10);
        return this.waitForElementAndGetAttribute(ARTICLE_TITLE,
                "text",
                "Cannot take title by attribute",
                10);
    }
    public void checkArticleTitlePresent(){
        this.waitForElementPresent(ARTICLE_TITLE,"Cannot find title element",10);
        this.assertElementPresent(ARTICLE_TITLE);
    }
    public void swipePageDown(int timeOfSwipe){
        this.swipeScreenUp(timeOfSwipe);
    }
}
