package com.cnqaos.pages.users;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cnqaos.testbase.TestBase;


public class UserPage extends TestBase
{
	
	Select select;
	public static WebDriverWait wait = new WebDriverWait(driver, 10);
	
	
	public UserPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	private Boolean sebrogateedcheck;
	private Boolean validatedcheck;
	private Boolean activecheck;
	
	@FindBy(xpath ="//ul[@class='dropdown-menu']/li[6]/a")
	WebElement userdropdowntab;
	
	@FindBy(xpath= "//ul[@class='dropdown-menu']/li[6]/ul/li[1]/a")
	WebElement adduserlink;
	
	@FindBy(xpath= "//ul[@class='dropdown-menu']/li[6]/ul/li[3]/a")
	WebElement viewuserlink;
	
	@FindBy(xpath ="//button[@class='common-btn ng-binding'][@data-ng-click='showForm()']")
	WebElement addnewuserbutton;
	
	@FindBy(xpath= "//span[@id='select2-center-container']")
	WebElement center;
	
	@FindBy(xpath= "//input[@class='select2-search__field']")
	WebElement dropdownsearchfield;
	
	
	@FindBy(xpath= "//span[@id='select2-civilStatus-container']")
	WebElement civilstatus;
	
	@FindBy(xpath= "//select[@id='sex']")
	WebElement sex;
	
	@FindBy(xpath= "//input[@id='name']")
	
	WebElement name;
	
	@FindBy(xpath= "//textarea[@id='address']")
	WebElement address;
	
	@FindBy(xpath= "//select[@id='country']")
	WebElement country;
	
	@FindBy(xpath= "//input[@id='city']")
	WebElement city;
	
	@FindBy(xpath= "//input[@id='pin']")
	WebElement postalcode;
	
	@FindBy(xpath= "//input[@id='phoneNumber1']")
	WebElement phonenumber1;
	
	
	@FindBy(xpath= "//input[@id='email']")
	WebElement emailaddress;
	
	
	@FindBy(xpath= "//div[@id='midd-container']/div/div[3]/div/form/div[2]/div[5]/div/div[1]/span/button")
	WebElement role;
	
	@FindBy(xpath ="//div[@id='midd-container']/div/div[3]/div/form/div[2]/div[5]/div/div[1]/span/div/form/div[1]/div[2]/input")
	WebElement rolesearchfield;
	
	
	@FindBy(xpath="//div[@id='midd-container']/div/div[3]/div/form/div[2]/div[5]/div/div[1]/span/div/form/div[2]/div/div")
	WebElement rolesearchresultselectfirst;
	
	
	@FindBy(xpath="//div[@id='midd-container']/div/div[3]/div/form/div[2]/div[5]/div/label")
	WebElement outsideclickafterselectrole;
	
	@FindBy(xpath= "//input[@id='isValidated']")
	WebElement validate;
	
	@FindBy(xpath= "//input[@id='active']")
	WebElement active;
	
//for employee role	
	
	@FindBy(xpath= "//select[@id='quality']")
	WebElement quality;
	
	@FindBy(xpath= "//select[@id='speciality']")
	WebElement speciality;
	
	@FindBy(xpath= "//select[@id='companyType']")
	WebElement companytype;
	
	@FindBy(xpath= "//input[@id='companyNumber']")
	WebElement companynumber;
	
	@FindBy(xpath= "//select[@id='contractType']")
	WebElement contracttype;
	
	@FindBy(xpath= "//input[@id='sabrogated']")
	WebElement sebrogated;
	
	@FindBy(xpath="//button[@class='btn btn-default common-btn ng-binding'][contains(text(),'Update')]")
	WebElement buttonupdate;
	
	@FindBy(xpath="//input[@class='btn btn-default common-btn'][@value='Cancel']")
	WebElement buttoncancel;
	
//for teacher	
	
	@FindBy(xpath= "//div[@id='midd-container']/div/div[3]/div/form/div[2]/div[12]/div/div[1]/span/button")
	WebElement activities;
	
	@FindBy(xpath="//div[@id='midd-container']/div/div[3]/div/form/div[2]/div[12]/div/div[1]/span/div/form/div[1]/div[2]/input")
	WebElement activitysearchbox;
	
	@FindBy(xpath="//div[@id='midd-container']/div/div[3]/div/form/div[2]/div[12]/div/div[1]/span/div/form/div[2]/div/div/label/span")
	WebElement activitysearchresult;
	
	@FindBy(xpath="//div[@id='midd-container']/div/div[3]/div/form/div[2]/div[12]/div/label")
	WebElement outsideclickafterselectactivites;
	
	
	@FindBy(xpath="//div[@id='midd-container']/div/div[3]/div/form/div[4]/button[1]")
	WebElement createbutton;
	
	@FindBy(xpath="//div[@id='midd-container']/div/div[3]/div/form/div[4]/input")
	WebElement cancelbutton;
	
	@FindBy(xpath="//table[@class='table table-striped']/tbody/tr")
	List<WebElement> listofrowsinable;
	
	
	
	
	public void addUserButton() 
	{
		addnewuserbutton.click();
	}
	
