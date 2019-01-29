package com.test.cnqaos.testcases.users;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cnqaos.pages.LoginPage;
import com.cnqaos.pages.users.StudentPage;
import com.cnqaos.pages.users.UserPage;
import com.cnqaos.testbase.TestBase;

public class EditUserTest extends TestBase
{
	UserPage userpage;
	StudentPage studentpage;
	
	String centername = "amrutvahini";   //amrutvahini
	String selectusertoupdate = "user manager amrutvahini";
	String userupdatedname = "update from autoamtion script";
	
	
	public EditUserTest() throws IOException
	{
		super();
		
	}

	@BeforeMethod
	public void userSetUp() throws IOException, InterruptedException
	{
		initializebrowser();
		
		LoginPage loginpages = new LoginPage();
		
		loginpages.clickOnLoginButton(prob.getProperty("username"), prob.getProperty("password"));
		 
		userpage =  new UserPage();
			
		userpage.AddUserLink();
		
		studentpage = new StudentPage();
		
	}
	
	@Test(enabled  =  true)
	public void updateUserRecordTest() throws IOException, InterruptedException
	{
		selectUser(centername,selectusertoupdate,userupdatedname);
		
		 userpage.clickOnUpdateButton();
        
         widnowsAlertAccept();
		
         String expetetnamefromlist = studentpage.checkStudentUpdateOrNot(userupdatedname);
         
         Assert.assertNotEquals(selectusertoupdate, expetetnamefromlist,"same record found ");
         
         System.out.println("before update the user name is = " + selectusertoupdate);
 		
 		System.out.println("after update the user name is = " + expetetnamefromlist);
	}
	
	
	@Test(enabled=true)
	public void tryToUpdateUserRecordButCancelIt() throws IOException, InterruptedException
	{
		selectUser(centername,selectusertoupdate,userupdatedname);
		
		userpage.clickOnCancelButton();
		 
		String expetetnamefromlist = studentpage.checkStudentUpdateOrNot(selectusertoupdate);
		 
		Assert.assertEquals(selectusertoupdate, expetetnamefromlist,  "record  updated");
			
		System.out.println("before update the user name is = " + selectusertoupdate);
			
		System.out.println("after update the user name is = " + expetetnamefromlist);
		 
		 
	}
	
	public void selectUser(String centername,String selectusertoupdates,String enteruserupdatedname) throws IOException, InterruptedException 
	{
		studentpage.selectCenter(centername);
		studentpage.SelectRecordAndClickOnEditBtn(selectusertoupdates,9);   //8 is index value of edit  button for  user only
		userpage.enterName(enteruserupdatedname);
	}
	
	@AfterMethod
	public void tearDown()
	{
	   driver.close();	
	}

}
