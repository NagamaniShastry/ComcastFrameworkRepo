package com.comcast.crm.generic.webdriverutlility;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility 
{
    public void waitForPageToLoad(WebDriver driver)
    {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	
    }
    public WebDriver getWebDriver(WebDriver driver,String browser)
    {    
    	
    	if(browser.equals("chrome"))
		{
		    driver= new ChromeDriver();
		}
		else
			if(browser.equals("firefox"))
			{
				driver= new ChromeDriver();
			}
			else
			if(browser.equals("edge"))
			{
					driver= new EdgeDriver();
			}
			else
			{
					driver= new ChromeDriver();
			}
		
    	return driver;
    	
    }
    
    public void waitForElementPresent(WebDriver driver,WebElement element)
    {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.visibilityOf(element));    	
    	
    }
    
    public void switchToTabOnURL(WebDriver driver,String partialURL)
    {
    	  Set<String> allWinow = driver.getWindowHandles();
    	  
          for(String win:allWinow)
    	  {
    		driver.switchTo().window(win);    		
    		String acturl= driver.getCurrentUrl();
    		if(acturl.contains(partialURL))
    		{
    			break;
    		}    		
        	  
    	  }    	  
    }
    
    
    public void switchToTabOnTitle(WebDriver driver,String partialTitle)
    {
    	  Set<String> allWinow = driver.getWindowHandles();
    	  
          for(String win:allWinow)
    	  {
    		driver.switchTo().window(win);  
    		String title = driver.getTitle();
    		
    		if(title.contains(partialTitle))
    		{
    			break;
    		}    		
        	  
    	  }    	  
    }
    
    public void switchToFrame(WebDriver driver,int index)
    {    	
    	driver.switchTo().frame(index);    	
    }
    
    public void switchToFrame(WebDriver driver,String nameId)
    {    	
    	
    	driver.switchTo().frame(nameId); 
    	
    }
    
    public void switchToFrame(WebDriver driver,WebElement element)
    {    	
    	driver.switchTo().frame(element);    	    	
    }
    
    public void switchToAlertandAccept(WebDriver driver)
    {
    	driver.switchTo().alert().accept();
    }
    
    public void switchToAlertandCancel(WebDriver driver)
    {
    	driver.switchTo().alert().dismiss();
    }
    
    public void select(WebElement element,String text)
    {
    	Select sel=  new Select(element);
    	sel.selectByVisibleText(text);
    }
    
    public void select(WebElement element,int index)
    {
    	Select sel=  new Select(element);
    	sel.selectByIndex(index);
    }
    
    public void selectbyValue(WebElement element,String value)
    {
    	Select sel=  new Select(element);
    	sel.selectByValue(value);
    }
    
    public void mousemoveOnElement(WebDriver driver,WebElement element)
    {
       Actions action = new Actions(driver);
       action.moveToElement(element).perform();
       
    }
    
    public void doubleClick(WebDriver driver,WebElement element)
    {
    	   Actions action = new Actions(driver);
    	   action.doubleClick(element).perform();
    	   
    }
    
    
    
		
}
