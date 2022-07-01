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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Step_Definitions {

    BasePage loginPage=new BasePage();
    DashboardPage dashboardPage=new DashboardPage();
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),40);
    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("navfortLoginUrl"));
    }
    @When("User enters  truck driver {string} and {string} and clicks log in button")
    public void user_enters_truck_driver_and_and_clicks_log_in_button(String string, String string2) {

    loginPage.login(string,string2);
    }
    @Then("User should see the {string} for truck driver")
    public void user_should_see_the_for_truck_driver(String string) {

        wait.until(ExpectedConditions.invisibilityOf(dashboardPage.loadingBar));
        Assert.assertTrue(dashboardPage.homepageName.getText().equals(string));
        dashboardPage.fullName.click();
        dashboardPage.logout.click();

    }


    @When("User  enters sales manager  {string} and {string} and clicks log in button")
    public void userEntersSalesManagerAndAndClicksLogInButton(String username, String password) {
        loginPage.login(username,password);
    }

    @Then("User should see the {string} for sales manager")
    public void userShouldSeeTheForSalesManager(String string3) {
        wait.until(ExpectedConditions.invisibilityOf(dashboardPage.loadingBar));
        Assert.assertTrue(dashboardPage.homepageName.getText().equals(string3));
        dashboardPage.fullName.click();
        dashboardPage.logout.click();
    }

    @When("User  enters store manager {string}  and {string} and clicks log in button")
    public void userEntersStoreManagerAndAndClicksLogInButton(String username1, String password1) {
        loginPage.login(username1,password1);
    }

    @Then("User should see the {string} for store manager")
    public void userShouldSeeTheForStoreManager(String string4) {
        wait.until(ExpectedConditions.invisibilityOf(dashboardPage.loadingBar));
        Assert.assertTrue(dashboardPage.homepageName.getText().equals(string4));
        dashboardPage.fullName.click();
        dashboardPage.logout.click();
    }

    @When("The user tries to login with {string} and {string}")
    public void theUserTriesToLoginWithAnd(String string5, String string6) {
        loginPage.login(string5,string6);
    }

    @Then("The user can not login and page title is {string}")
    public void theUserCanNotLoginAndPageTitleIs(String title) {
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Login"));
    }
}
