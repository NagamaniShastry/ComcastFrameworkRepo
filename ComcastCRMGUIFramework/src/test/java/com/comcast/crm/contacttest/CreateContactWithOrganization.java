package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateContactWithOrganization 
{

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		FileInputStream fis = new FileInputStream("./configAppData/ComonDataPropertyFile.property");

		// Step2: using properties class load all the keys
		Properties p = new Properties();
		p.load(fis);

		// Step3: get the value based on the key
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");


	//Generate unique organization Name using Java Random Class
		
		Random rand =  new  Random();
	    int  randOrg = 	rand.nextInt(1000);
	        
		
		//Read TestScript Data from Excel file
		
	    FileInputStream fisExcel = new FileInputStream("./testdata/testScriptdata.xlsx");
		
	    Workbook wb =   WorkbookFactory.create(fisExcel);
	
		String orgName= wb.getSheet("Contact").getRow(7).getCell(2).getStringCellValue();
		orgName  = orgName+randOrg;
		
		String contactLname = wb.getSheet("Contact").getRow(7).getCell(3).getStringCellValue();
		
		
		wb.close();
		
		
						 
		WebDriver driver = null;
		
		if(BROWSER.equals("chrome"))
		{
		    driver= new ChromeDriver();
		}
		else
			if(BROWSER.equals("firefox"))
			{
				driver= new ChromeDriver();
			}
			else
			if(BROWSER.equals("edge"))
			{
					driver= new EdgeDriver();
			}
			else
			{
					driver= new ChromeDriver();
			}
		
		
		  // Step1: login into app
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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
	   
		  driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		  
		  //Verify header msg expected result
	   	 String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 
		 if(headerInfo.contains(orgName))
		 {
		   System.out.println(orgName +" Header is verified==PASS");
		 }
		  
		 else
		 {
			 System.out.println(orgName +" Header is verified==FAIL");
		 }
		  
		  
		 //Step5: navigate to contact module		  
		 
		  driver.findElement(By.linkText("Contacts")).click();	
		  
		  //Step6: Click on "create Organization" Button
		  
		  driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		  
		  //step7: enter Last name
		  driver.findElement(By.name("lastname")).sendKeys(contactLname);	
		  
		  Thread.sleep(2500);
				  
		  driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		  
		  
		  //Switch to child Window using iterator()
		 /*
		   Set<String> window = driver.getWindowHandles();
		   Iterator<String> it = window.iterator();
		  
		     while(it.hasNext()) 
		     {
		    	 String windowId = it.next();
		    	 driver.switchTo().window(windowId);
		    	 String actUrl =  driver.getCurrentUrl();
				   
				   if(actUrl.contains("module=Accounts"))
				   {
				      break;
				   }
		     }
		  */
		  
		  //switch to child window
		   Set<String> allWindow = driver.getWindowHandles();
		   
		   for(String win:allWindow)
		   {
			   driver.switchTo().window(win);
			   String actUrl =  driver.getCurrentUrl();
			   
			   if(actUrl.contains("module=Accounts"))
			   {
			      break;
			   }
			   
		   }
		  
		   
		  
		  driver.findElement(By.id("search_txt")).sendKeys(orgName);
		  driver.findElement(By.name("search")).click();
		  driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		  
		  
		  //Come back to parent window
		  
		  Set<String> allWindow1 = driver.getWindowHandles();
		   
		   for(String win:allWindow1)
		   {
			   driver.switchTo().window(win);
			   String actUrl =  driver.getCurrentUrl();
			   
			   if(actUrl.contains("Contacts&action"))
			   {
			      break;
			   }
			   
		   }
			  
		  
		  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		  
		  //Validation of ContactLname
		  
		  headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			 
			 if(headerInfo.contains(contactLname))
			 {
			   System.out.println(contactLname +" Header is verified ==PASS");
			 }
			  
			 else
			 {
				 System.out.println(contactLname +" Header is verified==FAIL");
			 }
			  
			  
			 //Verify Org Name info expected result
			  
			 
			 String actOrgName =  driver.findElement(By.id("mouseArea_Organization Name")).getText();
			 
			  if(actOrgName.trim().equals(orgName))
			  {
				  System.out.println(orgName +" information is created ==PASS");
			  }
			  else
			   {
					 System.out.println(orgName +" information is created==FAIL");
			   }
			  		  		  			 
		 	 driver.quit();


	}
}
