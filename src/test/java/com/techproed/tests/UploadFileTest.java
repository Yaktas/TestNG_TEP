package com.techproed.tests;

import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadFileTest extends TestBase {
    @Test
    public void uploadFileMethod() throws InterruptedException {
        Driver.getDriver().get("https://the-internet.herokuapp.com/upload");
        //locate teh element of choosefile
        WebElement chooseFile= Driver.getDriver().findElement(By.id("file-upload"));
        //We need to send the path of the image
        //Each of your path will be different
        //Find your own path
        //Windows Example: C:\\Users\\USE YOUR OWN COMPUTER NAME\\Desktop\\FLOWER. IMG.jpg"
        String pathOfTheFile="/Users/techproed/Desktop/FLOWER. IMG.jpg";
        //We will send this pathOfTheFile to the chooseFile button
        chooseFile.sendKeys(pathOfTheFile);
        Thread.sleep(3000);
        //Click on upload button
        WebElement uploadButton=Driver.getDriver().findElement(By.id("file-submit"));
        uploadButton.click();
        Thread.sleep(3000);
        //Verify "File Uploaded!" message
        WebElement fileUploadedText=Driver.getDriver().findElement(By.xpath("//h3"));
        String actualText=fileUploadedText.getText();
        String expectedText="File Uploaded!";
        Assert.assertTrue(actualText.equals(expectedText));
        Thread.sleep(3000);

    }
}
