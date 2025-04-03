package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage 
{

	 WebDriver driver =  null;	 
	 
	 public ContactInfoPage(WebDriver driver)
	 {
		 this.driver = driver;
		 PageFactory.initElements(driver,this);
		 
	 }
	 
	 @FindBy(xpath="//span[@class='dvHeaderText']")
	 private WebElement headermsg;
	 
	 public WebElement getDvLastname() {
		return dvLastname;
	}

	@FindBy(id="dtlview_Last Name")
	 private WebElement dvLastname;

	public WebElement getHeadermsg() {
		return headermsg;
	}
	 
	 
	 
	
}
