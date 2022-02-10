package utilities.driver.type;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Capabilities;
import utilities.Constant;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class RealDeviceDriverManager extends DriverManagerAbstract {

    // TODO: pendiente de implementar logica para real device
    @Override
    protected void createRemoteDriver(URL hub, Capabilities capabilities) {
        try {
            driver = new AppiumDriver<>(hub, capabilities);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
