package com.cnqaos.pages.trainings;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cnqaos.pages.LoginPage;
import com.cnqaos.testbase.TestBase;

public class TrainingContentMappingPage extends TestBase
{

	public TrainingContentMappingPage() throws IOException 
	{
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//td[@align='center']/dir-pagination-controls/ul/li")
	List<WebElement> paginationcount;
	
	@FindBy(xpath="//li[@class='ng-scope']/a[@ng-click='setCurrent(pagination.current + 1)']/ancestor::li[1]/preceding-sibling::li[1]/a")
	WebElement totalnumberofpage;
	
	@FindBy(xpath="//table[@class='table  table-striped']/tfoot/tr/td/dir-pagination-controls/ul/li[@class='ng-scope']/a[@ng-click='setCurrent(pagination.current + 1)']")
	WebElement btnforwordpegination;
	
	@FindBy(xpath="//div[@id='main']/div[3]/ul/li[2]/a")
	WebElement activitypageafterclick;
	
	@FindBy(xpath="//button[@class='button multiSelectButton ng-binding']")
	WebElement selectactivitydropdown;
	
	@FindBy(xpath="//div[@id='midd-container']/div/div[3]/div/form/div[1]/div[1]/span/div/form/div[1]/div[2]/input")
	WebElement searchboxinsidefilter;
	
	@FindBy(xpath="//div[@class='checkboxLayer show']/form/div[2]/div[1]/div")
	WebElement selectfirstrecord;
	
	@FindBy(xpath="//button[@class='clearButton']")
	WebElement cleardrpdwnsearchfield;
	
	@FindBy(xpath="//div[@class='checkBoxContainer']/div[@class='multiSelectItem ng-scope vertical selected']")
	List<WebElement> listofselectedelement;
	
	@FindBy(xpath="//div[@id='midd-container']/div/div[3]/div/form/button")
	WebElement mappingcreatebutton;
	
	public void SelectRecordAndClickOnActivityLink(String trainingname) throws InterruptedException 
	{
		
		int actualsizeofpegination = paginationcount.size();
		String pages = totalnumberofpage.getText();
		int lastpagenumber = Integer.parseInt(pages);
		int count = 0;
	if (actualsizeofpegination!=0) 
	{
		
		
		for(int k =1;k<=lastpagenumber;k++)
		{
			
		   for(int i=1;i<=10;i++)
		  {
			Thread.sleep(500);   
			WebElement readname = driver.findElement(By.xpath("//table[@class='table  table-striped']/tbody/tr["+i+"]/td[2]"));
			String getname = readname.getText();
			
			    if(getname.equals(trainingname)) 
			  {
				driver.findElement(By.xpath("//table[@class='table  table-striped']/tbody/tr["+i+"]/td[6]/a")).click();
				count = 1;
				break;
			  }
		  }
		   if(count==1) {break;}
		     try 
		     {
		    	 btnforwordpegination.click();
		    	 Thread.sleep(4000);
		     } catch (Exception e) 
		            {
			            System.out.println("not record found");
		            }  
		     
		}
		
		
	}else 
	{
		for(int i=1;i<=10;i++)
		{
					
			WebElement readname = driver.findElement(By.xpath("//table[@class='table  table-striped']/tbody/tr["+i+"]/td[2]"));
			String getname = readname.getText();
			
			if(getname.equals(trainingname)) 
			{
				driver.findElement(By.xpath("//table[@class='table  table-striped']/tbody/tr["+i+"]/td[6]/a")).click();
				break;
			}
			
			
		}
	}
	
	}
	
	public void verifyActivityPageDisplayOrNot() 
	{
		try 
		{
		String breadcrumbstitle = activitypageafterclick.getText();
		
		if (breadcrumbstitle.contains("Activity")) 
		{
			System.out.println("activity page open successfully");
		}
		} catch (Exception e) 
		{
			// TODO: handle exception
			System.out.println("activity page not found");
		}
	}
	
	public void clickOnActivityDropDown() throws InterruptedException 
	{
		selectactivitydropdown.click();
		
	}
	
	public void selectSigleActivityByName(String singleactivtyselect) 
	{
        searchboxinsidefilter.sendKeys(singleactivtyselect);
        
       int countlistofselected = listofselectedelement.size();
       
       if (countlistofselected ==  0) 
        {
        	selectfirstrecord.click();
        	
		}else if (countlistofselected == 1) 
		{
			
		} else if (countlistofselected > 1) 
		{
			for(int i=1;i<=countlistofselected;i++)
			{
			WebElement readselectedtext = driver.findElement(By.xpath("//div[@class='checkBoxContainer']/div[@class='multiSelectItem ng-scope vertical selected']["+i+"]/div/label/span"));
			String actualfullname = readselectedtext.getText();
			String[] spoir = actualfullname.split("\\s+", 3);
			String actualname = spoir[2];
			if (actualname.equals(singleactivtyselect)) 
			{
				System.out.println("activity already selected");
				break;
			}

			}
			
		} 
		
		cleardrpdwnsearchfield.click();
		
	}
	
	public void createMappingButton()
	{
	 mappingcreatebutton.click();	
	}

}
