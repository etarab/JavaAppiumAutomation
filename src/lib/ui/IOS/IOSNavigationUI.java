package lib.ui.IOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;

public class IOSNavigationUI extends NavigationUI {
    static {
        READING_LIST_PAGE_BTN = "id:Saved";
        ADD_TO_READING_LIST_BTN = "id:Save for later";
    }
    public IOSNavigationUI(AppiumDriver driver) {
        super(driver);
    }
}
