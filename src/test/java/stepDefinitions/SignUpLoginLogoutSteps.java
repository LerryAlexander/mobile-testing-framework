package stepDefinitions;

import appPage.HomePage;
import appPage.LandingPage;
import appPage.LoginPage;
import appPage.SignUpPage;
import appPage.platformPage.android.HomePageAndroid;
import appPage.platformPage.android.LandingPageAndroid;
import appPage.platformPage.android.LoginPageAndroid;
import appPage.platformPage.android.SignUpPageAndroid;
import appPage.platformPage.ios.LoginPageiOS;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.Constant;
import utilities.Hooks;
import utilities.RandomData;

public class SignUpLoginLogoutSteps extends BaseSteps{

    private LoginPage loginPage;
    private HomePage homePage;
    private LandingPage landingPage;
    private SignUpPage signUpPage;
    private Hooks hooks;

    private RandomData randomData = new RandomData();

    //Data to be used in the test
    private String firstName = randomData.firstName();
    private String lastName = randomData.lastName();
    private String email = randomData.email();
    private String password = Constant.PASSWORD;
    private String companyName = randomData.companyName();
    private String companyWebsite = randomData.companyWebsite().replace(" ","").replace(",","").replace("&","");
    private String phoneCountryName = "India";
    private String phoneNumber = Constant.INDIA_PHONE_NUMBER;
    private String otpCode = Constant.DEFAULT_OTP;

    public SignUpLoginLogoutSteps(Hooks hooks){
        super(hooks);
        this.hooks = hooks;
        randomData = new RandomData();
        switch (Constant.PLATFORM.toLowerCase()) {
            case "android":
                loginPage = new LoginPageAndroid(driver);
                homePage = new HomePageAndroid(driver);
                landingPage = new LandingPageAndroid(driver);
                signUpPage = new SignUpPageAndroid(driver);
                break;
            case "ios" :
                loginPage = new LoginPageiOS(driver); //example on how to initiate page object for iOS
                //TODO for iOS page objects
                break;
        }
    }

    @Given("The landing screen is displayed")
    public void the_landing_screen_is_displayed() {
        Assert.assertTrue("Landing image should be displayed", landingPage.isLandingImageVisible());
        Assert.assertTrue("JobGet title should be displayed", landingPage.isJobGetTitleVisible());
    }

    @Given("The user navigates to login screen as an employer")
    public void the_user_navigates_to_login_screen_as_an_employer() {
        landingPage.tapOnLoginButton();
        landingPage.tapOnHireCandidates();
        landingPage.tapOnContinueToLoginButton();
        Assert.assertTrue("Login title should be visible, but it was not", loginPage.isLoginTitleVisible());
    }

    @Then("The app should redirect the employer to My Job Posting screen")
    public void the_app_should_redirect_the_employer_to_My_Job_Posting_screen() {
        Assert.assertTrue("Job Posting frame should be visible but it was not", homePage.isJobPostingFrameVisible());
        Assert.assertTrue("Post Job button should be visible, but it was not", homePage.isPostJobButtonVisible());
    }

    @When("The employer navigates to profile --> settings")
    public void the_employer_navigates_to_profile_settings() {
        homePage.navigateToLogoutOption();
    }

    @When("The employer selects Logout option")
    public void the_employer_selects_Logout_option() {
        homePage.tapOnLogoutOption();
    }

    @When("The employer confirms he wants to logout")
    public void the_employer_confirms_he_wants_to_logout() {
        homePage.tapOnYesButton();
    }

    @When("The user navigates to sign up as an employer screen")
    public void the_user_navigates_to_sign_up_as_an_employer_screen() {
        landingPage.tapOnSignUpButton();
        landingPage.tapOnHireCandidates();
        landingPage.tapOnSignUpButton();
        //Assert.assertTrue("First name field should be visible", signUpPage.isFirstNameFieldVisible());
    }

    @When("The employer enters all his personal info")
    public void the_employer_enters_all_his_personal_info() {
        signUpPage.typeOnFirstName(firstName);
        signUpPage.typeOnLastName(lastName);
        signUpPage.typeOnEmail(email);
        signUpPage.typeOnPassword(password);
        signUpPage.tapOnSignUpButton();
        Assert.assertTrue("Company name field should be visible but it was not", signUpPage.isCompanyNameFieldVisible());
    }

    @When("The employer enters company info")
    public void the_employer_enters_company_info() {
        signUpPage.typeOnCompanyName(companyName);
        signUpPage.typeOnCompanyWebsite(companyWebsite);
        signUpPage.tapOnContinueUpButton();
        Assert.assertTrue("Verified Number label should be visible but it was not", signUpPage.isLabelVerifiedNumberVisible());
    }

    @When("The employer enters his mobile number")
    public void the_employer_enters_his_mobile_number() {
        signUpPage.tapOnCountryCodeDropDown();
        signUpPage.typeOnSearchCountryField(phoneCountryName);
        signUpPage.tapOnIndiaCountry();
        signUpPage.typeOnPhoneNumberField(phoneNumber);
        signUpPage.tapOnContinueToAddNumberButton();
        Assert.assertTrue("Mobile Phone Verification label should be visible, but it was not", signUpPage.isLabelMobilePhoneVerificationVisible());
    }

    @When("The employer completes the mobile phone verification")
    public void the_employer_completes_the_mobile_phone_verification() {
        signUpPage.typeOnEnter4DigitField(otpCode);
        signUpPage.tapOnFinishButton();
        Assert.assertTrue("CONGRATULATIONS! text should be present", signUpPage.isCongratulationsTextPresent());
    }

    @Given("The employer is on My Job Posting screen")
    public void the_employer_is_on_My_Job_Posting_screen() {
        Assert.assertTrue("Job Posting frame should be visible but it was not", homePage.isJobPostingFrameVisible());
        Assert.assertTrue("Post Job button should be visible, but it was not", homePage.isPostJobButtonVisible());
    }

    @Then("The app should get the employer back to landing screen")
    public void the_app_should_get_the_employer_back_to_landing_screen() {
        Assert.assertTrue("Landing image should be displayed", landingPage.isLandingImageVisible());
    }

    @When("The employer enters his credentials and clicks on login button")
    public void the_employer_enters_his_credentials_and_clicks_on_login_button() {
        loginPage.performLogin(email, password);
    }

}
