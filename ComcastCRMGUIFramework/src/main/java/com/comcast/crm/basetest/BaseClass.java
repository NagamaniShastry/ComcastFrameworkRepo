package com.comcast.crm.basetest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutlility.JavaUtility;
import com.comcast.crm.generic.webdriverutlility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutlility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass 

{
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	public DataBaseUtility dblib =  new DataBaseUtility();
	public FileUtility flib = new FileUtility();	
	public ExcelUtility eutil =  new ExcelUtility();
	public JavaUtility jutil= new JavaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
		
		
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBS() throws SQLException 
	{
		System.out.println("===Connect to DB, Report config===");
		dblib.getDBConnection();	
		
			
	}

	//@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void configBC(/*String browser*/) throws IOException 
	{
		System.out.println("===Launch Browser===");
		//String BROWSER = browser;
		String BROWSER  = flib.getDatafromPropertyFile("browser");
		
		if(BROWSER.equals("chrome"))
		{
		    driver= new ChromeDriver();
		}
		else
			if(BROWSER.equals("firefox"))
			{
				driver= new FirefoxDriver();
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
				
		sdriver =  driver;
		UtilityClassObject.setDriver(driver); 
	}
	
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void configBM() throws IOException 
	{
		System.out.println("===login==");
		String URL =  flib.getDatafromPropertyFile("url");
		String USERNAME =  flib.getDatafromPropertyFile("username");
		String PASSWORD =  flib.getDatafromPropertyFile("password");		
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp(URL, USERNAME, PASSWORD);
	}
	
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void configAM() 
	{
		System.out.println("====Logout===");
	    HomePage hp = new HomePage(driver);
	    hp.logout();
		
	}
	
	
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void configAC() 
	{
		System.out.println("====Close Browser===");
		driver.quit();
		
	}
	
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void configAS() throws SQLException 
	{
		System.out.println("===Close DB, Report BackUP===");
		dblib.getCloseDBConnection();		
		
		
	}
}
