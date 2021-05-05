package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.WelcomePageObject;
import org.junit.Test;

public class ArticleTests extends CoreTestCase {

    @Test
    public void testCheckSwipeAction(){

        String searchWord = "Java";

        WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
        WelcomePageObject.skipFirstScreen();
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.searchArticle(searchWord);
        SearchPageObject.openLanguageArticlePage(searchWord);
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.swipePageDown(2000);
    }


    @Test
    public void testCheckArticleTitleExist(){
        String searchWord = "Java";

        WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
        WelcomePageObject.skipFirstScreen();
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.searchArticle(searchWord);
        SearchPageObject.openLanguageArticlePage(searchWord);
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.checkArticleTitlePresent();

    }
}
