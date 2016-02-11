package pom;

import driver.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Admin on 10.02.2016.
 */
public class Menu {

    public Menu(){
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Saved pages']")
    private MobileElement savedPages;


    public SavedPages openSavedPages(){
        savedPages.click();
        return new SavedPages();
    }

}
