package com.test.cnqaos.testcases;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cnqaos.testbase.TestBase;


public class TestngValidation
{
	
	final int cour =5;
	
	@BeforeTest()
	public void testbefore()
	{
		System.out.println("before test @ before test");
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
