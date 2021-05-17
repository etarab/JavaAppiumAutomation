package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.WelcomePageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import lib.ui.factories.WelcomePageObjectFactory;
import org.junit.Test;

public class ChangeAppConditionsTests extends CoreTestCase {
    @Test
    public void testCheckTitleAfterRotation(){
        String searchWord = "Java";

        WelcomePageObject WelcomePageObject = WelcomePageObjectFactory.get(driver);
        WelcomePageObject.skipFirstScreen();
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.searchArticle(searchWord);
        SearchPageObject.openLanguageArticlePage(searchWord);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        String title_before_rotation = ArticlePageObject.getArticleTitleString();
        this.rotateScreenLandscape();
        String title_after_rotation = ArticlePageObject.getArticleTitleString();
        assertEquals("Titles not equals",title_before_rotation, title_after_rotation);
    }
}
