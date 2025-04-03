package com.comcast.crm.orgtest;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutlility.JavaUtility;
import com.comcast.crm.generic.webdriverutlility.WebDriverUtility;

public class CreateOrganizationWithPhoneNumber 
{

	public static void main(String[] args) throws IOException 
	{
		FileUtility futil = new FileUtility();
	    ExcelUtility eutil =  new ExcelUtility();
	    JavaUtility jutil= new JavaUtility();
	    WebDriverUtility wUtil = new WebDriverUtility();
		
	
	    //get common data from  property File	
		String BROWSER = futil.getDatafromPropertyFile("browser");
		String URL = futil.getDatafromPropertyFile("url");
		String USERNAME = futil.getDatafromPropertyFile("username");
		String PASSWORD = futil.getDatafromPropertyFile("password");
		
		//Read TestScript Data from Excel file and Generate Random Number
	    String orgName = eutil.getDataFromExcel("org", 1,2)+jutil.getRandomNumber();    
		 
		//Exception in thread "main" java.lang.IllegalStateException:
		//Cannot get a STRING value from a NUMERIC cell exception from below Statement
			
		//String phoneNo  = wb.getSheet("org").getRow(7).getCell(3).getStringCellValue();
			
		//Convert int to String in Excel only by placing single quote before the number
				    
	    String phoneNo = eutil.getDataFromExcel("org", 7,3);


		WebDriver driver = null;
	    driver = wUtil.getWebDriver(driver, BROWSER);			
	    wUtil.waitForPageToLoad(driver);		
			
				  driver.get(URL);
				  driver.manage().window().maximize();
				  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				  driver.findElement(By.id("submitButton")).click();
				  
				  //Step2: Navigation to Organization Module
				  driver.findElement(By.linkText("Organizations")).click();
				  
				  
				  //Step3: Click on "create organization" Button
				  
				  driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				  
				  //Step3: Enter all the details and create new organization
				  
				  driver.findElement(By.name("accountname")).sendKeys(orgName);
				  
				  driver.findElement(By.id("phone")).sendKeys(phoneNo);
				  
				  driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
					
				  
				  String actph = driver.findElement(By.id("dtlview_Phone")).getText();
				  
				  
				  if(actph.equals(phoneNo))
				  {
					  System.out.println(phoneNo +" PhoneNumber is verified==PASS");
				  }
				  else
				    {
						 System.out.println(phoneNo +" PhoneNumber is not verified==FAIL");
				    }
				  
				 				    
				  driver.quit();
				  
				  
		

	}

}
