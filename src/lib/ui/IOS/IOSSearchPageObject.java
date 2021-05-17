package lib.ui.IOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class IOSSearchPageObject extends SearchPageObject {

    static {
        SEARCH_INIT_ELEMENT = "id:Search Wikipedia";
        SEARCH_INPUT = "xpath://XCUIElementTypeButton[@name='Cancel']/preceding-sibling::XCUIElementTypeSearchField";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeStaticText[contains(@name,'{SUBSTRING}')]";
        SEARCH_PLACE_HOLDER = "Search Wikipedia";
        ONE_OF_MANY_RESULT_TITLE_TPL = "xpath://XCUIElementTypeCell[{NUMBER}}]/XCUIElementTypeOther[2]/XCUIElementTypeStaticText[1]";
        SEARCH_RESULT_TITLE = "xpath://XCUIElementTypeStaticText";

        ARTICLE_TITLE_RESULT_TPL = "xpath://XCUIElementTypeStaticText[contains(@name,'{SEARCHLANG} (programming language)')]";
//        ARTICLE_DESCRIPTION_RESULT_TPL = "xpath://XCUIElementTypeStaticText[contains(@name,'{SEARCHLANG} (programming language)')]/following-sibling::XCUIElementTypeStaticText";
        ARTICLE_TITLE_DESCRIPTION_RESULT_TPL = "xpath://*[@text = '{TITLE}']/following-sibling::android.widget.TextView[@text='{DESCRIPTION}']";

    }

    public IOSSearchPageObject(AppiumDriver driver) {
        super(driver);
    }
}
