package Practice.test;

import org.testng.Assert;
import org.testng.annotations.Test;


public class InvoiceTest1 
{

	@Test(retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerImp.class)
	public void activateSIMTest()
	{
		System.out.println("activateSIMTest");	
		Assert.assertEquals("","LogIn");  //AssertErrorException
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");		
			
	}
}
