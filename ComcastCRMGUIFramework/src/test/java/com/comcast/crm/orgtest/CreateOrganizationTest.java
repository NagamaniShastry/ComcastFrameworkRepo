package com.comcast.crm.orgtest;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutlility.JavaUtility;
import com.comcast.crm.generic.webdriverutlility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutlility.WebDriverUtility;
import com.comcast.crm.listenerutility.ListenerImpClass;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

@Listeners(com.comcast.crm.listenerutility.ListenerImpClass.class)
public class CreateOrganizationTest extends BaseClass {

	@Test(groups ="smokeTest")
	public void createOrganizationTest() throws EncryptedDocumentException, IOException {

		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
	//	ListenerImpClass.test.log(Status.INFO, "read data from Excel");
		
		// Read TestScript Data from Excel file and Generate Random Number
		//String orgName = eutil.getDataFromExcel("org", 1, 2) + jutil.getRandomNumber();
		
		String orgName = eutil.getDataFromExcel("org", 1, 3) + jutil.getRandomNumber();


		// PageFactory will load all the elements with current address and
		// it will return the object of POM class
		// LoginPage lp = new LoginPage(driver);

		// lp.loginToapp(USERNAME, PASSWORD);

		/*
		 * lp.getUsernameedit().sendKeys("admin"); //Also we can use getters
		 * lp.getPasswordedit().sendKeys("admin"); lp.getLoginBtn().click();
		 */

		// Step2: Navigation to Organization Module

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// Step3: Click on "create organization" Button

		OrganizationPage op = new OrganizationPage(driver);
		op.getOrgButton().click();

		// Step4: Enter all the details and create new organization

		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);

		/*
		 * nop.getOrgName().sendKeys(orgName); nop.getSaveBtn().click();
		 */
		cnop.createOrg(orgName);
		UtilityClassObject.getTest().log(Status.INFO,orgName +"Create a new Org");

		// Verify header msg expected result

		OrganizationInfoPage orgInfo = new OrganizationInfoPage(driver);
		String actOrgName = orgInfo.getHeaderInfo().getText();
				
		Assert.assertEquals(true,actOrgName.contains(orgName));

	/*	if (actOrgName.contains(orgName)) {

			System.out.println(orgName + "name is verified == PASS");
		}

		else {
			System.out.println(orgName + "name is not verified == FAIL");

		}*/

		// hp.getOrgLink().click();

		// Step5: logout

	}

	//@Test(groups="regressionTest")
	public void createOrganizationWithIndustryTest() throws EncryptedDocumentException, IOException
	{
		
		//Read TestScript Data from Excel file and Generate Random Number
	    String orgName = eutil.getDataFromExcel("org", 1,2)+jutil.getRandomNumber();    
	    String industry = eutil.getDataFromExcel("org", 4, 3);
	    String type  = eutil.getDataFromExcel("org", 4, 4);
	
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		
		
		OrganizationPage op = new OrganizationPage(driver);
		op.getOrgButton().click();
		
		
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
        cnop.createOrg(orgName, industry, type);
        
        

	}
	
	//@Test(groups="regressionTest")
	public void createOrgWithPhoneNumberTest() 
	{
		
	}
}
