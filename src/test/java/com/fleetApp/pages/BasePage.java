package com.fleetApp.pages;

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

    public void login(String username, String password){
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();
    }
    public void waitUntilLoaderScreenDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 8);
            wait.until(ExpectedConditions.invisibilityOf(loadingBar));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
