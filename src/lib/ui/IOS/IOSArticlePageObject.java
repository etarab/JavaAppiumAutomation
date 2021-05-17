package lib.ui.IOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class IOSArticlePageObject extends ArticlePageObject {

    static {
        ARTICLE_TITLE = "id:Java (programming language)";
        EXPLORE_BTN = "xpath://XCUIElementTypeButton[@name='W']";
    }

    public IOSArticlePageObject(AppiumDriver driver) {
        super(driver);
    }
}
