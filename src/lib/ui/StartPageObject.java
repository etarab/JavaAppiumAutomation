package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class StartPageObject extends MainPageObject{

    private static final String

            HELLO_TEXT_ELEMENT = "org.wikipedia:id/primaryTextView",
            HELLO_TEXT = "The Free Encyclopedia\n" +
            "…in over 300 languages",
            SKIP_BTN = "//*[contains(@text,'SKIP')]";

    public StartPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void skipFirstScreen(){
        this.waitForElementAndClick(
                By.xpath(SKIP_BTN),
                "Can't find SKIP button on start screen");
    }

    public void checkAnnotationText(){
        this.assertElementHasText(By.id(HELLO_TEXT_ELEMENT),
                "Unexpected text. Compare finished with failed.",
                HELLO_TEXT);
    }


}
