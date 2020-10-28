package com.techproed.tests;

import com.techproed.pages.HotelReservationPage;
import com.techproed.pages.KaolaDefaultPage;
import com.techproed.pages.KaolaLoginPage;
import com.techproed.pages.KaolaMainPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
public class HotelReservationTest  {
    //REFACTOR: Refactoring is done to make the existing codes better.
    //CREATE A SEPERATE LOG IN METHOD
    //CREATE A PAGE CLASS TO STORE PAGE OBJECTS
    //USE THAT PAGE OBJECTS IN THIS CLASS.
    HotelReservationPage hotelReservationPage= new HotelReservationPage();
    KaolaDefaultPage kaolaDefaultPage=new KaolaDefaultPage();
    public void login(){
        Driver.getDriver().get(ConfigReader.getProperty("kaola_url"));
        KaolaMainPage kaolaMainPage=new KaolaMainPage();
        kaolaMainPage.kaolaMainLoginButton.click();
        KaolaLoginPage kaolaLoginPage=new KaolaLoginPage();
        kaolaLoginPage.kaolaUsername.sendKeys(ConfigReader.getProperty("username"));
        kaolaLoginPage.kaolaPass.sendKeys(ConfigReader.getProperty("password"));
        kaolaLoginPage.kaolaLoginButton.click();
    }

    @Test
    public void reservationTest(){
        login();
        kaolaDefaultPage.hotelManagement.click();
        kaolaDefaultPage.roomReservations.click();
        ReusableMethods.waitFor(1);
        hotelReservationPage.addRoomReservation.click();
        ReusableMethods.waitFor(1);
        Select selectSelectUser = new Select(hotelReservationPage.idUser);
        selectSelectUser.selectByIndex(1);
        Select selectSelectRoom = new Select(hotelReservationPage.selectRoom);
        selectSelectRoom.selectByVisibleText("King Room");
        hotelReservationPage.price.sendKeys("600");
        selectSelectUser.selectByIndex(1);
        hotelReservationPage.dateStart.sendKeys("12/26/2020");
        selectSelectUser.selectByIndex(1);
        hotelReservationPage.dateEnd.sendKeys("12/30/2020");
        hotelReservationPage.adultAmount.sendKeys("2");
        hotelReservationPage.childrenAmount.sendKeys("2");
        hotelReservationPage.contactName.sendKeys("John");
        hotelReservationPage.contactPhone.sendKeys("3491255544");
        hotelReservationPage.contactEmail.sendKeys("ggg@gmail.com");
        hotelReservationPage.contactNotes.sendKeys("Hersey ok");
        hotelReservationPage.isApproved.click();
        hotelReservationPage.isPaid.click();
        selectSelectUser.selectByIndex(1);
        hotelReservationPage.saveButton.click();
        WebElement popUpMessage=ReusableMethods.waitForVisibility(By.xpath("//div[@class='bootbox-body']"),3);
        System.out.println(popUpMessage.getText());
        Assert.assertEquals(popUpMessage.getText(),"RoomReservation was inserted successfully");
        Driver.getDriver().findElement(By.xpath("//button[@data-bb-handler='ok']")).click();
    }
}