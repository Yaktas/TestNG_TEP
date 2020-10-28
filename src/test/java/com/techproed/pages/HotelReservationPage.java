package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelReservationPage {
    public HotelReservationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[@class='hidden-480']")
    public WebElement addRoomReservation;
    @FindBy(id = "IDUser")
    public WebElement idUser;
    @FindBy(id = "IDHotelRoom")
    public WebElement selectRoom;
    @FindBy(xpath = "//input[@id='Price']")
    public WebElement price;
    @FindBy(id = "DateStart" )
    public WebElement dateStart;
    @FindBy(xpath = "//input[@id = 'DateEnd']")
    public WebElement dateEnd;
    @FindBy(xpath = "//input[@id = 'AdultAmount']")
    public WebElement adultAmount;
    @FindBy(xpath = "//input[@id = 'ChildrenAmount']")
    public WebElement childrenAmount;
    @FindBy(xpath = "//input[@id='ContactNameSurname']")
    public WebElement contactName;
    @FindBy(xpath = "//input[@id = 'ContactPhone']")
    public WebElement contactPhone;
    @FindBy(xpath = "//input[@id='ContactEmail']")
    public WebElement contactEmail;
    @FindBy(xpath = "//input[@id='Notes']")
    public WebElement contactNotes;
    @FindBy(xpath = "//input[@id='Approved']")
    public WebElement isApproved;
    @FindBy(xpath = "//input[@id='IsPaid']")
    public WebElement isPaid;
    @FindBy(xpath = "//button[@id='btnSubmit']")
    public WebElement saveButton;

}
