package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.StartPageObject;
import org.junit.Test;

public class ChangeAppConditionsTests extends CoreTestCase {
    @Test
    public void testCheckTitleAfterRotation(){
        String searchWord = "Java";

        StartPageObject StartPageObject = new StartPageObject(driver);
        StartPageObject.skipFirstScreen();
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.searchArticle(searchWord);
        SearchPageObject.openLanguageArticlePage(searchWord);
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        String title_before_rotation = ArticlePageObject.getArticleTitleString();
        this.rotateScreenLandscape();
        String title_after_rotation = ArticlePageObject.getArticleTitleString();
        assertEquals("Titles not equals",title_before_rotation, title_after_rotation);
    }
}
