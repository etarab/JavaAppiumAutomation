package lib.ui.Android;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;

public class AndroidNavigationUI extends NavigationUI {
    static {
        READING_LIST_PAGE_BTN = "xpath://*[@resource-id='org.wikipedia:id/smallLabel'][contains(@text,'Saved')]";
        ADD_TO_READING_LIST_BTN = "xpath://*[@resource-id='org.wikipedia:id/article_menu_bookmark'][contains(@text,'Save')]";
    }

    public AndroidNavigationUI(AppiumDriver driver) {
        super(driver);
    }
}
