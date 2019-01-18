package com.cnqaos.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cnqaos.testbase.TestBase;

public class LoginPage extends TestBase
{
	
	
	public LoginPage()throws IOException 
	{
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='ng-binding'][@href='#login']")
	WebElement signinbuttonn;
	
	@FindBy(xpath = "//input[@id='userCode']")
	WebElement usernametext;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordtext;
	
	@FindBy(xpath = "//button[@class='btn btn-default common-btn ng-binding'][@data-ng-click='login()']")
	WebElement loginbutton;
	


	
	
	public void clickOnLoginButton(String username,String password) throws IOException 
	{
		signinbuttonn.click();
	    usernametext.sendKeys(username);
	    passwordtext.sendKeys(password);
	    loginbutton.click();
	    
	    
	}

	
	
	
	

}