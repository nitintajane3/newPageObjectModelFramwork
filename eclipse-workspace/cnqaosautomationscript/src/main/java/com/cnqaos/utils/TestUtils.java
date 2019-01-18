package com.cnqaos.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cnqaos.testbase.TestBase;

public class TestUtils extends  TestBase
{
	

	public TestUtils() throws IOException 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public static int PAGELOAD = 20;
	public static int IMPLICIT = 10;

	public static String userdirectory = System.getProperty("user.dir");
	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;
	public static BufferedInputStream bs;
	
	
	public static Object[][] getTestData(String sheetName, String filepath) throws IOException {
	
		try {
					
	        bs = new BufferedInputStream(new FileInputStream(userdirectory + filepath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(bs);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		
	
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println("last row of sheet  " + sheet.getLastRowNum() + " last cell of sheet " +
		sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) 
		{
			Row row = sheet.getRow(i + 1);
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) 
			{
				
				 Cell cell = row.getCell(k);
				 String value;
	               try {
				  value = cell.getRichStringCellValue().toString();
	               } catch (Exception e) {
	                   
	            	   value = ((XSSFCell) cell).getRawValue();
	                }
				
				data[i][k] = value;
				System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	

	public static void takeScreenshotAtEndOfTest() throws IOException
	{
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		String DateStr = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + DateStr + ".png"));
	}

}
