package Practice.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformation  extends BaseClass
{
	
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException 
	{
		
								
		WebDriver driver =  new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		driver.get("https://www.flipkart.com/");
		
		 
		String currentWindow = driver.getWindowHandle();
		
		 System.out.println(currentWindow);
		
		 driver.findElement(By.name("q")).sendKeys("whirlpool refrigerator",Keys.ENTER);
	     driver.findElement(By.xpath("//div[.='Whirlpool 184 L Direct Cool Single Door 5 Star Refrigerator with Base Drawer']")).click();
	    
	     String refPrice =  driver.findElement(By.xpath("(//div[.='₹16,790'])[1]")).getText();
	     System.out.println(refPrice);
	    // driver.close();
	     
	     Actions act = new Actions(driver);
	     act.moveToElement(driver.findElement(By.name("q"))).click().perform();
	     driver.findElement(By.name("q")).clear();
	     driver.findElement(By.name("q")).sendKeys("samsung 5g mobiles",Keys.ENTER);
	     
	    	 	     
	     FileInputStream fis=  new FileInputStream("./testdata/testScriptdata.xlsx");
		 Workbook wb  =   WorkbookFactory.create(fis);	
		 wb.getSheet("flipCart").getRow(1).getCell(2).setCellValue(refPrice);
		   
	     FileOutputStream fos =  new FileOutputStream("./testdata/testScriptdata.xlsx");
	     wb.write(fos);  	     
	     wb.close();	
	       
	       
	        
	            
		 //  driver.quit();


	    
	      
	  
	    
	     
	    
	     
	     
	    /* pro.sendKeys("Flask",Keys.ENTER);
	     String flaskPrice =  driver.findElement(By.xpath("//div[.='₹716']")).getText();
	 	
	      
	    FileInputStream fis=  new FileInputStream("./testdata/testScriptdata.xlsx");
		Workbook wb  =   WorkbookFactory.create(fis);	
	    wb.getSheet("flipCart").getRow(1).getCell(2).setCellValue(refPrice);
	    wb.getSheet("flipCart").getRow(2).getCell(2).setCellValue(phPrice);
	    wb.getSheet("flipCart").getRow(3).getCell(2).setCellValue(flaskPrice);
		    
        FileOutputStream fos =  new FileOutputStream("./testdata/testScriptdata.xlsx");
        wb.write(fos);  
          
        wb.close();
	   
	    
	   	
	   driver.quit();

		  */
	
          
		
		
	}

}
