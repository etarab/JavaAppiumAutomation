package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

abstract public class NavigationUI extends MainPageObject{

    protected static String
            READING_LIST_PAGE_BTN,
            ADD_TO_READING_LIST_BTN;
    public NavigationUI(AppiumDriver driver) {
        super(driver);
    }
    public void addingToReadingList(){
        this.waitForElementPresent(ADD_TO_READING_LIST_BTN,
                "Can't find save article button",
                10);
        this.waitForElementAndClick(ADD_TO_READING_LIST_BTN,
                "Can't click save article button");
    }
    public void goToSavedArticlesPageFromStartScreen(){
        this.waitForElementPresent(READING_LIST_PAGE_BTN,
                "Can't find way to saved articles",
                10);
        this.waitForElementAndClick(READING_LIST_PAGE_BTN,
                "Can't find way to saved articles (CLICK)");
    }
}
