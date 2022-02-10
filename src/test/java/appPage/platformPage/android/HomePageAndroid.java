package appPage.platformPage.android;

import appPage.HomePage;
import appPage.platformPage.BasePage;
import appPage.platformPage.PageObjectHelper;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utilities.Constant;

public class HomePageAndroid extends BasePage implements HomePage {

    public HomePageAndroid(MobileDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = Constant.APP_ID + "/rv_my_job")
    private MobileElement jobPostingFrame;

    @AndroidFindBy(id = Constant.APP_ID + "/fab_new_job")
    private MobileElement postJobButton;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Profile\"]/android.widget.ImageView")
    private MobileElement profileOption;

    @AndroidFindBy(id = Constant.APP_ID + "/tv_settings")
    private MobileElement settings;

    @AndroidFindBy(id = Constant.APP_ID + "/tv_logout")
    private MobileElement logout;

    @AndroidFindBy(id = Constant.APP_ID + "/btn_yes")
    private MobileElement yesButton;

    @AndroidFindBy(id = Constant.APP_ID + "/btn_no")
    private MobileElement noButton;

    @Override
    public boolean isJobPostingFrameVisible(){
        return PageObjectHelper.isElementVisible(jobPostingFrame);
    }

    @Override
    public boolean isPostJobButtonVisible(){
        return PageObjectHelper.isElementVisible(postJobButton);
    }

    @Override
    public void navigateToLogoutOption(){
        PageObjectHelper.tapOnElement(driver, profileOption);
        PageObjectHelper.swipeScreen(driver, PageObjectHelper.Direction.DOWN);
        PageObjectHelper.tapOnElement(driver, settings);
    }

    @Override
    public void tapOnLogoutOption(){
        PageObjectHelper.tapOnElement(driver, logout);
    }

    @Override
    public void tapOnYesButton(){
        PageObjectHelper.tapOnElement(driver, yesButton);
    }
}
