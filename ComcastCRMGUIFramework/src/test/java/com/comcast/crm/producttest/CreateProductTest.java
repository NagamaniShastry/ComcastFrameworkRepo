package com.comcast.crm.producttest;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;

public class CreateProductTest 
{

	public static void main(String[] args) throws IOException 
	{
	
		FileUtility futil = new FileUtility();
		ExcelUtility eutil = new ExcelUtility();
		
		String BROWSER = futil.getDatafromPropertyFile("browser");
		String URL = futil.getDatafromPropertyFile("url");
		String USERNAME = futil.getDatafromPropertyFile("username");
		String PASSWORD = futil.getDatafromPropertyFile("password");
		
        Random pName = new  Random(); 
        int  prName = pName.nextInt(1000);
        
        String productName =  eutil.getDataFromExcel("Product", 1, 2)+prName;
        
        
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
		  
		  
		  driver.findElement(By.linkText("Products")).click();		  
		  driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		  
		  driver.findElement(By.name("productname")).sendKeys(productName);
		  
		  driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			
		  String headerInfo =driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		  
		  if(headerInfo.contains(productName))
		  {
			  System.out.println(productName +"is Created==PASS");
			  
		  }
		  else
		  {
			  System.out.println(productName +"is not Created==PASS");
				
		  }
		  	  
		  
		  String actOrgName =  driver.findElement(By.id("dtlview_Product Name")).getText();
			 
		  if(actOrgName.equals(productName))
		  {
			  System.out.println(productName +"is displayed ==PASS");
		  }
		  else
			  
		   {
				 System.out.println(productName +"is not Created==FAIL");
		   }
			
		  		  	  
		  
		  driver.quit();
        
        
        
	}

}
