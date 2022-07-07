Feature: Fleet App Login feature
  User Story:
  As a user, I should be able to login.

  Accounts are: truck driver, store manager, sales manager

  Background: For the scenarios in the feature file, user is expected to be on the login page
    Given The user is on the login page

  @NV-1307
  Scenario Outline: Login as a truck driver with valid credentials
    When User enters "<username>" and "<password>" and clicks log in button
    Then User should see the "<pageSubTitle>"

    Examples:
      | pageSubTitle    | username | password    |
      | Quick Launchpad | user1    | UserUser123 |
      | Quick Launchpad | user12   | UserUser123 |

  @NV-1341
  Scenario Outline: Login as a sales manager with valid credentials
    When User enters "<username>" and "<password>" and clicks log in button
    Then User should see the "<pageSubTitle>"

    Examples:
      | pageSubTitle | username        | password    |
      | Dashboard    | salesmanager101 | UserUser123 |
      | Dashboard    | salesmanager140 | UserUser123 |

  @NV-1342
  Scenario Outline: Login as a store manager with valid credentials
    When User enters "<username>" and "<password>" and clicks log in button
    Then User should see the "<pageSubTitle>"
    Examples:
      | pageSubTitle | username       | password    |
      | Dashboard    | storemanager51 | UserUser123 |
      | Dashboard    | storemanager87 | UserUser123 |

  @NV-1345
  Scenario: The system shouldn't allow users to access the application without providing credentials
    When User logs in and gets the url and log out
    And User tries to log in with the same url
    Then User can not login and see "Login" as current title

  @NV-1346
  Scenario Outline: User see error message because of invalid credentials
    When The user tries to login with "<username>" and "<password>"
    Then The user can not login and see "Invalid user name or password." message
    Examples:
      | username       | password    |
      | abcdefgh       | UserUser123 |
      | storemanager51 | aad3412!    |

  @NV-1347
  Scenario Outline: User see error message because of providing no credentials
    When The user tries to login with "<username>" and "<password>"
    Then The user can not login and the page title is "Login"
    Examples:
      | username       | password    |
      |                | UserUser123 |
      | storemanager51 |             |
      |                |             |


  @NV-1348
  Scenario: Users should see their password in bullet signs while typing
    When The user enters password
    Then The user will see password in bullet signs

  @NV-1349
  Scenario: Forgot Password menu
    When The user clicks Forgot your password? link
    Then The user lands on Forgot your password? page
    When The user enters username
    Then The user should be able to change password


  @NV-1371
  Scenario: Remember me on this computer
    When The user clicks Remember me on this computer checkbox
    And User enters username and password and clicks log in button
    And The user goes to login page again after closing the page
    Then The user should be on the home page directly

  @NV-1358
  Scenario: User switches the fields by using Enter key
    When The user enters username and use enter key
    And The user enters password and use enter key
    Then The user should login successfully

  @NV-1372
  Scenario Outline: All users can see their own usernames in profile menu, after successfully login
    When User enters "<username>" and "<password>" and clicks log in button
    Then User should see their own "<ownusername>"
    Examples:
      | username       | password    | ownusername    |
      | storemanager51 | UserUser123 | storemanager51 |
      | storemanager87 | UserUser123 | storemanager87 |
      | user1          | UserUser123 | user1          |
      | user12         | UserUser123 | user12         |
      | storemanager51 | UserUser123 | storemanager51 |
      | storemanager87 | UserUser123 | storemanager87 |