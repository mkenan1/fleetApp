Feature: Fleet App Login feature
  User Story:
  As a user, I should be able to login.

  Accounts are: truck driver, store manager, sales manager

  Background: For the scenarios in the feature file, user is expected to be on the login page
    Given The user is on the login page
#  Scenario: Login as a truck driver with valid credentials
#    When User  enters  "<username>"
#      | user1   |
#      | user12  |
#      | user160 |
#    And User  enters password "UserUser123"
#    Then User should see the "Quick Launchpad" at the home page


  Scenario Outline: Login as a sales manager with valid credentials
    When User  enters  "<username>"
    And User  enters "<password>"
    Then User should see the "<pageSubTitle>"

    Examples:
      | pageSubTitle | username        | password    |
      | Dashboard    | salesmanager101 | UserUser123 |
      | Dashboard    | salesmanager140 | UserUser123 |
      | Dashboard    | salesmanager299 | UserUser123 |

  Scenario Outline: Login as a store manager with valid credentials
    When User  enters  "<username>"
    And User  enters "<password>"
    Then User should see the "<pageSubTitle>"
    Examples:
      | pageSubTitle | username        | password    |
      | Dashboard    | storemanager51  | UserUser123 |
      | Dashboard    | storemanager87  | UserUser123 |
      | Dashboard    | storemanager220 | UserUser123 |


#  Scenario Outline: Can not login with invalid credentials - Negative Scenario
#    When The user tries to login with "<username>" and "<password>"
#    Then The user can not login and page title is "Login"
#
#    Examples:
#      | username        | password    |
#      | salesmanager101 |             |
#      |                 | UserUser123 |
#      |                 |             |
#      | abcdefgh        | UserUser123 |
#      | storemanager51  | aad3412!    |
#      | asdaw           | sdf323'+%   |