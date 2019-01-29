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

public class EditStudentTest extends TestBase
{
	StudentPage studentPage ;
	UserPage userPage ;
	
	String centername = "Ashwini SM joshi";   //amrutvahini
	String selectstudenttoupdate = "student protonmail nitihn";
	String studentupdatedname = "nitin updateed name";
	
	
	public EditStudentTest() throws IOException 
	{
		super();
		
	}

	@BeforeMethod
	public void studentSetUp() throws IOException
	{
		initializebrowser();
		
		LoginPage loginpages = new LoginPage();
		
		loginpages.clickOnLoginButton(prob.getProperty("username"), prob.getProperty("password"));
		
		studentPage =  new StudentPage();
		
		userPage = new UserPage();
		
		studentPage.addStudentLink();
		
	}
	
	@Test(description="edit student record by name and update it",enabled = true,priority =0)
	public void updateStudentRecord() throws InterruptedException
	{
		
		
		selectStudentRecord(centername,selectstudenttoupdate,studentupdatedname);
		
		
        studentPage.clickOnUpdateButton();
        
        widnowsAlertAccept();
		
		String expetetnamefromlist = studentPage.checkStudentUpdateOrNot(studentupdatedname);
		
		Assert.assertNotEquals(selectstudenttoupdate, expetetnamefromlist,"same record found ");
		
		System.out.println("before update the student name is = " + selectstudenttoupdate);
		
		System.out.println("after update the student name is = " + expetetnamefromlist);
		
	}
	
	
	
	@Test(description="edit record and update name but click on cancel button",enabled = true,priority =1)
	public void tryToUpdateStudentRecordButCancelIt() throws InterruptedException
	{
		
        selectStudentRecord(centername,selectstudenttoupdate,studentupdatedname);
        
		
        studentPage.clickOnCancelButton();
		
		String expetetnamefromlist = studentPage.checkStudentUpdateOrNot(selectstudenttoupdate);
		
		Assert.assertEquals(selectstudenttoupdate, expetetnamefromlist,  "record  updated");
		
		System.out.println("before update the student name is = " + selectstudenttoupdate);
		
		System.out.println("after update the student name is = " + expetetnamefromlist);
		
	}
	
	public void selectStudentRecord(String center,String selectstudenttoupdate,String enterstudentupdatedname) throws InterruptedException 
	{
		
		studentPage.selectCenter(center);
		
		studentPage.SelectRecordAndClickOnEditBtn(selectstudenttoupdate,12);   //12 is index value of edit  button for  student only
		
		userPage.enterName(enterstudentupdatedname);
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
		
	
	
}
