package lib.ui.Android;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class AndroidArticlePageObject extends ArticlePageObject {

    static {
                OPTIONS_BTN = "xpath://*[@resource-id='org.wikipedia:id/page_toolbar_button_show_overflow_menu']";
                EXPLORE_BTN = "xpath://*[@resource-id='org.wikipedia:id/overflow_feed']";
                ARTICLE_TITLE = "xpath://*[@resource-id='pcs']/android.view.View[1]/android.view.View[1]";
    }

    public AndroidArticlePageObject(AppiumDriver driver) {
        super(driver);
    }
}
