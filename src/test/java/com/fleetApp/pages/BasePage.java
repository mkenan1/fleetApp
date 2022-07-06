package com.fleetApp.pages;

import com.fleetApp.utilities.ConfigurationReader;
import com.fleetApp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public  class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id="prependedInput")
    public WebElement usernameBox;

    @FindBy(id="prependedInput2")
    public WebElement passwordBox;

    @FindBy(id="_submit")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"progressbar\"]/div/div")
    public WebElement loadingBar;

    @FindBy(xpath = "//div[.='Invalid user name or password.']")
    public WebElement invalidMessage;

    @FindBy(linkText= "Forgot your password?")
    public WebElement forgotPasswordbtn;

    @FindBy(xpath = "//span[@class='custom-checkbox__icon']")
    public WebElement rememberMeBtn;

    public void goLoginPage(){
       Driver.getDriver().get(ConfigurationReader.getProperty("navfortLoginUrl"));
    }

    public void login(String username, String password){
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();
    }

    public void waitUntilLoaderScreenDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 6);
            wait.until(ExpectedConditions.invisibilityOf(loadingBar));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
