package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.MainClass;
import com.google.common.annotations.VisibleForTesting;
import com.pages.DashBoardPage;
import com.pages.LoginPage;
import com.util.UtilityFunction;

/**
 * Hello world!
 *
 */
public class VerifyDashBoard extends MainClass
{
    public static void main( String[] args )
    {
        MainClass.init();
        MainClass.navigateToURL(properties.getProperty("url"));
        LoginPage loginPage=new LoginPage();
        
        loginPage.login();
    }
    @BeforeClass
    public void i() {
    	MainClass.init();
    }
    
    @BeforeMethod
    public void initilize() {
    	
    }
    @DataProvider
    public String[][] getData() {
    	return UtilityFunction.getExcelData();
    }
    
    @Test(dataProvider="getData")
    public void testDashBoard(String userName,String x, String y, String z) {
    	 MainClass.navigateToURL(properties.getProperty("url"));
    	 
         LoginPage loginPage=new LoginPage();    
         Assert.assertEquals(loginPage.getTitle(), "OrangeHRM");
         DashBoardPage dashBoard=loginPage.login();
         
         Assert.assertEquals(dashBoard.getTitle(), "OrangeHRM");
         
         Assert.assertTrue(dashBoard.assignLeave.isDisplayed());
         
         dashBoard.clickOnUserSubMenu();
         
         dashBoard.typeInUserName(userName);
         
    }
    
    
    
    @AfterMethod
    public void completeTest() {
    	//closeBroswer();
    }
}
