package com.techproed.excelautomation;


import com.techproed.pages.KaolaLoginPage1;
import com.techproed.utilities.ExcelUtil;
import com.techproed.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DDFLoginTest extends TestBase {
    @DataProvider
    public Object[] [] userData(){
        ExcelUtil data = new ExcelUtil("src/test/resources/logindata.xlsx","sheet1");

        String[][] dataArray = data.getDataArrayWithoutFirstRow();

        return dataArray;
    }

    @Test(dataProvider ="userData" )
    public void loginTestDDF(String usename,String password,String firstname,String lastname){
        extentTest=extentReports.createTest("Test "+firstname+" "+lastname);
        KaolaLoginPage1 loginPage=new KaolaLoginPage1();
        loginPage.login();
    }

}
