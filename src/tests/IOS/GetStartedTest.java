package tests.IOS;

import lib.CoreTestCase;
import lib.IOSTestCase;
import lib.ui.WelcomePageObject;
import org.junit.Test;

public class GetStartedTest extends CoreTestCase {
    @Test
    public void testPassThroughWelcome(){
        WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
        WelcomePageObject.waitForPresentFreeEncyclopediaText();
        WelcomePageObject.clickNextBtn();
        WelcomePageObject.waitForPresentNewWaysText();
        WelcomePageObject.clickNextBtn();
        WelcomePageObject.waitForPresentSearchLangText();
        WelcomePageObject.clickNextBtn();
        WelcomePageObject.waitForPresentHelpMakeBetterText();
        WelcomePageObject.clickGetStartedBtn();
    }
}
