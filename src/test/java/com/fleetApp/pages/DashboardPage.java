package com.fleetApp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {
    @FindBy(xpath = "//li[@id='user-menu']/a")
    public WebElement fullName;

    @FindBy(xpath = "//*[@id=\"user-menu\"]/ul/li[4]/a")
    public WebElement logout;

    @FindBy(xpath = "//*[@id=\"container\"]/div[2]/div[1]/div/div/div[1]/div/h1")
    public WebElement homepageName;

    @FindBy(xpath = "//*[@id=\"progressbar\"]/div/div")
    public WebElement loadingBar;

    public void logout(){
        fullName.click();
        logout.click();
    }
}
