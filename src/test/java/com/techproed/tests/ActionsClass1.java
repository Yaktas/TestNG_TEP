package com.techproed.tests;

import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionsClass1 extends TestBase {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void contextClickMethod() throws InterruptedException {
        //contextClick= right click
        //    Given user is on the https://the-internet.herokuapp.com/context_menu
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //    When use Right clicks on the box
        //Creating actions object so actions control the driver and do mouse-keyboard actions
        Actions actions=new Actions(driver);
        //Locate the Box
        WebElement box=driver.findElement(By.id("hot-spot"));
        //Right click on the alert. DON'T FORGET TO USE perform();
        actions.contextClick(box).perform();
        Thread.sleep(1000);
        //    Then verify the alert message is “You selected a context menu”
        String actualAlertMessage=driver.switchTo().alert().getText();
        System.out.println("step1");
        String expectedAlertMessage="You selected a context menu";
        Assert.assertEquals(actualAlertMessage,expectedAlertMessage);
        //    Then accept the alert
        driver.switchTo().alert().accept();
        System.out.println("step2");
        driver.close();
    }
}
