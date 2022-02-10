package appPage.platformPage.android;


import appPage.platformPage.BasePage;
import appPage.platformPage.PageObjectHelper;
import appPage.LoginPage;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utilities.Constant;

public class LoginPageAndroid extends BasePage implements LoginPage {

    public LoginPageAndroid(MobileDriver<MobileElement> driverInit) {
        super(driverInit);
    }

    /*Page Factory*/
    @AndroidFindBy(id = Constant.APP_ID + "/tv_welcome_back")
    private MobileElement loginTitle;

    @AndroidFindBy(id = Constant.APP_ID + "/et_email_address")
    private MobileElement emailAddress;

    @AndroidFindBy(id = Constant.APP_ID + "/et_password")
    private MobileElement password;

    @AndroidFindBy(id = Constant.APP_ID + "/iv_eye_show")
    private MobileElement showPassword;

    @AndroidFindBy(id = Constant.APP_ID + "/tv_forgot_password")
    private MobileElement forgotPassword;

    @AndroidFindBy(id = Constant.APP_ID + "/tv_login")
    private MobileElement loginButton;

    @AndroidFindBy(id = Constant.APP_ID + "/tv_login_facebook")
    private MobileElement loginWithFacebookButton;

    public boolean isLoginTitleVisible(){
        return PageObjectHelper.isElementVisible(loginTitle);
    }

    public void performLogin(String email, String pass){
        emailAddress.sendKeys(email);
        password.sendKeys(pass);
        PageObjectHelper.tapOnElement(driver, loginButton);
    }

    public void performLoginWithFacebook(){
        //TODO
    }
}
