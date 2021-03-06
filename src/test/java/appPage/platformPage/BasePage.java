package appPage.platformPage;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public MobileDriver<MobileElement> driver;

    public BasePage(MobileDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, utilities.Constant.WAIT_UNTIL_DECORATOR), this);
    }

    public MobileDriver<MobileElement> getDriver() {
        return driver;
    }
}
