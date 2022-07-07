package com.fleetApp.step_definitions;

import com.fleetApp.pages.BasePage;
import com.fleetApp.pages.DashboardPage;
import com.fleetApp.utilities.BrowserUtils;
import com.fleetApp.utilities.ConfigurationReader;
import com.fleetApp.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

public class Logout_Step_Definitions {
    BasePage loginPage = new BasePage();
    DashboardPage dashboardPage = new DashboardPage();
    @Given("The user is on the dashboard page")
    public void the_user_is_on_the_dashboard_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("navfortLoginUrl"));
    loginPage.login(ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));
    }
    @When("user clicks log out button inside profile info")
    public void user_clicks_log_out_button_inside_profile_info() {
        loginPage.waitUntilLoaderScreenDisappear();
        dashboardPage.logout();
        BrowserUtils.sleep(3);
    }
    @Then("user should log out and be on login page")
    public void user_should_log_out_and_be_on_login_page() {
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Login"));
    }


    @And("user tries to go back")
    public void userTriesToGoBack() {
        Driver.getDriver().navigate().back();
    }

    @When("user closes all tabs")
    public void userClosesAllTabs() {
       Driver.getDriver().get("https://www.google.com");
    }

    @And("user goes login page again")
    public void userGoesLoginPageAgain() {

        Driver.getDriver().navigate().to(ConfigurationReader.getProperty("navfortLoginUrl"));
        BrowserUtils.sleep(2);
    }

    @Then("user should be on login page")
    public void userShouldBeOnLoginPage() {
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Login"));
    }

    @When("user waits {int} minutes without action")
    public void userWaitsMinutesWithoutAction(int arg0) {
        BrowserUtils.sleep(arg0*60);
    }




//The user must be logged out if the user close the tab
// (if there are multiple open tabs in the app, close all of them)

}
