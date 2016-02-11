package pom;

import driver.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.thoughtworks.selenium.SeleneseTestBase.fail;

/**
 * Created by Admin on 10.02.2016.
 */
public class SavedPages {

    public SavedPages(){
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    @AndroidFindBy(name = "No saved pages here!")
    private MobileElement noPagesHere;

    @AndroidFindBy(name = "Saved pages are pretty awesome. Think of them as bookmarks that you can read even when you are offline.")
    private MobileElement noPagesHereSub;

    @AndroidFindBy(className = "android.widget.TextView")
    private List<MobileElement> listOfSavedArticles;


    public void verifyArticleIsSaved(String title){
        boolean found = false;
        for (int i = 0; i < listOfSavedArticles.size(); i++ ){
            System.out.println(listOfSavedArticles.get(i).getText());
            if (listOfSavedArticles.get(i).getText().equals(title)){
                found = true;
                break;
            }
            else {
                continue;
            }
        }
        if (!found){
            fail("Specified article was not saved!");
        }
    }


    public ArticlePage openSavedArticle(String title){
        boolean found = false;
        for (int i = 0; i < listOfSavedArticles.size(); i++ ){
            if (listOfSavedArticles.get(i).getText().equals(title)){
                listOfSavedArticles.get(i).click();
                found = true;
                break;
            }
            else {
                continue;
            }
        }
        if (!found){
            fail("Specified article was not saved!");
        }
        return new ArticlePage();
    }

    public boolean verifyNothingIsSaved(){
        return (noPagesHere.isDisplayed() && noPagesHereSub.isDisplayed());
    }


}
