package driver; /**
 * Created by Admin on 07.02.2016.
 */
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import  static io.appium.java_client.remote.MobileCapabilityType.*;

public class DriverManager {

    private DriverManager(){};

    private static final String URI_SCHEME = "http://";
    private static final String WD_SERVER_ROOT = "/wd/hub";
    private static final ThreadLocal<AppiumDriver> driverPool = new ThreadLocal<>();

    public static void createAndroiDriver() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(NEW_COMMAND_TIMEOUT, "1200");
        caps.setCapability(DEVICE_READY_TIMEOUT, "1200");
        caps.setCapability(LAUNCH_TIMEOUT, "12000000");

        caps.setCapability(PLATFORM_NAME, "Android");
        caps.setCapability(PLATFORM_VERSION, "4.4");
        caps.setCapability(DEVICE_NAME, "android_phone");


//        caps.setCapability(APP_ACTIVITY,  ".ui.BookingActivity");
//        caps.setCapability(APP_WAIT_ACTIVITY, ".ui.BookingActivity");

        caps.setCapability(APP, "c:\\Users\\Admin\\mobile\\src\\main\\resources\\Wikipedia_apkpure.com.apk");

        AppiumDriver driver = new AndroidDriver(new URL(URI_SCHEME + "127.0.0.1:4723" + WD_SERVER_ROOT), caps);

        driverPool.set(driver);
        driverPool.get().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    public static AppiumDriver getDriver(){
        return driverPool.get();
    }

    public static void closeDriver(){
        WebDriver driver = driverPool.get();
        if (driver != null){
            driver.quit();
        }
    }



}
