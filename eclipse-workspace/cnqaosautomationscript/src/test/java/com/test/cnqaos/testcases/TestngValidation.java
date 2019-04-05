package com.test.cnqaos.testcases;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cnqaos.testbase.TestBase;
import com.sun.corba.se.spi.orbutil.fsm.Action;


public class TestngValidation extends TestBase
{
	
	public TestngValidation() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	 final int cour =5;
	
	@BeforeTest()
	public void testbefore()
	{
		System.out.println("before test @ before test");
		Actions sct =  new Actions(driver);
		sct.click().build().perform();
		
	WebElement enene = null;
	
	
	enene.findElement(By.xpath("")).click();
	}
	
	@Test(enabled = false)
	public  void testcase()
	{
		System.out.println("test case 1 one excecute ");
	}
	
	@Test(dependsOnMethods ="testcase3",enabled = false)
	public  void testcase2()
	{
		System.out.println("test case 2 two excecute ");
	}
	
	@Test()
	public  void testcase3()
	{
		System.out.println("test case 3 three excecute " );
		
	}
	
	@AfterTest
	public void teardown()
	{
		System.out.println("@ afte test tear down ");
	}

}
