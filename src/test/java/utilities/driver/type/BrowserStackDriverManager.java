package utilities.driver.type;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Capabilities;
import utilities.Constant;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserStackDriverManager extends DriverManagerAbstract {

    @Override
    protected void createRemoteDriver(URL hub, Capabilities capabilities) {
        try {
            driver = new AndroidDriver<MobileElement>(hub, capabilities);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
