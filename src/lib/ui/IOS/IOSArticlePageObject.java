package lib.ui.IOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSArticlePageObject extends ArticlePageObject {

    static {
        ARTICLE_TITLE = "id:Java (programming language)";
        EXPLORE_BTN = "xpath://XCUIElementTypeButton[@name='W']";
    }

    public IOSArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
