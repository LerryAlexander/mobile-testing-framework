@regression @smoke
Feature: Sign Up, Logout and Login
  # =====================================================================================================================
  # This feature is designed to run a smoke test to validate following scenarios:
  #   1) Sign Up as an employer
  #   2) Logout as an employer
  #   3) Login as an employer
  # =====================================================================================================================

  @signInAsEmployer
  Scenario: [Positive] Sign Up as an Employer
    Given The landing screen is displayed
    When The user navigates to sign up as an employer screen
    And The employer enters all his personal info
    And The employer enters company info
    And The employer enters his mobile number
    And The employer completes the mobile phone verification
    Then The app should redirect the employer to My Job Posting screen

  Scenario: [Positive] Logout as an Employer
    Given The employer is on My Job Posting screen
    When The employer navigates to profile --> settings
    And The employer selects Logout option
    And The employer confirms he wants to logout
    Then The app should get the employer back to landing screen

  Scenario: [Positive] Login as an Employer
    Given The landing screen is displayed
    And The user navigates to login screen as an employer
    When The employer enters his credentials and clicks on login button
    Then The app should redirect the employer to My Job Posting screen
