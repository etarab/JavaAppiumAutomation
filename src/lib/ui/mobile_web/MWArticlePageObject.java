package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {
    static {
        OPTIONS_BTN = "xpath://*[@resource-id='org.wikipedia:id/page_toolbar_button_show_overflow_menu']";
        EXPLORE_BTN = "xpath://*[@resource-id='org.wikipedia:id/overflow_feed']";
        ARTICLE_TITLE = "xpath://*[@resource-id='pcs']/android.view.View[1]/android.view.View[1]";
    }
    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
