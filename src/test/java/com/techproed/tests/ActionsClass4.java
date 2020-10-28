package com.techproed.tests;

import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsClass4 extends TestBase {

    @Test
    public void scrollUpDown() throws InterruptedException {
        //        Go to amazon
        Driver.getDriver().get("https://www.amazon.com/");

        Actions actions=new Actions(Driver.getDriver());
        //        Scroll the page down
        Thread.sleep(5000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();//ARROW_DOWN moved the page down, but it moves less than PAGE_DOWN
        Thread.sleep(5000);

        //        Scroll the page up
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(5000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(5000);
        actions.sendKeys(Keys.ARROW_UP).perform();//ARROW_UP will also move the page up but a little bit up.
        Thread.sleep(5000);
        Assert.fail();

        //When do we move the page up or page down in testing?
        //Some pages are long. When we need to take a screenshot of an element that is at the buttom of the page,
        //we have to move the page down.


    }





}
