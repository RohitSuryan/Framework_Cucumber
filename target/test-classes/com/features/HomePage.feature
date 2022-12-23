Feature: Home Page Feature

  Background: 
    Given user has already logged in to application
      | username                  | password  |
      | rohitsuryan2016@gmail.com | Rohit@123 |

  @home
  Scenario: Home page title
    Given user is on Home page
    When user gets the title of the page
    Then page title should be "Cogmento CRM"

  @home
  Scenario: Home section count
    Given user is on Home page
    Then user gets Home section
      | Contacts activity stream |
      | Deals                    |
      | Call Queue               |
      | Upcoming calls           |
      | Twitter                  |
    And Home section count should be 5
