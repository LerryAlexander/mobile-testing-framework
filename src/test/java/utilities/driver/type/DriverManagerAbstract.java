package utilities.driver.type;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Capabilities;
import java.net.URL;

public abstract class DriverManagerAbstract {
    protected AppiumDriver<MobileElement> driver;

    protected abstract void createRemoteDriver(URL url, Capabilities capabilities);

    /**
     * Init remote driver from URL with capabilities
     * @param hub URL Hub
     * @param capabilities
     * @return AppiumDriver<MobileElement> driver
     */
    public AppiumDriver<MobileElement> getNewRemoteDriver(final URL hub, final Capabilities capabilities) {
        if (null != driver) {
            destroyDriver();
        }
        createRemoteDriver(hub, capabilities);
        return driver;
    }

    /**
     * Destroy the driver
     */
    public void destroyDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
