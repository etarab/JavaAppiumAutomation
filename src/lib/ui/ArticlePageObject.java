package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.By;

abstract public class ArticlePageObject extends MainPageObject{

    protected static String
        OPTIONS_BTN,
        EXPLORE_BTN,
        ARTICLE_TITLE;

    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    public void returnToMainPage(){
        if (Platform.getInstance().isAndroid()) {
            this.waitForElementPresent(OPTIONS_BTN,
                    "Can't find three dots",
                    10);
            this.waitForElementAndClick(OPTIONS_BTN,
                    "Can't find three dots");
        }
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
