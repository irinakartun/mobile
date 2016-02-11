package pom;

import driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.thoughtworks.selenium.SeleneseTestBase.fail;

/**
 * Created by Admin on 07.02.2016.
 */
public class ArticlePage {

    public ArticlePage(){
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }


    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Wikipedia']")
    private MobileElement menuIcon;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Save the article for offline reading later']")
    private MobileElement saveIcon;


    public String getArticleHeader(){
        WebElement articleHeader = DriverManager.getDriver().findElement(By.className("android.widget.TextView"));
        return articleHeader.getText();
    }

    public void clickSaveArticleIcon(){
        saveIcon.click();
    }

    public Menu openMenu(){
        menuIcon.click();
        return new Menu();
    }

}
