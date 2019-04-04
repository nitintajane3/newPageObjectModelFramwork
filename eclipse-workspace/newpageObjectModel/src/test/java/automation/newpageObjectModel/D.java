package automation.newpageObjectModel;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D 
{
	public WebDriver driver;
	WebElement elementd;
	public void name() 
	{
		JavascriptExecutor test123 = (JavascriptExecutor)driver;
		
		test123.executeScript("window.scrollTo(arguments[0],arguments[1])", elementd.getLocation().x,elementd.getLocation().y);
	}
	
	public Alert getalerttest() 
	{
		return driver.switchTo().alert();
	}
	
	
	
	@Test
	public Boolean nitintajane(WebElement element) 
	{
		
		getalerttest();
			
		try {
			element.isDisplayed();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
		
		
		
		
		
		
		
	}
	
	
	
	
	


	
	
	
	
	
}
