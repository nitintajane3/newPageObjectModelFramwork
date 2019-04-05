package com.test.cnqaos.testcases.trainings;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cnqaos.pages.LoginPage;
import com.cnqaos.pages.trainings.TrainingCalendarPage;
import com.cnqaos.pages.trainings.TrainingContentPage;
import com.cnqaos.testbase.TestBase;

public class TrainingCalendarTest extends TestBase
{

	LoginPage loginpage;
	TrainingCalendarPage trainingCalendarPage;
	TrainingContentPage trainingcontentpage ;
	String centernametext =  "amrutvahini";
	String statusname =  "A venir";
	String trainingtypename = "Alternance certifiante";
	String traininngname = "amrut computer AC";
	String trainingcalendarname = "training calendar automation";
	
	public TrainingCalendarTest() throws IOException 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void initializeTest() throws IOException
	{
		initializebrowser();
        loginpage  = new LoginPage();
		
		loginpage.clickOnLoginButton(prob.getProperty("username"),prob.getProperty("password"));
		trainingCalendarPage = new TrainingCalendarPage();
		trainingcontentpage = new TrainingContentPage();
	}
	
	
	@Test(enabled =  false)
	public void addTrainingCalendarTest() throws InterruptedException 
	{
		
		trainingCalendarPage.clickOnAddTrainingCalendar();
		
		Thread.sleep(500);
		
		trainingCalendarPage.selectCenter(centernametext);
		
		trainingCalendarPage.selectStaus(statusname);
		
		trainingcontentpage.clickonAddButton();
		
		trainingcontentpage.selectTrainingType(trainingtypename);
		
		trainingCalendarPage.selectTraining(traininngname);
		
		trainingcontentpage.enterName(trainingcalendarname);
		
		verifyRecordAndAlert(trainingcalendarname);
		
	}
	
	@Test
	public void addModuleCalendarTest() throws InterruptedException
	{
		trainingCalendarPage.clickOnAddModuleCalendar();
		
		trainingCalendarPage.selectCenter(centernametext);
		
		trainingCalendarPage.selectTrainingTypeFromFilter(trainingtypename);
		
		trainingCalendarPage.selectTrainingFromFilter(traininngname);
		
		trainingCalendarPage.selectTrainingCalednarFromFilter(trainingcalendarname);
		
		trainingCalendarPage.selectStausFromFilter(statusname);
		
		trainingCalendarPage.searchButton();
		
		trainingcontentpage.clickonAddButton();
		
		trainingCalendarPage.selectActivity("nitintajane122");
		
		//trainingCalendarPage.selectModule("nitin module1155");
		
		trainingCalendarPage.selectTrainingPerformday("Vendredi");
		
		trainingCalendarPage.enterStartDate("12-02-2019");
		
		trainingCalendarPage.enterEndDate("14-02-2019");
		
		
		
		
		
		

	}
	
	@AfterMethod
	public void closedBrowser() 
	{
	//driver.close();	
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
			String expectedrecordname = trainingCalendarPage.verifyRecordUpdateOrNot(verifytext);
			
			Assert.assertEquals(verifytext, expectedrecordname);
		}	
	}

}
