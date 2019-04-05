package com.cnqaos.pages.trainings;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cnqaos.testbase.TestBase;

public class TrainingContentPage extends TestBase
{
	static Actions actiontest =  new Actions(driver);
	Select select;
	
	public TrainingContentPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//ul[@id='example3']/li[4]/a[contains(text(),'Training')]")
	WebElement trainingmenu;
	
	@FindBy(xpath="//div[@class='navigation-link']/ul/li[4]/ul/li[1]/a")
	WebElement trainingcontentmenu;
	
	@FindBy(xpath="//div[@class='navigation-link']/ul/li[4]/ul/li[1]/ul/li[2]/a")
	WebElement addtrainingoption;
	
	@FindBy(xpath="//div[@class='navigation-link']/ul/li[4]/ul/li[1]/ul/li[3]/a")
	WebElement addactivityoption;
	
	@FindBy(xpath="//div[@class='navigation-link']/ul/li[4]/ul/li[1]/ul/li[4]/a")
	WebElement addmoduleoption;
	
	@FindBy(xpath="//div[@class='navigation-link']/ul/li[4]/ul/li[1]/ul/li[5]/a")
	WebElement addsubmoduleoption;
	
	@FindBy(xpath="//div[@id='midd-container']/div/div[3]/button")
	WebElement addbutton;
	
	@FindBy(xpath="//label[contains(text(),'Name')]/following-sibling::div/input")
	WebElement name;
	
	@FindBy(xpath="//label[contains(text(),'Type')]/following-sibling::div/select")
	WebElement trainingtype;
	
	@FindBy(xpath="//input[@id='active']")
	WebElement  active;
	
	@FindBy(xpath="//input[@id='isPublic']")
	WebElement ispublic;
	
	@FindBy(xpath="//div[@id='midd-container']/div/div[3]/div/form/div[4]/button[1]")
	WebElement createbutton;
	
	@FindBy(xpath="//div[@id='midd-container']/div/div[3]/div/form/div[4]/input")
	WebElement cancelbutton;
	
	@FindBy(xpath="//span[@id='select2-activity-container']")
	WebElement activitydropdownicon;
	
	@FindBy(xpath="//span[@class='select2-dropdown select2-dropdown--below']/span[1]/input[@type='search']")
	WebElement activitysearchfield;
	
	@FindBy(xpath="//span[@class='select2-dropdown select2-dropdown--below']/span[2]/ul/li[1]")
	WebElement selectfirstsearchresult;
	
	@FindBy(xpath="//input[@id='moduleFeePerHour']")
	WebElement modulerate;
	
	@FindBy(xpath="//input[@id='submoduleFeePerHour']")
	WebElement submodulerate;
	
	@FindBy(xpath="//select[@id='submoduleType']")
	WebElement submoduletypeselect;
	
	@FindBy(xpath="//input[@id='durationHours']")
	WebElement durationhoursfield;
	
	@FindBy(xpath="//input[@id='durationMinutes']")
	WebElement durationminutefield;
	
	public void moveToTrainingMenu() throws InterruptedException 
	{
		
		actiontest.moveToElement(trainingmenu).perform();
		Thread.sleep(500);
	}
	
	public void clickOnTrainingContent() throws InterruptedException 
	{
		moveToTrainingMenu();
		actiontest.moveToElement(trainingcontentmenu).perform();
		Thread.sleep(500);
	}
	
	
	public void clickOnAddTrainingOption() throws InterruptedException 
	{

		clickOnTrainingContent();
		
		actiontest.moveToElement(addtrainingoption).click().perform();
	}
	
	public void clickOnAddActivityOption() throws InterruptedException 
	{
		clickOnTrainingContent();
		actiontest.moveToElement(addactivityoption).click().perform();	
	}
	
	public void clickOnAddModuleOption() throws InterruptedException 
	{
		clickOnTrainingContent();
		actiontest.moveToElement(addmoduleoption).click().perform();	
	}
	
	public void clickOnAddSubModuleOption() throws InterruptedException 
	{
		clickOnTrainingContent();
		actiontest.moveToElement(addsubmoduleoption).click().perform();	
	}
	
	public void clickonAddButton() 
	{
		JavascriptExecutor execute = (JavascriptExecutor)driver;
		execute.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1000);");
			execute.executeScript("arguments[0].click();", addbutton);
		
	}
	
	public void enterName(String nametxt) 
	{
		name.sendKeys(nametxt);
	}
	
	public void selectTrainingType(String trainingtypename) 
	{
		select = new Select(trainingtype);
		select.selectByVisibleText(trainingtypename);
		
		
	}
	
	public void clickOnActive() 
	{
		active.click();
	}
	
	public void clickOnPublic() 
	{
		ispublic.click();
	}
	
	public void clickOnCreateButton() 
	{
		JavascriptExecutor javaexecute = (JavascriptExecutor)driver;
		javaexecute.executeScript("arguments[0].click();", createbutton);
		
	}
	
	public void clickOnCancelButton() 
	{
		cancelbutton.click();
	}
	
	public String verifyRecordUpdateOrNot(String nametext) 
	{
		String expectedreturnname ="";
		for(int i=1;i<=10;i++)
		{
			try 
			{
			WebElement readname = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]"));
			String getname = readname.getText();
			
			   if(getname.equals(nametext)) 
			   {
				WebElement webelementname = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]"));
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
	
	public void selectActivityFromDropDown(String activityname) 
	{
		activitydropdownicon.click();
		activitysearchfield.sendKeys(activityname);
		selectfirstsearchresult.click();
	}
	
	public void enterModuleRate(String moduleratetext) 
	{
		modulerate.clear();
		modulerate.sendKeys(moduleratetext);
	}
	
	public void selectSubModuleType(String visibletext) 
	{
		select = new Select(submoduletypeselect);
		select.selectByVisibleText(visibletext);
	}
	
	public void enterDurationHours(String hours) 
	{
		durationhoursfield.clear();
		durationhoursfield.sendKeys(hours);
	}
	
	public void enterDurationMinutes(String minutes) 
	{
		durationminutefield.clear();
		durationminutefield.sendKeys(minutes);
	}
	
	public void enterSubModuleRate(String submdulerate) 
	{
		submodulerate.clear();
		submodulerate.sendKeys(submdulerate);
	}
}
