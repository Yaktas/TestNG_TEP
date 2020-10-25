package com.techproed.tests;

import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReusableMethodsDemo {

    @Test
    public void test1(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/dynamic_loading/2");
        Driver.getDriver().findElement(By.xpath("//button")).click();
        WebElement helloWord=Driver.getDriver().findElement(By.xpath("//h4[.='Hello World!']"));
        Assert.assertEquals(helloWord.getText(),"Hello World!");
        //All is good. We don't need to use explicit wait.
        //Implicit wait solved the issue

    }
}
