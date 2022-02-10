package appPage.platformPage.android;

import appPage.SignUpPage;
import appPage.platformPage.BasePage;
import appPage.platformPage.PageObjectHelper;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utilities.Constant;

public class SignUpPageAndroid extends BasePage implements SignUpPage {

    public SignUpPageAndroid(MobileDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = Constant.APP_ID + "/tv_title")
    private MobileElement signUpAsEmployerTitle;

    @AndroidFindBy(id = Constant.APP_ID + "/label_varified_email")
    private MobileElement labelVerifiedEmail;

    @AndroidFindBy(id = Constant.APP_ID + "/et_first_name")
    private MobileElement firstName;

    @AndroidFindBy(id = Constant.APP_ID + "/et_last_name")
    private MobileElement lastName;

    @AndroidFindBy(id = Constant.APP_ID + "/et_email_address")
    private MobileElement emailAddress;

    @AndroidFindBy(id = Constant.APP_ID + "/et_password")
    private MobileElement password;

    @AndroidFindBy(id = Constant.APP_ID + "/tv_signup")
    private MobileElement signUpButton;

    @AndroidFindBy(id = Constant.APP_ID + "/et_company_name")
    private MobileElement companyNameField;

    @AndroidFindBy(id = Constant.APP_ID + "/et_company_address")
    private MobileElement companyWebsiteField;

    @AndroidFindBy(id = Constant.APP_ID + "/tv_login")
    private MobileElement continueButton;

    @AndroidFindBy(id = Constant.APP_ID + "/label_varified_number")
    private MobileElement labelVerifiedNumber;

    @AndroidFindBy(id = Constant.APP_ID + "/tv_country_code")
    private MobileElement countryCode;

    @AndroidFindBy(id = Constant.APP_ID + "/tv_toolbar_title")
    private MobileElement selectCodeTitle;

    @AndroidFindBy(id = Constant.APP_ID + "/et_country_name")
    private MobileElement searchCountryField;

    //@AndroidFindBy(xpath = "//android.widget.TextView[@id='com.jobget:id/tv_country_code' and contains(text(), '+91')]")
    //private MobileElement selectIndia;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.TextView[2]")
    private MobileElement selectIndia;

    @AndroidFindBy(id = Constant.APP_ID + "/et_phone_number")
    private MobileElement phoneNumberField;

    @AndroidFindBy(id = Constant.APP_ID + "/tv_send")
    private MobileElement addMobileNumberButton;

    @AndroidFindBy(id = Constant.APP_ID + "/label_varified_number")
    private MobileElement labelMobilePhoneVerification;

    @AndroidFindBy(id = Constant.APP_ID + "/et_phone_number")
    private MobileElement enter4DigitField;

    @AndroidFindBy(id = Constant.APP_ID + "/tv_send")
    private MobileElement finishButton;

    @AndroidFindBy(id = Constant.APP_ID + "/btn_ok")
    private MobileElement okPopUpButton;

    @AndroidFindBy(id = Constant.APP_ID + "/tv_title")
    private MobileElement popUpTitle;

    @Override
    public boolean isFirstNameFieldVisible(){
        return PageObjectHelper.isElementVisible(firstName);
    }

    @Override
    public boolean isLabelVerifiedEmailVisible(){
        return PageObjectHelper.isElementVisible(labelVerifiedEmail);
    }

    @Override
    public void typeOnFirstName(String name){
        firstName.sendKeys(name);
    }

    @Override
    public void typeOnLastName(String last_name){
        lastName.sendKeys(last_name);
    }

    @Override
    public void typeOnEmail(String email){
        emailAddress.sendKeys(email);
    }

    @Override
    public void typeOnPassword(String pass){
        password.sendKeys(pass);
    }

    @Override
    public void tapOnSignUpButton(){
        PageObjectHelper.tapOnElement(driver, signUpButton);
    }

    @Override
    public boolean isCompanyNameFieldVisible(){
        return PageObjectHelper.isElementVisible(companyNameField);
    }

    @Override
    public void typeOnCompanyName(String companyName){
        companyNameField.sendKeys(companyName);
    }

    @Override
    public void typeOnCompanyWebsite(String companyWebsite){
        companyWebsiteField.sendKeys(companyWebsite);
    }

    @Override
    public void tapOnContinueUpButton(){
        PageObjectHelper.tapOnElement(driver, continueButton);
    }

    @Override
    public boolean isLabelVerifiedNumberVisible(){
        return PageObjectHelper.isElementVisible(labelVerifiedNumber);
    }

    @Override
    public void tapOnCountryCodeDropDown(){
        PageObjectHelper.tapOnElement(driver, countryCode);
        PageObjectHelper.waitElementDisplayed(driver, selectCodeTitle);
    }

    @Override
    public void typeOnSearchCountryField(String country){
        searchCountryField.sendKeys(country);
    }

    @Override
    public void tapOnIndiaCountry(){
        PageObjectHelper.tapOnElement(driver, selectIndia);
    }

    @Override
    public void tapOnCountryName(String countryName){
        //TODO for any country
    }

    @Override
    public void typeOnPhoneNumberField(String phoneNumber){
        phoneNumberField.sendKeys(phoneNumber);
    }

    @Override
    public void tapOnContinueToAddNumberButton(){
        PageObjectHelper.tapOnElement(driver, addMobileNumberButton);
    }

    @Override
    public boolean isLabelMobilePhoneVerificationVisible(){
        return PageObjectHelper.isElementVisible(labelMobilePhoneVerification);
    }

    @Override
    public void typeOnEnter4DigitField(String otpCode){
        enter4DigitField.sendKeys(otpCode);
    }

    @Override
    public void tapOnFinishButton(){
        PageObjectHelper.tapOnElement(driver, finishButton);
    }

    @Override
    public void getPopUpText(){
        PageObjectHelper.getElementText(driver, popUpTitle);
    }

    @Override
    public boolean isCongratulationsTextPresent(){
        return PageObjectHelper.waitTextIsVisible(driver, popUpTitle, "CONGRATULATIONS!\n");
    }

    @Override
    public void tapOnOkPopUpButton(){
        PageObjectHelper.tapOnElement(driver, okPopUpButton);
    }

}
