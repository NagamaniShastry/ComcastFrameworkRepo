package Practice.test;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetProductInfoTest 
{

	 @Test(dataProvider ="getData")
	 public void getProductInfoTest(String brandName,String productName)
	 {
		 
		 WebDriver driver =  new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		 driver.manage().window().maximize();
		 driver.get("http://amazon.in/");
		 
		 //Search product
		 
		 driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
		 
		 //capture product info
		// String x="//span[text()='Apple iPhone 15 (128 GB) - Pink']/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span/span[2]/span[2]";
		 
		// String x="//span[text()='Apple iPhone 13 (128GB) - Starlight']/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span/span[2]/span[2]";
		 
	     String x="//span[text()='"+productName+"']/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span/span[2]/span[2]";
         String price = driver.findElement(By.xpath(x)).getText();
         System.out.println(price);
         driver.quit();
 		 
	 }
	 
	    @DataProvider
		public Object[][] getData() throws EncryptedDocumentException, IOException
		{
	    	ExcelUtility eutil = new ExcelUtility();
			
			int rowcount = eutil.getRowCount("products");
		
			Object[][] objArr = new Object[rowcount][2];
				
		/*	objArr[0][0] = "iphone";
			objArr[0][1] = "Apple iPhone 13 (128GB) - Starlight";
			
			objArr[1][0] = "iphone";
			objArr[1][1] = "Apple iPhone 15 (128 GB) - Pink";
			
			objArr[2][0] = "iphone";
			objArr[2][1] = "Apple iPhone 15 (128 GB) - Blue";
		
*/			
			
			for(int i=0;i<rowcount;i++)
			{
				objArr[i][0] = eutil.getDataFromExcel("products", i+1, 0);
				objArr[i][1] = eutil.getDataFromExcel("products", i+1, 1);
				
			}
			
				
		    return objArr;
		}
	
}
