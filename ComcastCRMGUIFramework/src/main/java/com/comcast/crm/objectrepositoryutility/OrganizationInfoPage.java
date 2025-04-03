package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage 
{	
	WebDriver driver;
	
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headermsg;

	public WebElement getHeaderInfo() 
	{
		return headermsg;
	}
	
	
		
	// String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		

}
