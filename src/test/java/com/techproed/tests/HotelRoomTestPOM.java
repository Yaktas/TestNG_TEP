package com.techproed.tests;

import com.techproed.pages.HotelRoomsPage;
import com.techproed.pages.KaolaDefaultPage;
import com.techproed.pages.KaolaLoginPage;
import com.techproed.pages.KaolaMainPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ReusableMethods;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelRoomTestPOM extends TestBase {
    KaolaDefaultPage kaolaDefaultPage=new KaolaDefaultPage();
    HotelRoomsPage hotelRoomsPage=new HotelRoomsPage();
    KaolaLoginPage kaolaLoginPage=new KaolaLoginPage();

    @Test
    public void hotelRoomTest() throws InterruptedException {
        kaolaLoginPage.login();
        kaolaDefaultPage.hotelManagement.click();
        ReusableMethods.waitFor(1);
        kaolaDefaultPage.hotelRooms.click();
        ReusableMethods.waitFor(1);
        hotelRoomsPage.addHotelRoomButton.click();
        Select selectSelectUser = new Select(hotelRoomsPage.hotelIDropDown);
        selectSelectUser.selectByIndex(3);
        hotelRoomsPage.code.sendKeys("special code");
        hotelRoomsPage.name.sendKeys("test name");
        hotelRoomsPage.location.sendKeys("test location");
        hotelRoomsPage.description.sendKeys("Special room");
        hotelRoomsPage.price.sendKeys("140");
        Select select=new Select(hotelRoomsPage.roomType);
        select.selectByIndex(4);
        hotelRoomsPage.maxAdult.sendKeys("2");
        hotelRoomsPage.maxChild.sendKeys("3");
        ReusableMethods.waitFor(1);
        hotelRoomsPage.approve.click();
        ReusableMethods.waitFor(1);
        hotelRoomsPage.submitButton.click();
        ReusableMethods.waitForVisibility(By.xpath("//div[@class='bootbox-body']"),3);
        Assert.assertEquals(hotelRoomsPage.successMessage.getText(),"HotelRoom was inserted successfully");
        hotelRoomsPage.okButton.click();

    }

}
