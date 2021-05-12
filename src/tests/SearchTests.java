package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.StartPageObject;
import org.junit.Test;

public class SearchTests extends CoreTestCase {
    @Test
    public void testCompareText(){

        StartPageObject StartPageObject = new StartPageObject(driver);
        StartPageObject.checkAnnotationText();
        StartPageObject.skipFirstScreen();

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.checkSearchFieldText();
    }

    @Test
    public void testClearSearch(){
        String searchWord = "Appium";

        StartPageObject StartPageObject = new StartPageObject(driver);
        StartPageObject.skipFirstScreen();
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.searchArticle(searchWord);
        SearchPageObject.checkMoreThanOneElementsOnResult();
        SearchPageObject.searchInputClear();


    }

    @Test
    public void testCheckSearchResultsTitles(){
        String searchWord = "Java";

        StartPageObject StartPageObject = new StartPageObject(driver);
        StartPageObject.skipFirstScreen();
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
        StartPageObject StartPageObject = new StartPageObject(driver);
        StartPageObject.skipFirstScreen();
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(searchWord);
        SearchPageObject.waitForSearchResult("Java (programming language)");
    }
    @Test
    public void testSearchByTitleAndDescription(){
        String searchWord = "Java";
        StartPageObject StartPageObject = new StartPageObject(driver);
        StartPageObject.skipFirstScreen();
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(searchWord);
        SearchPageObject.waitForElementByTitleAndDescription("Java", "Indonesian island");
        SearchPageObject.waitForElementByTitleAndDescription("JavaScript", "High-level programming language");
        SearchPageObject.waitForElementByTitleAndDescription("Java (programming language)", "Object-oriented programming language");
    }
}
