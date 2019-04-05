package com.test.cnqaos.testcases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.cnqaos.pages.HomePage;
import com.cnqaos.pages.LoginPage;
import com.cnqaos.testbase.TestBase;
import com.cnqaos.utils.NewExtendReport;
import com.cnqaos.utils.TestUtils;
import com.cnqaos.utils.emailReport;


public class LoginTest extends TestBase
{
	String sheetname = "masterdata";
	String srcpath = System.getProperty("user.dir");
	String filepath = srcpath + "/src/main/java/com/cnqaos/testdata/mastersheet.xlsx";
	LoginPage loginPage; 
	HomePage homePage ;
	String expectedhomepagetitle = "Home Page";
	String usernames = System.getProperty("username");
	ExtentTest test;
	
	/*String password = System.getProperty("pass");
	String user = System.getProperty("user");*/

	public LoginTest() throws IOException 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void  loginSetUp() throws IOException 
	{
		// TODO Auto-generated method stub
		initializebrowser();
		
		NewExtendReport.newReport("CNQAOS Test", "cnqaos_login_script");
		test = NewExtendReport.extent.createTest("login testcase");
		test.log(Status.PASS, MarkupHelper.createLabel("browser load successfully", ExtentColor.GREEN));
		
		NewExtendReport.extent.flush();
		
	}
	
	@Test(enabled = true,dataProvider="LoginData")
	public void validLoginTestCaseOne(String user,String password) throws IOException, InterruptedException
	{
		loginPage = new LoginPage();
		homePage = new HomePage();
		
		loginPage.clickOnLoginButton(user,password);
		test.log(Status.PASS, MarkupHelper.createLabel(" this user login successfully = " + user, ExtentColor.GREEN));
		
		
		try 
		{
			String actualhomepagetitle = homePage.verifyHomePageTitle();
			
			Assert.assertEquals(actualhomepagetitle, expectedhomepagetitle, "home page not found");
			
			test.log(Status.PASS, MarkupHelper.createLabel("home page verify successfully", ExtentColor.GREEN));
				
		} catch (Exception e) 
		{
			
			Alert alert = driver.switchTo().alert();
			String alerttext = alert.getText();
			System.out.println(alerttext);
			
			alert.accept();
			test.log(Status.PASS, MarkupHelper.createLabel("fail to identify home page", ExtentColor.GREEN));
			
		}
				
	}
	
	
	@AfterMethod
	public void closedBrowser() 
	{
		
		NewExtendReport.extent.flush();
		driver.close();
		
		// TODO Auto-generated method stub

	}
	
	@AfterSuite
	
	public  void sendEmail() throws InterruptedException {
		// TODO Auto-generated method stub
		
		//emailReport.execute("cnqaos_login_script");
	}
	
	@DataProvider
	public  Object[][] LoginData() throws IOException
	{
		 Object objects[][] = TestUtils.getExcelDataBasedOnStartingPoint(sheetname, filepath, "login");
		 return objects;
	}

}
