package com.comcast.crm.objectrepositoryutility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage 
{
	
	WebDriver driver = null;
	 
	public CreateNewContactPage(WebDriver driver)
	{
		this.driver =  driver;
		PageFactory.initElements(driver,this);		
	}
		
	@FindBy(name="lastname")
	private WebElement lastNameEdit;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;

	public WebElement getLastNameEdit() {
		return lastNameEdit;
	}

	public WebElement getSavebtn() 
	{
		return savebtn;
	}
	
	
	public void createContact(String lastname)
	{
		
		lastNameEdit.sendKeys(lastname);
		savebtn.click();
		
	}
	
	
	
	
	

}
