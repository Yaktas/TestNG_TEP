package com.techproed.pages;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KaolaLoginPage {

    public KaolaLoginPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "UserName")
    public WebElement kaolaUsername;

    @FindBy(id = "Password")
    public WebElement kaolaPass;

    @FindBy(id = "btnSubmit")
    public WebElement kaolaLoginButton;

    public void login(){
        Driver.getDriver().get(ConfigReader.getProperty("kaola_url"));
        KaolaMainPage kaolaMainPage=new KaolaMainPage();
        kaolaMainPage.kaolaMainLoginButton.click();
        KaolaLoginPage kaolaLoginPage=new KaolaLoginPage();
        kaolaLoginPage.kaolaUsername.sendKeys(ConfigReader.getProperty("username"));
        kaolaLoginPage.kaolaPass.sendKeys(ConfigReader.getProperty("password"));
        kaolaLoginPage.kaolaLoginButton.click();
    }
}
