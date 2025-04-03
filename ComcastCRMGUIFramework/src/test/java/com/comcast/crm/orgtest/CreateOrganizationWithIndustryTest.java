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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutlility.JavaUtility;
import com.comcast.crm.generic.webdriverutlility.WebDriverUtility;

public class CreateOrganizationWithIndustryTest 
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
		    String orgName = eutil.getDataFromExcel("org", 1,2)+jutil.getRandomNumber();    
		
		    String industry = eutil.getDataFromExcel("org", 4, 3);
			
		    String type  = eutil.getDataFromExcel("org", 4, 4);
			

			WebDriver driver = null;

		    driver = wUtil.getWebDriver(driver, BROWSER) ;
				
		    wUtil.waitForPageToLoad(driver);		
				
				
				  // Step1: login into app
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
				  
				  Thread.sleep(1500);
				  
				 WebElement industrtLB =  driver.findElement(By.name("industry"));
				 wUtil.select(industrtLB, industry);
				 			
				 
                WebElement typeLB =  driver.findElement(By.name("accounttype"));
                wUtil.select(typeLB, type);
	 			
			 		     
			   driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
				
			   //Verify the drop down industry  and type info
			   
			   String actIndustry =  driver.findElement(By.id("dtlview_Industry")).getText();
				 
				  if(actIndustry.equals(industry))
				  {
					  System.out.println(industry +" information is verified==PASS");
				  }
				  else
				    {
						 System.out.println(industry +" information is not verified==FAIL");
				    }
					  
				  
				  
				  String actType =  driver.findElement(By.id("dtlview_Type")).getText();
					 
				  if(actType.equals(type))
				  {
					  System.out.println(type +" information is verified==PASS");
				  }
				  else
				    {
						 System.out.println(type +" information is not verified==FAIL");
				    }
				  
				  
			   
			   //Logout
				  
			  driver.quit(); 
		       
	}

}
