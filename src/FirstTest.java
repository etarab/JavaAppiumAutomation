//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest {
    private AppiumDriver driver;

    public FirstTest() {
    }



    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "and80");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "/Users/etarabuhin/Documents/JavaAppiumAutomationHomework/apks/org.wikipedia.apk");
        this.driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() {
        this.driver.quit();
    }

    @Test
    public void firstTest() {
                System.out.println("First test run");
    }

    @Test
    public void compareTextTest(){
        assertElementHasTex(By.id("org.wikipedia:id/primaryTextView"),
                "Unexpected text. Compare finished with failed.",
                "The Free Encyclopedia\n" +
                        "…in over 300 languages");

        waitForElementAndClick(By.xpath("//*[contains(@text,'SKIP')]"),
                "Can't find SKIP button on start screen");

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Can't find 'Search Wikipedia' field");

        assertElementHasTex(By.id("org.wikipedia:id/search_src_text"),
                "Unexpected text. Compare search plate text finished with failed",
                "Search Wikipedia");
    }




    private void assertElementHasTex(By by, String error_message, String expected_text){
        WebElement title_element = waitForElementPresent(by, error_message);
        String title_text = title_element.getAttribute("text");
//        System.out.println(title_text);
        Assert.assertEquals("unexpected title on expected element",
                expected_text,
                title_text);
    };
    private void waitForElementAndClick(By by, String error_message){
        WebElement element = waitForElementPresent(by, error_message);
        element.click();
    };
    private WebElement waitForElementPresent(By by, String error_message){
        return waitForElementPresent(by, error_message, 5);
    };
    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds ){
        WebDriverWait wait = new WebDriverWait(driver,timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }
}
