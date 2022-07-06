package com.fleetApp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage{
    @FindBy(xpath = "//h2[@class='title']")
    public WebElement forgotPasswordTitle;

    @FindBy(id = "prependedInput")
    public WebElement forgotPasswordBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement requestBtn;

    @FindBy(xpath = "//a[@href='/user/login']")
    public WebElement returnLoginBtn;

    @FindBy(xpath = "//div[@class='alert alert-warn']")
    public WebElement alertMessage;

}
