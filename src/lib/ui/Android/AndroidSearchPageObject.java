package lib.ui.Android;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class AndroidSearchPageObject extends SearchPageObject {

     static {
                ONE_OF_MANY_RESULT_TITLE_TPL = "xpath://*[@resource-id = 'org.wikipedia:id/search_results_list']/android.view.ViewGroup[{NUMBER}]//*[@resource-id = 'org.wikipedia:id/page_list_item_title']";
                SEARCH_RESULT_TITLE = "xpath://*[@resource-id = 'org.wikipedia:id/page_list_item_title']";
                SEARCH_INIT_ELEMENT = "xpath://*[contains(@text,'Search Wikipedia')]";
                SEARCH_INPUT = "id:org.wikipedia:id/search_src_text";
                SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[contains(@text,'{SUBSTRING}]')]";
                SEARCH_PLACE_HOLDER = "Search Wikipedia";
                ARTICLE_TITLE_RESULT_TPL = "xpath://*[contains(@text,'{SEARCHLANG} (programming language)')]";
                ARTICLE_TITLE_DESCRIPTION_RESULT_TPL = "xpath://*[@text = '{TITLE}']/following-sibling::android.widget.TextView[@text='{DESCRIPTION}']";
     }

    public AndroidSearchPageObject(AppiumDriver driver) {
        super(driver);
    }
}
