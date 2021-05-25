package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.SearchPageObject;
import lib.ui.WelcomePageObject;
import lib.ui.factories.SearchPageObjectFactory;
import lib.ui.factories.WelcomePageObjectFactory;
import org.junit.Test;

public class SearchTests extends CoreTestCase {
    @Test
    public void testCompareText(){


        if(!Platform.getInstance().isMW()){
            WelcomePageObject WelcomePageObject = WelcomePageObjectFactory.get(driver);
            WelcomePageObject.skipFirstScreen();
        }
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.checkSearchFieldText();
    }

    @Test
    public void testClearSearch(){
        String searchWord = "Appium";

        if(!Platform.getInstance().isMW()){
            WelcomePageObject WelcomePageObject = WelcomePageObjectFactory.get(driver);
            WelcomePageObject.skipFirstScreen();
        }
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.searchArticle(searchWord);
        SearchPageObject.checkMoreThanOneElementsOnResult();
        SearchPageObject.searchInputClear();


    }

    @Test
    public void testCheckSearchResultsTitles(){
        String searchWord = "java";
        if(!Platform.getInstance().isMW()){
            WelcomePageObject WelcomePageObject = WelcomePageObjectFactory.get(driver);
            WelcomePageObject.skipFirstScreen();
        }
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
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
        if(!Platform.getInstance().isMW()){
            WelcomePageObject WelcomePageObject = WelcomePageObjectFactory.get(driver);
            WelcomePageObject.skipFirstScreen();
        }
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(searchWord);
        SearchPageObject.waitForSearchResult("Java (programming language)");
    }
    @Test
    public void testSearchByTitleAndDescription(){
        String searchWord = "Java";
        if(!Platform.getInstance().isMW()){
            WelcomePageObject WelcomePageObject = WelcomePageObjectFactory.get(driver);
            WelcomePageObject.skipFirstScreen();
        }
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(searchWord);
        SearchPageObject.waitForElementByTitleAndDescription("Java", "Indonesian island");
        SearchPageObject.waitForElementByTitleAndDescription("JavaScript", "High-level programming language");
        SearchPageObject.waitForElementByTitleAndDescription("Java (programming language)", "Object-oriented programming language");
    }
}
