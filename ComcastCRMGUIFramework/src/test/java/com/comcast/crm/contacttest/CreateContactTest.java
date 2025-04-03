package com.comcast.crm.contacttest;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutlility.JavaUtility;
import com.comcast.crm.generic.webdriverutlility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

public class CreateContactTest extends BaseClass
{

	@Test(groups ="smokeTest")
	public void createContactTest() throws EncryptedDocumentException, IOException
	//public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException 
	{
	    		
		//Read TestScript Data from Excel file and Generate Random Number
	     String contactName = eutil.getDataFromExcel("Contact", 1,2)+jutil.getRandomNumber();    
	
	     HomePage hp = new HomePage(driver);
	     hp.getContactLink().click();	     
	 	 
	      ContactPage cp = new ContactPage(driver);
	      cp.getContactButton().click();			  
		  
	      CreateNewContactPage cnp = new CreateNewContactPage(driver);
	      cnp.createContact(contactName);
		  
	  	// Verify header msg expected result
	      
	      ContactInfoPage cip = new  ContactInfoPage(driver);
	      String headerInfo =  cip.getHeadermsg().getText();
		
		   //String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			 
	      boolean status =  headerInfo.contains(contactName);
	      Assert.assertEquals(status, true);
	    //  Assert.assertTrue(status);
	      
	       
			 
			 //String actLastName =  driver.findElement(By.id("dtlview_Last Name")).getText();
			 
			 String actLastName = cip.getDvLastname().getText();
			 SoftAssert soft = new SoftAssert();
			 soft.assertEquals(actLastName,contactName);
			 soft.assertAll();
					
		
	}

	
	/* @Test (groups = "regressionTest")
	 public void createContactWithsupportDateTest()
	 {
		 
	 }
	 
	 @Test(groups = "regressionTest")
	 public void createContactWithOrgTest()
	 {
		 
	 }*/
}
