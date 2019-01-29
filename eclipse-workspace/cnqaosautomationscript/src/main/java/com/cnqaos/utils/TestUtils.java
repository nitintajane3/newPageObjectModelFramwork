package com.cnqaos.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	public static WebDriverWait wait = new WebDriverWait(driver, 10);

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
	
	
	public static Object[][] getExcelDataBasedOnStartingPoint(String sheetName,String excellocation,String testName) 
	{
		try {
			String dataSets[][] = null;
			
			FileInputStream file = new FileInputStream(new File(excellocation));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheet(sheetName);
			// count number of active rows
			int totalRow = sheet.getLastRowNum();
			int totalColumn = 0;
			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			int i = 0;
			int count = 1;
			while (rowIterator.hasNext() && count == 1 || count == 2) {
				// System.out.println(i);

				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();
				int j = 0;
				while (cellIterator.hasNext()) {

					Cell cell = cellIterator.next();

					if (cell.getStringCellValue().contains(testName + "end")) {
						count = 0;
						break;
					}

					// System.out.println(sheetName+"Start");
					if (cell.getStringCellValue().contains(testName + "start")) {
						// count number of active columns in row
						totalColumn = row.getPhysicalNumberOfCells() - 1;
						// Create array of rows and column
						dataSets = new String[totalRow][totalColumn];
					}
					// System.out.println(sheetName+"Start");
					if (cell.getStringCellValue().contains(testName + "start") || count == 2) 
					{
						System.out.println(sheetName + "start");
						count = 2;
						// Check the cell type and format accordingly

						switch (cell.getCellType()) 
						{
						case Cell.CELL_TYPE_NUMERIC:
							dataSets[i - 1][j++] = cell.getStringCellValue();
							System.out.println(cell.getNumericCellValue());
							break;
						case Cell.CELL_TYPE_STRING:
							if (!cell.getStringCellValue().contains(testName + "start")) {
								dataSets[i - 1][j++] = cell.getStringCellValue();
								System.out.println(cell.getStringCellValue());
							}
							break;
						case Cell.CELL_TYPE_BOOLEAN:
							dataSets[i - 1][j++] = cell.getStringCellValue();
							System.out.println(cell.getStringCellValue());
							break;
						case Cell.CELL_TYPE_FORMULA:
							dataSets[i - 1][j++] = cell.getStringCellValue();
							System.out.println(cell.getStringCellValue());
							break;
						}

					}
				}

				System.out.println("");
				i++;
			}
			file.close();

			return parseData(dataSets, totalColumn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * This method is used to remove unwanted null data from array
	 * 
	 * @param data
	 * @return
	 */
	public static Object[][] parseData(Object[][] data, int colSize) {
		// Creating array list to store data;
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();

		// This array list will store one Array index data, every array index
		// has three sets of data
		ArrayList<String> list1;

		System.out.println(data.length);

		// running for loop on array size
		for (int i = 0; i < data.length; i++) {
			// creates a list to store the elements != null

			System.out.println(data[i].length);

			list1 = new ArrayList<String>();
			// this for loop will run on array index, since each array index has
			// three sets of data
			for (int j = 0; j < data[i].length; j++) {
				// this if will check null
				if (data[i][j] != null) {
					list1.add((String) data[i][j]);
				}
			}
			// once all one array index data is entered in arrayList , then
			// putting this object in parent arrayList
			if (list1.size() > 0) {
				list.add(list1);
			}
		}
		// convert array List Data into 2D Array
		Object[][] arr2d = new Object[list.size()][colSize];
		// run loop on array list data
		for (int i = 0; i < list.size(); i++) {
			// every array list index has arryList inside
			ArrayList<String> t = list.get(i);
			// run loop on inner array List
			for (int j = 0; j < t.size(); j++) {
				arr2d[i][j] = t.get(j);
			}
		}
		System.out.println(list);
		System.out.println(arr2d);
		return arr2d;
	}
	
	

}
