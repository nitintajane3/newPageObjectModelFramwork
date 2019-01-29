package com.test.cnqaos.testcases.users;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cnqaos.pages.LoginPage;
import com.cnqaos.pages.users.UserPage;
import com.cnqaos.testbase.TestBase;
import com.cnqaos.utils.TestUtils;

public class AddUserTest extends TestBase
{

	String sheetname = "Sheet1";
	UserPage adduserpage;
	String filepath = "/src/main/java/com/cnqaos/testdata/cnqaosuseraccountdata.xlsx";
	LoginPage loginPage;
	boolean b;
	
	
	
	
	public AddUserTest() throws IOException 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeTest
	public void Setup() throws IOException, InterruptedException
	{
	
		initializebrowser();
		
		loginPage  = new LoginPage();
		
		loginPage.clickOnLoginButton(prob.getProperty("username"),prob.getProperty("password"));
		
        adduserpage =  new UserPage();
		
		adduserpage.AddUserLink();
		
	
	}
	
	@Test(dataProvider= "AddUserDataSheet", enabled = true)
	public void addUsersTest(String centername,String civilstatusname,String sexname,String name,String address,String country,
			String city,String postalcode,String phonenumber,String emailaddress,String rolename,String quality,String speciality,
			String copanytype,String companynumber,String contracttype,
			String sebrogated,String activities, String validated,String active) throws IOException, InterruptedException
	
	{
		
		
		adduserpage.addUserButton();
		
		adduserpage.selectCenter(centername);
		
		adduserpage.selectCivilStatus(civilstatusname);
		
		adduserpage.selectSex(sexname);
		
		adduserpage.enterName(name);
		
		adduserpage.enterAddress(address);
		
		adduserpage.selectCountry(country);
		
		adduserpage.selectCity(city);
		
		adduserpage.enterPostalCode(postalcode);
		
		adduserpage.enterPhoneNumber1(phonenumber);
		
		adduserpage.enterEmailAddress(emailaddress);
		
		adduserpage.selectRole(rolename);
		
			
		
		if(rolename.equals("Employeur"))
		{
			adduserpage.selectQuality(quality);
			
			adduserpage.selectSpeciality(speciality);
			
			adduserpage.selectCompanyType(copanytype);
			
			adduserpage.enterCompanyNumber(companynumber);
			
			adduserpage.selectContractType(contracttype);
			
			b = Boolean.parseBoolean(sebrogated);
			
			adduserpage.checkSebrogated(b);
		
		}else if (rolename.equals("Formateur")) 
		{
			adduserpage.selectActivities(activities);
		}else 
		{
			System.out.println("no role match");

		}
		
		b = Boolean.parseBoolean(validated);
		
		adduserpage.checkValidated(b);
		
		b = Boolean.parseBoolean(active);
		adduserpage.checkActive(b);
		
		adduserpage.createRecord();
		
		Thread.sleep(6000);
	
		Alert alert = driver.switchTo().alert();
		String alertmessage = alert.getText();
		
		if(alertmessage.equals(""))
        {
			
        }
		
		alert.accept();		
		
		Thread.sleep(500);
		
		adduserpage.verifyUserAddedOrNot(name);
	}
	
	@AfterTest
	public  void ClosedBrower()
	{
		driver.close();
	}
	
	@DataProvider
	public  Object[][] AddUserDataSheet() throws IOException
	{
		 Object objects[][] = TestUtils.getTestData(sheetname,filepath);
		 return objects;
	}


}
