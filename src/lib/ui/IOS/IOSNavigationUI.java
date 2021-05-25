package lib.ui.IOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSNavigationUI extends NavigationUI {
    static {
        READING_LIST_PAGE_BTN = "id:Saved";
        ADD_TO_READING_LIST_BTN = "id:Save for later";
    }
    public IOSNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }
}
