package appPage;

public interface SignUpPage {

    boolean isLabelVerifiedEmailVisible();
    void typeOnFirstName(String firstName);
    void typeOnLastName(String lastName);
    void typeOnEmail(String email);
    void typeOnPassword(String password);
    void tapOnSignUpButton();
    boolean isCompanyNameFieldVisible();
    void typeOnCompanyName(String companyName);
    void typeOnCompanyWebsite(String companyWebsite);
    void tapOnContinueUpButton();
    boolean isLabelVerifiedNumberVisible();
    boolean isFirstNameFieldVisible();
    void tapOnCountryCodeDropDown();
    void typeOnSearchCountryField(String countryName);
    void tapOnIndiaCountry();
    void tapOnCountryName(String countryName);
    void typeOnPhoneNumberField(String phoneNumber);
    void tapOnContinueToAddNumberButton();
    boolean isLabelMobilePhoneVerificationVisible();
    void typeOnEnter4DigitField(String otpCode);
    void tapOnFinishButton();
    String getPopUpText();
    boolean isCongratulationsTextPresent();
    void tapOnOkPopUpButton();

}
