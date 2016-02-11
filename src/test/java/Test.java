import driver.DriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pom.ArticlePage;
import pom.HomePage;
import pom.Menu;
import pom.SavedPages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Admin on 07.02.2016.
 */

public class Test {

    @BeforeClass
    public void initDriver(){
        try {
            DriverManager.createAndroiDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.testng.annotations.Test
    public void saveArticle() {
        HomePage homePage = new HomePage();
        homePage.searchForArticle("napoleone");
        ArticlePage articlePage = homePage.selectArticle("Napoleone Colajanni");
        assertEquals(articlePage.getArticleHeader(), "Napoleone Colajanni\n" + "Italian criminologist");
        articlePage.clickSaveArticleIcon();
        Menu menu = articlePage.openMenu();
        SavedPages savedPages = menu.openSavedPages();
        savedPages.verifyArticleIsSaved("Napoleone Colajanni");
        ArticlePage articlePage1 = savedPages.openSavedArticle("Napoleone Colajanni");
        articlePage1.clickSaveArticleIcon();
        Menu menu1 = articlePage1.openMenu();
        SavedPages savedPages1 = menu1.openSavedPages();
        assertTrue(savedPages1.verifyNothingIsSaved());
    }

    @AfterClass
    public void closeDriver(){
        DriverManager.closeDriver();
    }
}
