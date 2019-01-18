package com.cnqaos.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cnqaos.testbase.TestBase;

public class HomePage extends TestBase
{
	
	 public HomePage() throws IOException
	{
		PageFactory.initElements(driver, this);
		 // TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath ="//a[@class='ng-binding ng-scope'][@href='#/guest-home']")
	WebElement homepagetitle;
	
	@FindBy(xpath="//ul[@class='dropdown-menu']/li[6]/a")
	WebElement userdropdownicon;
	
	
	
	public String verifyHomePageTitle() 
	{
		String titlename = homepagetitle.getText();
		return titlename;
	}

}
