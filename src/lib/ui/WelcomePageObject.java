package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.omg.PortableServer.THREAD_POLICY_ID;
import org.openqa.selenium.By;

public class WelcomePageObject extends MainPageObject{

    private static final String
            //IOS
            NEXT_BTN_NAME = "name:Next",
            LEARN_MORE_TEXT_NAME = "name:Learn more about Wikipedia",
            FREE_ENC_TEXT_ID = "id:The free encyclopedia",
            NEW_WAYS_TEXT_ID = "id:New ways to explore",
            SEARCH_LANG_TEXT_ID = "id:Search in over 300 languages",
            HELP_MAKE_BETTER_TEXT_ID = "id:Help make the app better",
            GET_STARTED_BTN_NAME = "name:Get started",
            //Android
            HELLO_TEXT_ELEMENT = "id:org.wikipedia:id/primaryTextView",
            HELLO_TEXT = "The Free Encyclopedia\n" +
            "…in over 300 languages",
            SKIP_BTN = "xpath://*[contains(@text,'SKIP')]";


    public WelcomePageObject(AppiumDriver driver) {
        super(driver);
    }
    public void skipFirstScreen(){
        this.waitForElementAndClick(
                SKIP_BTN,
                "Can't find SKIP button on start screen");
    }
    public void checkAnnotationText(){
        this.assertElementHasText(HELLO_TEXT_ELEMENT,
                "Unexpected text. Compare finished with failed.",
                HELLO_TEXT);
    }
    public void waitForPresentFreeEncyclopediaText(){
        this.waitForElementPresent(FREE_ENC_TEXT_ID,
                "Cannot find 'Free Encyclopedia' text");
    }
    public void waitForPresentNewWaysText(){
        this.waitForElementPresent(NEW_WAYS_TEXT_ID,
                "Cannot find 'new ways' text");
    }
    public void waitForPresentSearchLangText(){
        this.waitForElementPresent(SEARCH_LANG_TEXT_ID,
                "Cannot find 'search in over 300 languages' text");
    }
    public void waitForPresentHelpMakeBetterText(){
        this.waitForElementPresent(HELP_MAKE_BETTER_TEXT_ID,
                "Cannot find 'Help make the app better' text");
    }
    public void clickNextBtn(){
        this.waitForElementAndClick(NEXT_BTN_NAME,
                "Cannot find 'NEXT' button");
    }
    public void clickGetStartedBtn(){
        waitForElementAndClick(GET_STARTED_BTN_NAME,
                "Cannot find 'get started' button"
        );
    }




}
