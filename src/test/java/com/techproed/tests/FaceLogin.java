package com.techproed.tests;

import com.techproed.pages.FaceLoginPage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FaceLogin extends TestBase {

    @Test
    public void logInTest() throws InterruptedException {

        //Go to the webpage
        driver.get("https://www.facebook.com/");
        //Create FaceLoginPage object
        FaceLoginPage faceLoginPage=new FaceLoginPage(driver);
        //send username
        faceLoginPage.username.sendKeys("sdgagarga3erghae");
        faceLoginPage.password.sendKeys("asdgsadfhgsdhfsd");
        faceLoginPage.login.click();
        Thread.sleep(6000);

        String actualErrorMessage=faceLoginPage.errorMessage.getText();
        String expectedErrorMessage="The email or phone number you’ve entered doesn’t match any account. Sign up for an account.";
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);

    }

}
