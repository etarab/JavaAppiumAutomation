package tests;

import lib.CoreTestCase;
import lib.ui.*;
import org.junit.Assert;
import org.junit.Test;

public class MyListsTest extends CoreTestCase {
    @Test
    public void testAddAndDeleteItemsToReadingList(){

        String[] searchLang = new String[]{"Java","Python"};
        String[] articleTitle = new String[searchLang.length];
        int deletingElement = 0;

        WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
        WelcomePageObject.skipFirstScreen();
        NavigationUI NavigationUI = new NavigationUI(driver);

        for (int i = 0; i < searchLang.length; i++) {

            SearchPageObject SearchPageObject = new SearchPageObject(driver);
            SearchPageObject.searchArticle(searchLang[i]);
            articleTitle[i] = SearchPageObject.getLangArticleTitle(searchLang[i]);
            SearchPageObject.openLanguageArticlePage(searchLang[i]);
            NavigationUI.addingToReadingList();
        }

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.returnToMainPage();
        NavigationUI.goToSavedArticlesPageFromStartScreen();
        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);
        MyListsPageObject.goToDefaultReadingList();
        MyListsPageObject.deleteElementFromReadingList(articleTitle[deletingElement]);

        for (int i = 0; i < MyListsPageObject.countSearchResultsOnScreen(); i++) {

            String title = "";
            title = MyListsPageObject.getArticleTitleString(i+1);
            if (i != deletingElement){
                assertEquals(articleTitle[i],title);
            }else{
                Assert.assertNotEquals(articleTitle[i] + " was delete",
                        title,
                        articleTitle[i]);
            }
        }
    }
}
