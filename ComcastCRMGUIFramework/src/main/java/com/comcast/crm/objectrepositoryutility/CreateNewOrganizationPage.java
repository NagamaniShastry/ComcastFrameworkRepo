package com.comcast.crm.objectrepositoryutility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.webdriverutlility.WebDriverUtility;

public class CreateNewOrganizationPage 
{
   WebDriver driver;

   public CreateNewOrganizationPage(WebDriver driver)
   {
	   
	   PageFactory.initElements(driver,this);
	   
	     
   }
   
	@FindBy(name="accountname")
	private WebElement orgNameEdit;
	
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	
	@FindBy(name="accounttype")
	private WebElement industryTypeDropDown;

	public WebElement getIndustryTypeDropDown() {
		return industryTypeDropDown;
	}


	public WebElement getIndustryDropDown() 
	{
		return industryDropDown;
	}


	public WebElement getOrgName() 
	{
		return orgNameEdit;
	}


	public WebElement getSaveBtn() 
	{
		return saveBtn;
	}
	
	
	public void createOrg(String orgname)
	{
		orgNameEdit.sendKeys(orgname);
		saveBtn.click();
	}
	
	public void createOrg(String orgname,String industry,String industryType)
	{
		orgNameEdit.sendKeys(orgname);
		WebDriverUtility wutil = new WebDriverUtility();
		wutil.select(industryDropDown, industry);
	    wutil.select(industryTypeDropDown,industryType);
		saveBtn.click();
	}
	
	
}
