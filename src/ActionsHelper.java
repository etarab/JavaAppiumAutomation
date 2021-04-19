import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsHelper {
    protected static AndroidDriver driver;


    public void checkCountElementsOnScreen(By by, String error_message, int expected_count) {
        int count_elements = driver.findElements(by).size();
        Assert.assertTrue(error_message, count_elements>expected_count);
    }


    public void assertElementHasText(By by, String error_message, String expected_text){
        WebElement title_element = waitForElementPresent(by, error_message);
        String title_text = title_element.getAttribute("text");
        Assert.assertEquals(error_message,
                expected_text,
                title_text);
    };

    public void waitForElementAndClear(By by, String error_message, long timeOut){
        WebElement element = waitForElementPresent(by, error_message, timeOut);
        element.clear();
    };
    public void waitForElementAndClear(By by, String error_message){
        WebElement element = waitForElementPresent(by, error_message);
        element.clear();
    };
    public void waitForElementAndSendKeys(By by, String error_message, String value, long timeOut){
        WebElement element = waitForElementPresent(by, error_message, timeOut);
        element.sendKeys(value);
    };
    public void waitForElementAndSendKeys(By by, String error_message, String value){
        WebElement element = waitForElementPresent(by, error_message);
        element.sendKeys(value);
    };
    public void waitForElementAndClick(By by, String error_message){
        WebElement element = waitForElementPresent(by, error_message);
        element.click();
    };
    public void waitForElementAndClick(By by, String error_message,long timeOut){
        WebElement element = waitForElementPresent(by, error_message,timeOut);
        element.click();
    };
    public WebElement waitForElementPresent(By by, String error_message){
        return waitForElementPresent(by, error_message, 5);
    };
    public WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds ){
        WebDriverWait wait = new WebDriverWait(driver,timeoutInSeconds);
        wait.withMessage(error_message + "\n");

        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    protected void swipeScreenUp(int timeOfSwipe){
        TouchAction action = new TouchAction(driver);

        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int start_y = (int) (size.height * 0.8);
        int end_y = (int) (size.height * 0.2);


        action.press(x,start_y).waitAction(timeOfSwipe).moveTo(x,end_y).release().perform();
    }
    protected void swipeElementLeft(By by, String error_message, int timeOfSwipe){
        WebElement element = waitForElementPresent(by, error_message);
        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int up_y = element.getLocation().getY();
        int down_y = up_y + element.getSize().getHeight();
        int middle_y = (up_y + down_y) / 2;

        TouchAction action = new TouchAction(driver);
        action
                .press(right_x,middle_y)
                .waitAction(timeOfSwipe)
                .moveTo(left_x,middle_y)
                .release()
                .perform();



    }
}
