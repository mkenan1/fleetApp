package com.fleetApp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {
    @FindBy(xpath = "//li[@id='user-menu']/a")
    public WebElement fullName;

    @FindBy(xpath = "//*[@id=\"user-menu\"]/ul/li[4]/a")
    public WebElement logout;

    @FindBy(xpath = "h1[@class='oro-subtitle']")
    public WebElement homepageName;

    public void logout(){
        fullName.click();
        logout.click();
    }
}
