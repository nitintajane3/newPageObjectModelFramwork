package com.cnqaos.pages.trainings;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cnqaos.testbase.TestBase;

public class TrainingContentPage extends TestBase
{
	Actions action =  new Actions(driver);
	Select select;
	
	public TrainingContentPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="")
	WebElement test;
	
	@FindBy(xpath="//div[@class='navigation-link']/ul/li[@class='dropdown-menu-sub-indicator']/a[contains(text(),'Training')]")
	WebElement trainingmenu;
	
	@FindBy(xpath="//div[@class='navigation-link']/ul/li[4]/ul/li[1]/a")
	WebElement trainingcontentmenu;
	
	@FindBy(xpath="//div[@class='navigation-link']/ul/li[4]/ul/li[1]/ul/li[2]/a")
	WebElement addtrainingoption;
	
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
	
	public void clickOnAddTrainingOption() 
	{
		action.moveToElement(trainingmenu).perform();
        action.moveToElement(trainingcontentmenu).perform();
        action.moveToElement(addtrainingoption).click().perform();
	}
	
	public void clickonAddButton() 
	{
		addbutton.click();
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
		createbutton.click();
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
	
}
