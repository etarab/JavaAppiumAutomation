package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.Android.AndroidWelcomePageObject;
import lib.ui.IOS.IOSWelcomePageObject;
import lib.ui.WelcomePageObject;

public class WelcomePageObjectFactory {
    public static WelcomePageObject get(AppiumDriver driver){
        if (Platform.getInstance().isAndroid()){
            return new AndroidWelcomePageObject(driver);
        } else {
            return new IOSWelcomePageObject(driver);
        }
    }
}
