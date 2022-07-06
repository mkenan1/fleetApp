package com.fleetApp.step_definitions;


import com.fleetApp.pages.BasePage;
import com.fleetApp.pages.DashboardPage;
import com.fleetApp.pages.ForgotPasswordPage;
import com.fleetApp.utilities.BrowserUtils;
import com.fleetApp.utilities.ConfigurationReader;
import com.fleetApp.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Locale;

public class Login_Step_Definitions {

    BasePage loginPage = new BasePage();
    DashboardPage dashboardPage = new DashboardPage();
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
    String currentUrl;

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("navfortLoginUrl"));
    }

    @When("User enters {string} and {string} and clicks log in button")
    public void userEntersAndAndClicksLogInButton(String string, String string2) {
        loginPage.login(string, string2);
    }
    @Then("User should see the {string}")
    public void userShouldSeeThe(String string) {
        loginPage.waitUntilLoaderScreenDisappear();
        Assert.assertTrue(dashboardPage.homepageName.getText().equals(string));
        dashboardPage.logout();
    }


    @Then("User should see the {string} for sales manager")
    public void userShouldSeeTheForSalesManager(String string3) {
        loginPage.waitUntilLoaderScreenDisappear();
        Assert.assertTrue(dashboardPage.homepageName.getText().equals(string3));
        dashboardPage.logout();
    }


    @Then("User should see the {string} for store manager")
    public void userShouldSeeTheForStoreManager(String string4) {
        loginPage.waitUntilLoaderScreenDisappear();
        Assert.assertTrue(dashboardPage.homepageName.getText().equals(string4));
        dashboardPage.logout();
    }

    //TC04
    @When("User logs in and gets the url and log out")
    public void userLogsInAndGetsTheUrlAndLogOut() {
        loginPage.login("user1", "UserUser123");

        loginPage.waitUntilLoaderScreenDisappear();
        currentUrl = Driver.getDriver().getCurrentUrl();
        BrowserUtils.sleep(5);
        dashboardPage.logout();
        BrowserUtils.sleep(5);
    }

    @And("User tries to log in with the same url")
    public void userTriesToLogInWithTheSameUrl() {
        Driver.getDriver().get(currentUrl);
    }

    @Then("User can not login and see {string} as current title")
    public void userCanNotLoginAndSeeAsCurrentTitle(String arg0) {
        Assert.assertTrue(Driver.getDriver().getTitle().equals(arg0));
    }

    //TC05
    @When("The user tries to login with {string} and {string}")
    public void theUserTriesToLoginWithAnd(String string5, String string6) {
        loginPage.login(string5, string6);
    }


    @Then("The user can not login and see {string} message")
    public void theUserCanNotLoginAndSeeMessage(String message) {
        Assert.assertEquals(message, loginPage.invalidMessage.getText());
    }


    @Then("The user can not login and the page title is {string}")
    public void theUserCanNotLoginAndThePageTitleIs(String title) {
        Assert.assertTrue(Driver.getDriver().getTitle().equals(title));
    }


    @When("The user enters password")
    public void theUserEntersPassword() {
       loginPage.passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
    }

    @Then("The user will see password in bullet signs")
    public void theUserWillSeePasswordInBulletSigns() {
        Assert.assertFalse(loginPage.passwordBox.getAttribute("type").equals("UserUser123"));
        System.out.println(loginPage.passwordBox.getAttribute("type"));
    }

    @When("The user clicks Forgot your password? link")
    public void theUserClicksForgotYourPasswordLink() {
        loginPage.forgotPasswordbtn.click();
    }

    @Then("The user lands on Forgot your password? page")
    public void theUserLandsOnForgotYourPasswordPage() {
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Forgot Password") );
    }

    @When("The user enters username")
    public void theUserEntersUsername() {
        forgotPasswordPage.forgotPasswordBox.sendKeys(ConfigurationReader.getProperty("username"));
        forgotPasswordPage.requestBtn.click();
    }

    @Then("The user should be able to change password")
    public void theUserShouldBeAbleToChangePassword() {
        Assert.assertTrue(forgotPasswordPage.alertMessage.getText().toLowerCase(Locale.ROOT).contains("success"));
    }

    //remember me
    @When("The user clicks Remember me on this computer checkbox")
    public void the_user_clicks_remember_me_on_this_computer_checkbox() {
       loginPage.rememberMeBtn.click();
    }
    @When("User enters username and password and clicks log in button")
    public void user_enters_username_and_password_and_clicks_log_in_button() {
        loginPage.login(ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));
       BrowserUtils.sleep(3);
    }
    @When("The user goes to login page again after closing the page")
    public void the_user_goes_to_login_page_again_after_closing_the_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("navfortDashboard"));
    }
    @Then("The user should be on the home page directly")
    public void the_user_should_be_on_the_home_page_directly() {
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Dashboard"));
    }
//enter key
    @When("The user enters username and use enter key")
    public void theUserEntersUsernameAndUseEnterKey() {
        loginPage.usernameBox.sendKeys(ConfigurationReader.getProperty("username")+ Keys.ENTER);
    }

    @And("The user enters password and use enter key")
    public void theUserEntersPasswordAndUseEnterKey() {
        loginPage.passwordBox.sendKeys(ConfigurationReader.getProperty("password")+ Keys.ENTER);
    }

    @Then("The user should login successfully")
    public void theUserShouldLoginSuccessfully() {
        dashboardPage.waitUntilLoaderScreenDisappear();
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Dashboard"));
    }

    @Then("User should see their own {string}")
    public void userShouldSeeTheirOwn(String username) {
        dashboardPage.waitUntilLoaderScreenDisappear();
        Assert.assertTrue(dashboardPage.fullName.getText().equals(username));
    }
}
