package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KaolaDefaultPage {



    public KaolaDefaultPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Hotel Management")
    public WebElement hotelManagement;

    @FindBy(partialLinkText = "Hotel Rooms")
    public WebElement hotelRooms;

    @FindBy(partialLinkText = "Room reservations")
    public WebElement roomReservations;

    //a[@href='/admin/RoomReservationAdmin']




}
