package com.techproed.tests;

import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExplicitWaitTest1 extends TestBase {

    @Test
    public void isEnabled(){
//        Create a class:ExplicitWaitTest1. Create a method: isEnabled
//        Go to https://the-internet.herokuapp.com/dynamic_controls
        Driver.getDriver().get("https://the-internet.herokuapp.com/dynamic_controls");

//        Click enable Button
        WebElement enableButton=Driver.getDriver().findElement(By.xpath("(//button[@type='button'])[2]"));
        enableButton.click();

//        And verify the message is equal to “It's enabled!”
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        //WebElement enabledMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        WebElement enabledMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        String enabledMessageText=enabledMessage.getText();
        Assert.assertEquals(enabledMessageText,"It's enabled!");

//        And verify the textbox is enabled (I can type in the box)
        WebElement inputBox=Driver.getDriver().findElement(By.xpath("//input[@type='text']"));
        //isEnable is used to understand if an element is enabled.
        Assert.assertTrue(inputBox.isEnabled());
//        And click on Disable button
        WebElement disableButton=Driver.getDriver().findElement(By.xpath("(//button[@type='button'])[2]"));
        disableButton.click();
//        And verify the message is equal to “It's disabled!”
        WebElement disableMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        String disableMessageText=disableMessage.getText();
        Assert.assertEquals(disableMessageText,"It's disabled!");
//        And verify the textbox is disabled (I cannot type in the box)
        WebElement inputBox1=Driver.getDriver().findElement(By.xpath("//input[@type='text']"));
        Assert.assertTrue(!inputBox1.isEnabled());


    }
}
