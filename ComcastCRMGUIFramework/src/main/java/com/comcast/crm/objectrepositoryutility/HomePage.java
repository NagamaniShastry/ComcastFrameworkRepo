package com.comcast.crm.objectrepositoryutility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutlility.WebDriverUtility;

public class HomePage 
{
	WebDriver driver;

	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunityLink;
	
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	
	@FindBy(partialLinkText="Campaigns")
	private WebElement campaignslnk;
	
	
	@FindBy(linkText="Documents")
	private WebElement documentlink;
	
	
	public WebElement getDocumentlink() {
		return documentlink;
	}

	@FindBy(linkText="More")
	private WebElement moreDropdown;
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutlnk;

	

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSignOutlnk() {
		return signOutlnk;
	}

	public WebElement getOrgLink() 
	{
		return orgLink;
	}

	public WebElement getContactLink() 
	{
		return contactLink;
	}

	public WebElement getOpportunityLink() 
	{
		return opportunityLink;
	}

	public WebElement getProductLink() 
	{
		return productLink;
	}
	
	
	public WebElement getCampaignslnk() 
	{
		return campaignslnk;
	}

	public WebElement getMoreDropdown() 
	{
		return moreDropdown;
	}
	
/*	  WebElement logoutIcon =  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	  act.moveToElement(logoutIcon).perform();
	  WebElement signoutbtn = driver.findElement(By.linkText("Sign Out"));
	  signoutbtn.click();
	  driver.quit();
*/
		
	
	public void navigateCampaignPage()
	{
		Actions act = new Actions(driver);
		act.moveToElement(moreDropdown).perform();
		campaignslnk.click();
	}

	
	public void logout()
	{ 
		WebDriverUtility wutil = new WebDriverUtility();
		wutil.mousemoveOnElement(driver, adminImg);
		signOutlnk.click();
 
	}
	
	
	
}
