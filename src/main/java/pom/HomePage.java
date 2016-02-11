package pom;

import driver.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Admin on 07.02.2016.
 */
public class HomePage {

    public HomePage(){
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }


    @AndroidFindBy(className = "android.widget.TextView")
    private MobileElement searchField;

    @AndroidFindBy(className = "android.widget.ListView")
    private List<MobileElement> listResults;


    public void searchForArticle(String key){
        searchField.click();
        searchField.sendKeys(key);
    }

    public ArticlePage selectArticle(String title){
        WebElement article = DriverManager.getDriver().findElement(By.xpath("//android.widget.TextView[@text='" + title + "']"));
        article.click();
        return new ArticlePage();
    }


}
