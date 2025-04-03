package com.comcast.crm.objectrepositoryutility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutlility.WebDriverUtility;

public class LoginPage extends WebDriverUtility
{
	WebDriver driver;
	
	public LoginPage()
	{
		
	}
	
	public LoginPage(WebDriver driver)
	{ 
		this.driver  = driver; // we can initialize the global variable with current driver instance
		
		PageFactory.initElements(driver, this); //this means current class object
	}
	
   
	//Rule1 create a seperate java class
	//Rule2 object creation 
	
	@FindBy(name="user_name")
	private WebElement usernameedit;
	
	  
	@FindBy(name="user_password")
	private WebElement passwordedit;
	
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	
	//Rule3 Object Initialization should be in Test script not in POM class
	//Rule4 object encapsulation

	public WebElement getUsernameedit() 
	{
		return usernameedit;
	}


	public WebElement getPasswordedit() 
	{
		return passwordedit;
	}


	public WebElement getLoginBtn() 
	{
		return loginBtn;
	}
	
	//Rule-5: Provide action
	
	
	/**
	 * login to application based on username,password,url arguments
	 * @param url
	 * @param username
	 * @param password
	 */
	
	public void loginToapp(String url,String username,String password)
	{
		
		waitForPageToLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		usernameedit.sendKeys(username);
		passwordedit.sendKeys(password);
		loginBtn.click();
	}
	
}
