package com.test.cnqaos.testcases.trainings;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cnqaos.pages.LoginPage;
import com.cnqaos.pages.trainings.TrainingContentPage;
import com.cnqaos.testbase.TestBase;

public class TrainingContentTest extends TestBase
{
	TrainingContentPage trainingcontentpage ;
	
	String trainingname = "nitni3434354";
	String trainingtypename = "Alternance certifiante";
	String activityname= "nitintajane12255";
	String modulename = "nitin module1155";
	String submodulename = "nitin submodule1166";
	String selectsubmoduletype = "Théorique";
	String hours = "12";
	String minutes = "10";
	String modulerate = "12";
	String submodulerate = "25";
	
	
	public TrainingContentTest() throws IOException 
	{
		super();
		
	}

	
	LoginPage loginpage;
	
	
	
	@BeforeMethod
	public void Setup() throws IOException, InterruptedException
	{
	
		initializebrowser();
		
		loginpage  = new LoginPage();
		
		loginpage.clickOnLoginButton(prob.getProperty("username"),prob.getProperty("password"));
		
		trainingcontentpage = new TrainingContentPage();
        
	}
	
	@Test(enabled = true,priority =0)
	public void addTrainingTest() throws InterruptedException
	{
		
		
		trainingcontentpage.clickOnAddTrainingOption();
		
		trainingcontentpage.clickonAddButton();
		
		trainingcontentpage.enterName(trainingname);
		
		trainingcontentpage.selectTrainingType(trainingtypename);
		
		trainingcontentpage.clickOnActive();
		
		trainingcontentpage.clickOnPublic();
		
		verifyRecordAndAlert(trainingname);
		
		
	}
	
	@Test(enabled = true,priority =1)
	public void addActivityTest() throws InterruptedException
	{
		
		trainingcontentpage.clickOnAddActivityOption();
		
		Thread.sleep(1000);
		
		trainingcontentpage.clickonAddButton();
		
		trainingcontentpage.enterName(activityname);
		
		trainingcontentpage.clickOnActive();
		
		
		verifyRecordAndAlert(activityname);
        	
	}
	
	@Test(enabled =  true,priority =2)
	public void addModuleTest() throws InterruptedException
	{
		
		trainingcontentpage.clickOnAddModuleOption();
		
		trainingcontentpage.selectActivityFromDropDown(activityname);
		
		trainingcontentpage.clickonAddButton();
		
		trainingcontentpage.enterName(modulename);
		
		trainingcontentpage.enterModuleRate(modulerate);
		
		
		verifyRecordAndAlert(modulename);
		
	}
	@Test(enabled =  true,priority =3)
	public void addSubModuleTest() throws InterruptedException 
	{
		trainingcontentpage.clickOnAddSubModuleOption();
		
		trainingcontentpage.clickonAddButton();
		
		trainingcontentpage.enterName(submodulename);
		
		trainingcontentpage.selectSubModuleType(selectsubmoduletype);
		
		trainingcontentpage.enterDurationHours(hours);
		
		trainingcontentpage.enterDurationMinutes(minutes);
		
		trainingcontentpage.enterSubModuleRate(submodulerate);
		
		
		verifyRecordAndAlert(submodulename);
		
		
	}
	
	@AfterMethod
	public void tearDown() 
	{
	   driver.close();	
	}
	
	public void verifyRecordAndAlert(String verifytext) throws InterruptedException 
	{
		trainingcontentpage.clickOnCreateButton();
		
        String alerttext = widowsAlertGetText();
		
		widnowsAlertAccept();
		
		if (alerttext.contains("is already exist.")) 
		{
			System.out.println("found duplicate record");
		}else 
		{
			String expectedrecordname = trainingcontentpage.verifyRecordUpdateOrNot(verifytext);
			
			Assert.assertEquals(verifytext, expectedrecordname);
		}	
	}
	
}
