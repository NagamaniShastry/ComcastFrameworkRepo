package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

public class CreateContactWithSupportDateTest 
{

	public static void main(String[] args) throws IOException, InterruptedException 
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
	    String contactName = eutil.getDataFromExcel("Contact", 4,2)+jutil.getRandomNumber();
	    
		
	     WebDriver driver = null; 	    
	     driver = wUtil.getWebDriver(driver, BROWSER);
						 
	     wUtil.waitForPageToLoad(driver);
	
		  // Step1: login into app
		  driver.get(URL);
		  driver.manage().window().maximize();
		  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		  driver.findElement(By.id("submitButton")).click();
		  
		  driver.findElement(By.linkText("Contacts")).click();	
		  
		  driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		  
		  driver.findElement(By.name("lastname")).sendKeys(contactName);
		  
		  
		  driver.findElement(By.name("support_start_date")).clear();
		  
		  jutil.getCurrentDate(); 
		 
		// Get the current date
	       
	        String startDate =  jutil.getCurrentDate();  
		  
		  driver.findElement(By.name("support_start_date")).sendKeys(startDate);
		    
		 	  
		  driver.findElement(By.name("support_end_date")).clear();
		  
		  
		//  LocalDate edate = sttDate.plusMonths(1);
		  String endDate = jutil.getRequiredDate(25);
		  
		  driver.findElement(By.name("support_end_date")).sendKeys(endDate);			 
		  
		  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		  
		  //Thread.sleep(4000);
			
		  		
		 String actualSdate =   driver.findElement(By.id("dtlview_Support Start Date")).getText();
		 
		 if(actualSdate.contains(startDate))
		 {
			 System.out.println(startDate +" information is verified ==PASS");
		 }
		  
		 else
		    {
				 System.out.println(startDate +" information is not verified==FAIL");
		    }
		 
		 
		 
     String actualEdate =   driver.findElement(By.id("dtlview_Support End Date")).getText();
		 
		 if(actualEdate.contains(endDate))
		 {
			 System.out.println(endDate +" information is verified==PASS");
		 }
		  
		 else
		    {
				 System.out.println(endDate +" information is not verified==FAIL");
		    }
		 
		
		// driver.quit();
		  

	}

}
