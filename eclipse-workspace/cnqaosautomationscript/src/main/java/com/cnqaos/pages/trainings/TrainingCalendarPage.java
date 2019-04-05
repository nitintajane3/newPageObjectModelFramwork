package com.cnqaos.pages.trainings;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.cnqaos.testbase.TestBase;
import com.google.common.base.Function;

public class TrainingCalendarPage extends TestBase
{
	Actions actionclendar = new Actions(driver);

	public TrainingCalendarPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//ul[@id='example3']/li[4]/a[contains(text(),'Training')]")
	WebElement trainingmenu;
	
	@FindBy(xpath="//div[@class='navigation-link']/ul/li[4]/ul/li[2]/a")
	WebElement trainingcalendarmenu;
	
	@FindBy(xpath="//div[@class='navigation-link']/ul/li[4]/ul/li[2]/ul/li[2]/a")
	WebElement  addtrainingcalendar;
	
	@FindBy(xpath="//div[@class='navigation-link']/ul/li[4]/ul/li[2]/ul/li[3]/a")
	WebElement  modulecalendarmenu;
	
	@FindBy(xpath="//div[@class='navigation-link']/ul/li[4]/ul/li[2]/ul/li[3]/ul/li[2]/a")
	WebElement addmodulecalendar;
	
	@FindBy(xpath="//span[@id='select2-center-container']")
	WebElement center;
	
	@FindBy(xpath="//span[@class='select2-dropdown select2-dropdown--below']/span/input[@type='search']")
	WebElement centersearchfield;
	
	@FindBy(xpath="//span[@class='select2-dropdown select2-dropdown--below']/span[2]/ul/li[1]")
	WebElement firstrecordsort;
	
	@FindBy(xpath="//span[@id='select2-calendarStatus-container']")
	WebElement status;
	
	@FindBy(xpath="//span[@id='select2-status-container']")
	WebElement statusfromfilter;
	
	@FindBy(xpath="//input[@class='select2-search__field'][@type='search']")
	WebElement searchbox;
	
	@FindBy(xpath="//span[@class='select2-results']/ul/li[1]")
	WebElement searchresult;
	
	@FindBy(xpath="//label[contains(text(),'Training')]/following-sibling::div[1]/span/span[1]")
	WebElement trainingname;
	
	@FindBy(xpath="//span[@id='select2-trainingType-container']")
	WebElement filtertrainingtype;
	
	@FindBy(xpath="//span[@id='select2-training-container']")
	WebElement filtertraining;
	
	@FindBy(xpath="//div[@class='listing-toparea']/span[4]/span[1]/span/span[@class='select2-selection__arrow']")
	WebElement filtertrainingcalednar;
	
	@FindBy(xpath="//button[@data-ng-click='search()']")
	WebElement searchbtn;
	
	@FindBy(xpath="//label[contains(text(),'Activity')]/following-sibling::div[1]/span/span[1]")
	WebElement activitylabel;
	
	@FindBy(xpath="//label[contains(text(),'Module')]/following-sibling::div[1]/span/span[1]")
	WebElement modulelabel;
	
	@FindBy(xpath="//label[contains(text(),'Training Perform Day')]/following-sibling::div[1]/span/span[1]/span")
	WebElement trainingperformday;
	
	@FindBy(xpath="//label[contains(text(),'Start Date')]/following-sibling::div[1]/input")
	WebElement startdate;
	
	@FindBy(xpath="//label[contains(text(),'End Date')]/following-sibling::div[1]/input")
	WebElement enddate;
	
	public void clickOnAddTrainingCalendar() throws InterruptedException 
	{
		
		actionclendar.moveToElement(trainingmenu).perform();
		Thread.sleep(500);
		actionclendar.moveToElement(trainingcalendarmenu).perform();
		Thread.sleep(500);
		actionclendar.moveToElement(addtrainingcalendar).click().perform();	
	}
	
	public void clickOnAddModuleCalendar() throws InterruptedException 
	{
		actionclendar.moveToElement(trainingmenu).perform();
		Thread.sleep(500);
		actionclendar.moveToElement(trainingcalendarmenu).perform();
		Thread.sleep(500);
		actionclendar.moveToElement(modulecalendarmenu).perform();
		Thread.sleep(500);
		actionclendar.moveToElement(addmodulecalendar).click().perform();
	}
	
	public void selectCenter(String centernametxt) 
	{
		actionclendar.moveToElement(center).perform();
		center.click();
		centersearchfield.sendKeys(centernametxt);
		firstrecordsort.click();
	}
	
	public void selectStaus(String statusname) 
	{
	
		status.click();
		searchbox.sendKeys(statusname);
		searchresult.click();
	}
	
	public void selectStausFromFilter(String statusname) 
	{
	
		statusfromfilter.click();
		searchbox.sendKeys(statusname);
		searchresult.click();
	}
	
	public void selectTraining(String traininngname) 
	{
		trainingname.click();
		searchbox.sendKeys(traininngname);
		searchresult.click();
	
	}
	
	public void selectTrainingTypeFromFilter(String traininngname) 
	{
		filtertrainingtype.click();
		searchbox.sendKeys(traininngname);
		searchresult.click();
	
	}
	
	public void selectTrainingFromFilter(String traininngname) 
	{
		filtertraining.click();
		searchbox.sendKeys(traininngname);
		searchresult.click();
	
	}
	
	public void selectTrainingCalednarFromFilter(String traininngname) throws InterruptedException 
	{
		/*JavascriptExecutor exectue = (JavascriptExecutor)driver;
		exectue.executeScript("arguments[0].click();", filtertrainingcalednar);*/
		
		Thread.sleep(700);		        
		filtertrainingcalednar.click();
		searchbox.sendKeys(traininngname);
		searchresult.click();
	}
	
	public String verifyRecordUpdateOrNot(String nametext) 
	{
		String expectedreturnname ="";
		for(int i=1;i<=10;i++)
		{
			try 
			{
				
			
			WebElement readname = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]"));
			String getname = readname.getText();
			
			   if(getname.equals(nametext)) 
			   {
				WebElement webelementname = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]"));
				String actualgetname = webelementname.getText();
				System.out.println("record added successfully");
				expectedreturnname = actualgetname;
				break;
			    }
		
			} catch (Exception e) 
			  {
				System.out.println("record not found");
			    break;
		      }
		}
		return expectedreturnname;
	}
	
	public void searchButton() 
	{
		searchbtn.click();	
	}
	
	public void selectActivity(String visibletext) 
	{
		
		activitylabel.click();
		searchbox.sendKeys(visibletext);
		searchresult.click();
		
	}
	
	public void selectModule(String visibletext) 
	{
	
		modulelabel.click();
		searchbox.sendKeys(visibletext);
		searchresult.click();
		
	}
	
	public void selectTrainingPerformday(String text) 
	{
	
		trainingperformday.click();
		searchbox.sendKeys(text);
		searchresult.click();
		
	}
	
	public void enterStartDate(String datestrt) 
	{
		startdate.sendKeys(datestrt);
	}
	
	public void enterEndDate(String datend) 
	{
		enddate.sendKeys(datend);
	}
}
