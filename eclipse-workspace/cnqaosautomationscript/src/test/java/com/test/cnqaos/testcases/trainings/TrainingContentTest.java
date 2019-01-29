package com.test.cnqaos.testcases.trainings;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cnqaos.pages.LoginPage;
import com.cnqaos.pages.trainings.TrainingContentPage;
import com.cnqaos.testbase.TestBase;

public class TrainingContentTest extends TestBase
{
	TrainingContentPage trainingcontentpage ;
	
	public TrainingContentTest() throws IOException 
	{
		super();
		
	}

	LoginPage loginpage;
	
	
	@BeforeTest
	public void Setup() throws IOException, InterruptedException
	{
	
		initializebrowser();
		
		loginpage  = new LoginPage();
		
		loginpage.clickOnLoginButton(prob.getProperty("username"),prob.getProperty("password"));
		
		trainingcontentpage = new TrainingContentPage();
        
	}
	
	@Test
	public void addTrainingTest() throws InterruptedException
	{
		String newentername = "nitni";
		String trainingtypename = "Alternance certifiante";
		
		trainingcontentpage.clickOnAddTrainingOption();
		
		trainingcontentpage.clickonAddButton();
		
		trainingcontentpage.enterName(newentername);
		
		trainingcontentpage.selectTrainingType(trainingtypename);
		
		trainingcontentpage.clickOnActive();
		
		trainingcontentpage.clickOnPublic();
		
		trainingcontentpage.clickOnCreateButton();
		
		widnowsAlertAccept();
		
		String expectedrecordname = trainingcontentpage.verifyRecordUpdateOrNot(newentername);
		
		Assert.assertEquals(newentername, expectedrecordname);
	}
}
