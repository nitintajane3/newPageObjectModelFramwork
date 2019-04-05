package com.test.cnqaos.testcases.trainings;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cnqaos.pages.LoginPage;
import com.cnqaos.pages.trainings.TrainingContentMappingPage;
import com.cnqaos.pages.trainings.TrainingContentPage;
import com.cnqaos.testbase.TestBase;

public class TrainingContentMappingTest extends TestBase
{

	public TrainingContentMappingTest() throws IOException 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	TrainingContentPage trainingcontentpage ;
	TrainingContentMappingPage trainingcontentmappingpage ;
    LoginPage loginpage;
		
	@BeforeMethod
	public void Setup() throws IOException, InterruptedException
	{
	
		initializebrowser();
		
		loginpage  = new LoginPage();
		
		loginpage.clickOnLoginButton(prob.getProperty("username"),prob.getProperty("password"));
		
		trainingcontentpage = new TrainingContentPage();
		
		trainingcontentmappingpage = new TrainingContentMappingPage();
        
	}
	
	@Test
	public  void mapingActivityToTraining() throws InterruptedException
	{
		
		trainingcontentpage.clickOnAddTrainingOption();
		
		trainingcontentmappingpage.SelectRecordAndClickOnActivityLink("jspm electronic type AC");
		
		trainingcontentmappingpage.verifyActivityPageDisplayOrNot();
		
		trainingcontentpage.clickonAddButton();
		
		trainingcontentmappingpage.clickOnActivityDropDown();
		
		trainingcontentmappingpage.selectSigleActivityByName("nitintajane122");
		
		trainingcontentmappingpage.selectSigleActivityByName("nitintajane12255");
		
		trainingcontentmappingpage.createMappingButton();
		
		widnowsAlertAccept();
		
		
		
	}

}
