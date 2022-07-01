Feature: Fleet App Login feature
  User Story:
  As a user, I should be able to login.

  Accounts are: truck driver, store manager, sales manager

  Background: For the scenarios in the feature file, user is expected to be on the login page
    Given The user is on the login page
@wip
  Scenario Outline: Login as a truck driver with valid credentials
    When User enters  truck driver "<username>" and "<password>" and clicks log in button
    Then User should see the "<pageSubTitle>" for truck driver

    Examples:
      | pageSubTitle    | username | password    |
      | Quick Launchpad | user1    | UserUser123 |
      | Quick Launchpad | user12   | UserUser123 |


  Scenario Outline: Login as a sales manager with valid credentials
    When User  enters sales manager  "<username>" and "<password>" and clicks log in button
    Then User should see the "<pageSubTitle>" for sales manager

    Examples:
      | pageSubTitle | username        | password    |
      | Dashboard    | salesmanager101 | UserUser123 |
      | Dashboard    | salesmanager140 | UserUser123 |


  Scenario Outline: Login as a store manager with valid credentials
    When User  enters store manager "<username>"  and "<password>" and clicks log in button
    Then User should see the "<pageSubTitle>" for store manager
    Examples:
      | pageSubTitle | username       | password    |
      | Dashboard    | storemanager51 | UserUser123 |
      | Dashboard    | storemanager87 | UserUser123 |


  Scenario Outline: Can not login with invalid credentials - Negative Scenario
    When The user tries to login with "<username>" and "<password>"
    Then The user can not login and page title is "Login"
    Examples:
      | username        | password    |
      | salesmanager101 |             |
      |                 | UserUser123 |
      |                 |             |
      | abcdefgh        | UserUser123 |
      | storemanager51  | aad3412!    |
      | asdaw           | sdf323'+%   |