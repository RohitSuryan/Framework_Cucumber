Feature: Login Page Feature

  Scenario: Login Page Title
    Given user is on login page
    When user gets the title of the page
    Then page title should be "Cogmento CRM"

  Scenario: Forgot Password Link
    Given user is on login page
    Then forgot your password link should be displayed

  Scenario: Login with correct credentials
    Given user is on login page
    When user enters username "rohitsuryan2016@gmail.com"
    And user enters password "Rohit@123"
    And user clicks on Login button
    Then user gets the title of the page
    And page title should be "Cogmento CRM"
