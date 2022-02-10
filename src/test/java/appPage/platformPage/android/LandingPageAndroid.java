package appPage.platformPage.android;

import appPage.LandingPage;
import appPage.platformPage.BasePage;
import appPage.platformPage.PageObjectHelper;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utilities.Constant;

public class LandingPageAndroid extends BasePage implements LandingPage {

    public LandingPageAndroid(MobileDriver<MobileElement> driverInit) {
        super(driverInit);
    }

    /*Page Factory*/
    @AndroidFindBy(id = Constant.APP_ID + "/ivLanding")
    private MobileElement landingImage;

    @AndroidFindBy(id = Constant.APP_ID + "/ivLogoJobget")
    private MobileElement jobGetTitle;

    @AndroidFindBy(id = Constant.APP_ID + "/tvSignUp")
    private MobileElement signUpButton;

    @AndroidFindBy(id = Constant.APP_ID + "/tvLogin")
    private MobileElement loginButton;

    @AndroidFindBy(id = Constant.APP_ID + "/tvSignUp")
    private MobileElement continueToLoginButton;

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private MobileElement allowDeviceLocation;

    @AndroidFindBy(id = Constant.APP_ID + "/rlEmployer")
    private MobileElement hireCandidatesOption;

    @Override
    public boolean isLandingImageVisible(){
        return PageObjectHelper.isElementVisible(landingImage);
    }

    @Override
    public boolean isJobGetTitleVisible(){
        return PageObjectHelper.isElementVisible(jobGetTitle);
    }

    @Override
    public void tapOnLoginButton(){
        PageObjectHelper.tapOnElement(driver, loginButton);
    }

    @Override
    public void tapOnSignUpButton(){
        PageObjectHelper.tapOnElement(driver, signUpButton);
    }

    @Override
    public void tapOnContinueToLoginButton(){
        PageObjectHelper.tapOnElement(driver, continueToLoginButton);
    }

    @Override
    public void tapOnHireCandidates(){
        PageObjectHelper.tapOnElement(driver, hireCandidatesOption);
    }

}
