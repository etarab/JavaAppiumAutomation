package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.*;
import org.junit.Assert;
import org.junit.Test;

public class MyListsTest extends CoreTestCase {
    @Test
    public void testAddAndDeleteItemsToReadingList(){

        String[] searchLang = new String[]{"Java","Python"};
        String[] articleTitle = new String[searchLang.length];
        String[] article_card_text = new String[searchLang.length];
        int deletingElement = 1;

        WelcomePageObject WelcomePageObject = WelcomePageObjectFactory.get(driver);
        WelcomePageObject.skipFirstScreen();
        NavigationUI NavigationUI = NavigationUIFactory.get(driver);

        for (int i = 0; i < searchLang.length; i++) {

            SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
            SearchPageObject.searchArticle(searchLang[i]);
            articleTitle[i] = SearchPageObject.getLangArticleTitle(searchLang[i]);
            article_card_text[i] = articleTitle[i] + " " + SearchPageObject.getLangArticleDescription(searchLang[i]);
            SearchPageObject.openLanguageArticlePage(searchLang[i]);
            NavigationUI.addingToReadingList();
        }

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.returnToMainPage();
        NavigationUI.goToSavedArticlesPageFromStartScreen();
        MyListsPageObject MyListsPageObject = MyListPageObjectFactory.get(driver);

        if(Platform.getInstance().isAndroid()){
            MyListsPageObject.goToDefaultReadingList();
        } else {
            MyListsPageObject.closeRLSyncPopup();
        }

        MyListsPageObject.deleteElementFromReadingList(articleTitle[deletingElement]);

        for (int i = 0; i < MyListsPageObject.countSearchResultsOnScreen(searchLang[searchLang.length - (deletingElement + 1)]); i++) {

            String full_description = "";
            full_description = MyListsPageObject.getArticleTitleString(i+1) + " " + MyListsPageObject.getLangArticleDescription(i+1);
            if (i != deletingElement){
                assertEquals(article_card_text[i],full_description);
            }else{
                Assert.assertNotEquals(articleTitle[i] + " was delete",
                        full_description,
                        article_card_text[i]);
            }
        }
    }
}
