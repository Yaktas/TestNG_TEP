package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KaolaMainPage {


    public KaolaMainPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(linkText = "Log in")
    public WebElement kaolaMainLoginButton;

}

