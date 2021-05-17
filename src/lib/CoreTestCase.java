package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public class CoreTestCase extends TestCase{
    private static final String
            PLATFORM_IOS = "ios",
            PLATFORM_ANDROID = "android";
    protected AppiumDriver driver;


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        driver = Platform.getInstance().getDriver();
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    @Override
    protected void tearDown() throws Exception {
        driver.quit();

        super.tearDown();
    }

    protected void rotateScreenPortrait(){
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    protected void rotateScreenLandscape(){
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }
    protected void backgroundApp(int seconds){
        driver.runAppInBackground(Duration.ofMillis(seconds));
    }

//    private AppiumDriver getDriverByPlatformEnv(DesiredCapabilities capabilities) throws  Exception{
//       String platform = System.getenv("PLATFORM");
//       if (platform.equals(PLATFORM_ANDROID)){
//           driver = new AndroidDriver(new URL(AppiumURL), capabilities);
//       }else if(platform.equals(PLATFORM_IOS)){
//           driver = new IOSDriver(new URL(AppiumURL), capabilities);
//       }else{
//           throw new Exception("Cannot get run platform from env variable. Platform value " + platform);
//       }
//       return driver;
//    }
}
