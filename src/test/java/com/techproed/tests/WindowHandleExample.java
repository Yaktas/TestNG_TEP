package com.techproed.tests;

import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;


public class WindowHandleExample extends TestBase {

    @Test
    public void newWindowTest(){

//    Given user is on the https://the-internet.herokuapp.com/windows
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        //    Then user verifies the text : “Opening a new window”
        String actualNewWindowText=Driver.getDriver().findElement(By.xpath("//div[@class='example']//h3")).getText();
        String expectedNewWindowText="Opening a new window";
        Assert.assertEquals(actualNewWindowText,expectedNewWindowText);
        //    Then user verifies the title of the page is “The Internet”
        String expectedTitle = "The Internet";
        String actualTitle = Driver.getDriver().getTitle();
        //Check if the expectedTitle equals the actual Title. If they are not equal then print Title is incorrect
        Assert.assertEquals(actualTitle,expectedTitle,"Title is incorrect");
        //WE ARE GETTING THE FIRST WINDOW HANDLE DO WHEN WE NEED TO SWITCH BACK TO THIS WINDOW WE CAN DO IT
        String window1=Driver.getDriver().getWindowHandle();
        System.out.println("Default Window Handle : "+window1);
        //    When user clicks on the “Click Here” button
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        //    Then user verifies the new window title is “New Window”
        //THE NEW WINDOW OPENS IN A NEW TAB. THIS MEANS WE HAVE TO SWITCH TO THE NEW WINDOW!!!!
        ///WE WILL GET ALL OPEN WINDOW HANDLES AND PUT THEM IN A SET.
       Set<String> allWindows=Driver.getDriver().getWindowHandles();
       //Using for each loop, we can switch to teh new window.
        for (String eachWindow:allWindows){
            if (!eachWindow.equals(window1)){
                Driver.getDriver().switchTo().window(eachWindow);
            }
        }
        String actualNewPageTitle=Driver.getDriver().getTitle();
        String expectedNewPageTitle="New Window";
        Assert.assertEquals(actualNewPageTitle,expectedNewPageTitle,"New Page Title is not equal");
        //    Then user verifies the text:  “New Window”
        String actualSecondWindowText=Driver.getDriver().findElement(By.xpath("//h3")).getText();
        String expectedSecondWindowText="New Window";
        Assert.assertEquals(actualSecondWindowText,expectedSecondWindowText,"New Window text is not matching");
        //    When user goes back to the previous window and then verifies the title : “The Internet”\
        Driver.getDriver().switchTo().window(window1);
        Assert.assertEquals(Driver.getDriver().getTitle(),"The Internet");

    }
}
