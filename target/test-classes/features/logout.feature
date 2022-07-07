Feature: Fleet App Login feature
  User Story :

  As a user I should be able to log out

  Background: For the scenarios in the feature file, user is expected to be on the dashboard page
    Given The user is on the dashboard page

    ##User can log out by using log out button inside profile info and ends up in login page.
  @NV-1367
  Scenario: Log out by using log out button
    When user clicks log out button inside profile info
    Then user should log out and be on login page

    ##The user can not go to the home page again by clicking the step back button after successfully logged out.
  @NV-1368
  Scenario: After log out by going back user can not be on home page
    When user clicks log out button inside profile info
    And user tries to go back
    Then user should log out and be on login page

    #The user must be logged out if the user close the tab
    # (if there are multiple open tabs in the app, close all of them)
  @NV-1369
  Scenario: User logs out when close the tab
    When user closes all tabs
    And user goes login page again
    Then user should be on login page

  @NV-1370
  Scenario: The user must be logged out if the user is away from keyboard for 3 minutes
    When user waits 3 minutes without action
    Then user should be on login page

