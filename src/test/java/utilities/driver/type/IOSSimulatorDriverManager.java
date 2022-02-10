package utilities.driver.type;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Capabilities;
import utilities.Constant;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class IOSSimulatorDriverManager extends DriverManagerAbstract {

    @Override
    protected void createRemoteDriver(URL hub, Capabilities capabilities) {
        try {
            driver = new IOSDriver<>(hub, capabilities);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
