package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.Android.AndroidMyListPageObject;
import lib.ui.IOS.IOSMyListPageObject;
import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;


public class MyListPageObjectFactory {
    public static MyListsPageObject get(RemoteWebDriver driver){
        if(Platform.getInstance().isAndroid()) {
            return new AndroidMyListPageObject(driver);
        } else {
            return new IOSMyListPageObject(driver);
        }
    }
}
