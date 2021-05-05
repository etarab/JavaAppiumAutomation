package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.WelcomePageObject;
import org.junit.Test;

public class SearchTests extends CoreTestCase {
    @Test
    public void testCompareText(){

        WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
        WelcomePageObject.checkAnnotationText();
        WelcomePageObject.skipFirstScreen();

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.checkSearchFieldText();
    }

    @Test
    public void testClearSearch(){
        String searchWord = "Appium";

        WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
        WelcomePageObject.skipFirstScreen();
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.searchArticle(searchWord);
        SearchPageObject.checkMoreThanOneElementsOnResult();
        SearchPageObject.searchInputClear();


    }

    @Test
    public void testCheckSearchResultsTitles(){
        String searchWord = "Java";

        WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
        WelcomePageObject.skipFirstScreen();
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.searchArticle(searchWord);
        int amount_search_results = SearchPageObject.countSearchResultsOnScreen();

        for (int i = 1; i <= amount_search_results; i++) {
            String result_title = SearchPageObject.getSearchResultTitleString(i);
            assertTrue("'"+result_title+"' not contain searching word '"+searchWord+"'",
                    result_title.contains(searchWord));
        }

    }

    @Test
    public void testSearch(){
        String searchWord = "Java";
        WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
        WelcomePageObject.skipFirstScreen();
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(searchWord);
        SearchPageObject.waitForSearchResult("Java (programming language)");
    }
}