	public void AddUserLink() throws InterruptedException 
	{
		Actions builder = new Actions(driver);
		builder.moveToElement(userdropdowntab).perform();
		builder.moveToElement(adduserlink).click().build().perform();
	}
	
	
	public void selectCenter(String centername) throws InterruptedException 
	{
		Thread.sleep(1000);
		
		center.click();
		
		dropdownsearchfield.sendKeys(centername);
		
		
		WebElement centernameclick = driver.findElement(By.xpath("//span[@class='select2-container select2-container--default select2-container--open']/span/span[2]/ul/li[1]"));
		
		centernameclick.click();
		
	}
	
	
	public void selectCivilStatus(String civilstatsname) 
	{
		civilstatus.click();
		
		dropdownsearchfield.sendKeys(civilstatsname);
		
		driver.findElement(By.xpath("//span[@class='select2-container select2-container--default select2-container--open']/span/span[2]/ul/li[1]")).click();
	}
	
	
	public void selectSex(String sextext) 
	{
		
		
		select = new Select(sex);
		select.selectByVisibleText(sextext);
		
		
		
	}
	
	public void enterName(String nametext) 
	{
		
		wait.until(ExpectedConditions.elementToBeClickable(name)).clear();
		name.sendKeys(nametext);
	
	}
	
	public void enterAddress(String addresstext) 
	{
		address.sendKeys(addresstext);
	}
	
	public void selectCountry(String countryname) 
	{
		
		
		select =  new Select(country);
		
		select.selectByVisibleText(countryname);
	}
	
	
	public void selectCity(String cityname) 
	{
				
		city.sendKeys(cityname);
		
		WebElement citysearchresult = driver.findElement(By.xpath("//ul[@class='typeahead ng-isolate-scope'][@role='listbox']/li[1]/a"));
		
		//WebDriverWait wait =  new  WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(citysearchresult));
		
		citysearchresult.click();
		
	}
	
	public void enterPostalCode(String postalcodetxt) 
	{
		postalcode.sendKeys(postalcodetxt);
		
		
	}
	
	public void enterPhoneNumber1(String phonenumber) 
	{
		phonenumber1.sendKeys(phonenumber);
	}
	
	public void enterEmailAddress(String emailtext) 
	{
		emailaddress.sendKeys(emailtext);
	}

	public void selectRole(String rolename) 
	{
		role.click();
		
		rolesearchfield.sendKeys(rolename);
		
		rolesearchresultselectfirst.click();
		
		outsideclickafterselectrole.click();
		
			
	}
	
	public void selectQuality(String qualityname) 
	{
	
		select = new Select(quality);
		select.selectByVisibleText(qualityname);
		
	}
	
	
	public void selectSpeciality(String specialityname) 
	{
	
		select = new Select(speciality);
		select.selectByVisibleText(specialityname);
	}
	
	public void selectCompanyType(String compnaytypename) 
	{
	
		select = new Select(companytype);
		select.selectByVisibleText(compnaytypename);
	}
	
	
	public void enterCompanyNumber(String companynumbertext) 
	{
		
		companynumber.sendKeys(companynumbertext);
	}
	
	public void selectContractType(String contracttypetext) 
	{
		
		select = new Select(contracttype);
		select.selectByVisibleText(contracttypetext);
	}
	
	public void checkSebrogated(Boolean checksignal) 
	{
		
		sebrogateedcheck = sebrogated.isSelected();
		
		if(sebrogateedcheck==false && checksignal==true)
		{
			sebrogated.click();
			
		}else if (sebrogateedcheck==false && checksignal==false) 
		{
			System.out.println("sebrogated box not checked ");
			
		}else if (sebrogateedcheck==true && checksignal==true) 
		{
			System.out.println("sebrogated box already checked ");
			
		}else if (sebrogateedcheck==true && checksignal==false) 
		{
			sebrogated.click();
			
			System.out.println("sebrogated box unchecked successfully ");
			
		}else 
		{
			System.out.println("condition not match");
		}
		
		
		
	}
	
	public void checkValidated(Boolean checksignal) 
	{
		validatedcheck = validate.isSelected();
		
		if(validatedcheck==false && checksignal==true)
		{
			validate.click();
			
		}else if (validatedcheck==false && checksignal==false) 
		{
			System.out.println("validated box not checked ");
			
		}else if (validatedcheck==true && checksignal==true) 
		{
			System.out.println("validated box already checked ");
			
		}else if (validatedcheck==true && checksignal==false) 
		{
			validate.click();
			
			System.out.println("validated box unchecked successfully ");
			
		}else 
		{
			System.out.println("condition not match");
		}
		
	}
	
	
	public void checkActive(Boolean checksignal) 
	{
		activecheck = active.isSelected();
		
		if(activecheck==false && checksignal==true)
		{
			active.click();
			
		}else if (activecheck==false && checksignal==false) 
		{
			System.out.println("active box not checked ");
			
		}else if (activecheck==true && checksignal==true) 
		{
			System.out.println("active box already checked ");
			
		}else if (activecheck==true && checksignal==false) 
		{
			active.click();
			
			System.out.println("active box unchecked successfully ");
			
		}else 
		{
			System.out.println("condition not match");
		}
		
	}
	
	public void selectActivities(String activityname) 
	{
		activities.click();
		
		activitysearchbox.sendKeys(activityname);
		
		activitysearchresult.click();
		
		outsideclickafterselectactivites.click();
		
	}
	
	
    public void createRecord() 
    {
      	createbutton.click();
    }

    public void cancelRecord() 
    {
    cancelbutton.click();	
    }
    
    public void verifyUserAddedOrNot(String nameofuser) 
    {
    	int sizeofrows = listofrowsinable.size();
    	for(int i=1;i<=sizeofrows;i++)
    	{
    		String getnamefromrecord  = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+i+"]/td[3]")).getText();
    		
    		
    		if(getnamefromrecord.equals(nameofuser))
    		{
    			System.out.println("user present ");
    			break;
    		}else 
    		{
				System.out.println("user not present");
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
	
	
	
	

}