package appPage.platformPage.ios;


import appPage.LoginPage;
import appPage.platformPage.BasePage;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginPageiOS extends BasePage implements LoginPage {


    public LoginPageiOS(MobileDriver<MobileElement> driverInit) {
        super(driverInit);
    }

    /*Page Factory*/
    @iOSXCUITFindBy(id = "exampleIOSID")
    private MobileElement exampleIOSElement;

    @Override
    public boolean isLoginTitleVisible() {
        //TODO actions for ios
        return false;
    }

    @Override
    public void performLogin(String email, String pass) {
        //TODO actions for ios
    }

    @Override
    public void performLoginWithFacebook() {
        //TODO actions for ios
    }
}
