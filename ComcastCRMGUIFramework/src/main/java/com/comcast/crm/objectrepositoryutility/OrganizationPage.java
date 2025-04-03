package com.comcast.crm.objectrepositoryutility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage 
{
    WebDriver driver;
    
    public OrganizationPage(WebDriver driver)
    {
    	PageFactory.initElements(driver,this);
    	
    }
    
    @FindBy(xpath="//img[@alt='Create Organization...']")
    private WebElement orgButton;

	public WebElement getOrgButton()
    {
		return orgButton;
	}
	
		
	@FindBy(name="search_text")
	private WebElement searchEdt;

	public WebElement getSearchEdt() 
	{
		return searchEdt;
	}

	@FindBy(name="search_field")
    private WebElement searcdDD;

	public WebElement getSearcdDD() 
	{
		return searcdDD;
	}
	
	@FindBy(name="submit")
	private WebElement searchBtn;

	public WebElement getSearchBtn() 
	{
		return searchBtn;
	}
	
	
	
    
	
}
