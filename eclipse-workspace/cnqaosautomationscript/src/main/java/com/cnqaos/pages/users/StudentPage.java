package com.cnqaos.pages.users;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cnqaos.testbase.TestBase;



public class StudentPage extends TestBase 


{
	
	
	UserPage userPage = new UserPage();
	Select select;
	Boolean activecheck;
	JavascriptExecutor js = (JavascriptExecutor)driver;
	public StudentPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@class='dropdown-menu']/li[6]/ul/li[2]/a")
	WebElement addstudentlinkelement;
	
	@FindBy(xpath ="//ul[@class='dropdown-menu']/li[6]/a")
	public static WebElement userdropdowntab;
	
	@FindBy(xpath ="//div[@id='midd-container']/div/div[3]/button")
	WebElement addnewstudentbutton;
	
	@FindBy(xpath="//select[@id='civilStatus']")
	WebElement civilstatus;
	
	@FindBy(xpath="//form[@id='studentForm']/div[1]/div[4]/div/label")
	WebElement outsidecivilstatus;
	
	@FindBy(xpath="//input[@id='dob']")
	WebElement dateofbirth;
	
	@FindBy(xpath="//form[@id='studentForm']/div[2]/div[4]/div/label")
	WebElement dateofbirthoutsideclick;
	
	@FindBy(xpath="//input[@id='dept']")
	WebElement department;
	
	@FindBy(xpath="//input[@id='emergencyContactNumber']")
	WebElement emergencycontactnumber;
	
	@FindBy(xpath="//input[@id='socialSecurityNumber']")
	WebElement socialsecuritynumber;
	
	@FindBy(xpath="//input[@id='professionalBackground']")
	WebElement professionalbackground;
	
	@FindBy(xpath="//select[@id='educationalBackground']")
	WebElement educationbackground;
	
	@FindBy(xpath="//select[@id='educationalField']")
	WebElement educationfield;
	
	@FindBy(xpath="//select[@id='trainingType']")
	WebElement trainingtype;
	
	@FindBy(id="training")
	WebElement traininname;
	
	@FindBy(xpath="//input[@id='interested']")
	WebElement additionaltraininginterested;
	
	@FindBy(xpath="//select[@id='additraining']")
	WebElement aditionaltraining;
	
	@FindBy(xpath="//input[@id='isStudentsActive']")
	WebElement studentactive;
	
	@FindBy(xpath="//input[@id='placeOfBirth']")
	WebElement placeofbirth;
	
	@FindBy(xpath="//table[@class='table table-striped']/tbody/tr")
	List<WebElement> listofstudentrecord;
	
	
	// student page element 
	
	@FindBy(xpath="//button[@class='button multiSelectButton ng-binding']")
	WebElement selectcenter;
	
	@FindBy(xpath ="//div[@id='midd-container']/div/div[1]/span/div/form/div[1]/div[2]/input")
	WebElement centersearchfield;
	
	@FindBy(xpath="//*[@id='midd-container']/div/div[1]/span/button")
	WebElement dropdownboxcenter;
	
	@FindBy(xpath="//td[@align='center']/dir-pagination-controls/ul/li")
	List<WebElement> paginationcount;
	
	@FindBy(xpath="//table[@class='table table-striped']/tfoot/tr/td/dir-pagination-controls/ul/li[@class='ng-scope'][@ng-if='directionLinks']/a[@ng-click='setCurrent(pagination.current + 1)']")
	WebElement btnforwordpegination;
	
	@FindBy(xpath="//button[@id='editButton']")
	WebElement buttonupdate;
	
	@FindBy(xpath="//input[@id='cancel']")
	WebElement buttoncancel;
	
	@FindBy(xpath="//input[@id='userCode']")
	WebElement studentid;
	
	public void addStudentLink()
	{
		Actions builder = new Actions(driver);
		builder.moveToElement(userdropdowntab).perform();
		builder.moveToElement(addstudentlinkelement).click().build().perform();
	}
	
	public void addStudentButton() 
	{
		addnewstudentbutton.click();
	}
	
	public void selectCivilStatus(String civilstatusname) 
	{
		
		select = new Select(civilstatus);
		select.selectByVisibleText(civilstatusname);
		
	}
	
	public void enterPlaceofBirth(String textplaceofbirth) 
	{
		placeofbirth.sendKeys(textplaceofbirth);
	}
	
	public void enterDateofBirth(String dateofbirthnumber) 
	{
		dateofbirth.sendKeys(dateofbirthnumber);
		
		dateofbirthoutsideclick.click();
		
	}
	
	public void enterDepartmentName(String dprtname) 
	{
		department.sendKeys(dprtname);
	}
	
	public void enterEmerngcyContactNumber(String emergycontactnumber) 
	{
		emergencycontactnumber.sendKeys(emergycontactnumber);
	}
	
	public void enterSocialSecurityNumber(String socialsecurity) 
	{
		socialsecuritynumber.sendKeys(socialsecurity);
	}
	
	public void enterProfessionalBackground(String profeground) 
	{
		professionalbackground.sendKeys(profeground);
	}
	
	public void selectEqucationBackGrund(String txtequcationbackgorund) 
	{
		
			select = new Select(educationbackground);
		select.selectByVisibleText(txtequcationbackgorund);
		
		
	}
	
	public void selectEducationField(String dropdowneducationfield) 
	{
			
		select = new Select(educationfield);
		select.selectByVisibleText(dropdowneducationfield);
		
	}
	
	public void selectTrainingType(String trainingtypename) 
	{
		
		select = new Select(trainingtype);
		select.selectByVisibleText(trainingtypename);
		
	}
	
	public void selectTrainingName(String selecttrainingname) 
	{
		try {
			select = new Select(traininname);
			select.selectByVisibleText(selecttrainingname);
			
		} catch (Exception e) 
		{
			// TODO: handle exception
			System.out.println("training name not found");
		}
		
	}
	
	public void selectAdditionaltraining(String txtadditionaltraning) 
	{
		additionaltraininginterested.click();
		
		select =new Select(aditionaltraining);
		
		select.selectByVisibleText(txtadditionaltraning);
		
	}
	
	public void checkActive(Boolean checksignal) 
	{
		activecheck = studentactive.isSelected();
		
		if(activecheck==false && checksignal==true)
		{
			studentactive.click();
			
		}else if (activecheck==false && checksignal==false) 
		{
			System.out.println("active box not checked ");
			
		}else if (activecheck==true && checksignal==true) 
		{
			System.out.println("active box already checked ");
			
		}else if (activecheck==true && checksignal==false) 
		{
			studentactive.click();
			
			System.out.println("active box unchecked successfully ");
			
		}else 
		{
			System.out.println("condition not match");
		}
		
	}

	public void verifyStudentAddedOrNot(String expctedrecordname) 
	{
		int studentrecordcount = listofstudentrecord.size();
		for(int i=1;i<=studentrecordcount;i++)
		{
			String getrecordname = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+i+"]/td[3]")).getText();
			if (getrecordname.equals(expctedrecordname))
			{
				
				System.out.println("Student  present");
				break;
			} else 
			{
				System.out.println("Student  not present");
				
			}
		}
		
	}
	
	public void selectCenter(String centername) throws InterruptedException 
	{
		selectcenter.click();
		centersearchfield.sendKeys(centername);
		driver.findElement(By.xpath("//div[@class='checkBoxContainer']/div/div/label/span[contains(text(),'"+centername+"')]")).click();
		dropdownboxcenter.click();
		
	}
	
	public void SelectRecordAndClickOnEditBtn(String studentname,int editbuttonindex) throws InterruptedException 
	{
		int actualsizeofpegination = paginationcount.size();
		int count = 0;
	if (actualsizeofpegination!=0) 
	{
		int actualpage = actualsizeofpegination-4;
		
		for(int k =1;k<=actualpage;k++)
		{
			
		   for(int i=1;i<=10;i++)
		  {
			   
			Thread.sleep(500);
			WebElement readname = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+i+"]/td[3]"));
			String getname = readname.getText();
			
			    if(getname.equals(studentname)) 
			  {
				driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+i+"]/td["+editbuttonindex+"]/a")).click();
				count = 1;
				break;
			  }
		  }
		   if(count==1) {break;}
		     try 
		     {
		    	 btnforwordpegination.click();
		     } catch (Exception e) 
		            {
			            System.out.println("not record found");
		            }  
		     
		}
		
		
	}else 
	{
		for(int i=1;i<=10;i++)
		{
					
			WebElement readname = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+i+"]/td[3]"));
			String getname = readname.getText();
			
			if(getname.equals(studentname)) 
			{
				driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+i+"]/td["+editbuttonindex+"]/a")).click();
				break;
			}
			
			
		}
	}
	
	}
	
public void clickOnUpdateButton() 
{
	buttonupdate.click();
}

public void clickOnCancelButton() 
{

	buttoncancel.click();
}

public String checkStudentUpdateOrNot(String username) 
{
	String expectedreturnname ="";
	for(int i=1;i<=10;i++)
	{
		try 
		{
			
		
		WebElement readname = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+i+"]/td[3]"));
		String getname = readname.getText();
		
		   if(getname.equals(username)) 
		   {
			WebElement webelementname = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+i+"]/td[3]"));
			String actualgetname = webelementname.getText();
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