import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import junit.framework.Assert;

//@Listeners(com.comcast.crm.listenerutility.ListenerImpClass.class)
public class InvoiceTest extends BaseClass {

	
	
	@Test
	public void createInvoiceTest()
	{
		System.out.println("Execute createInvoiceTest");
		String actTitle =  driver.getTitle();
		System.out.println(actTitle);
		Assert.assertEquals(actTitle,"LogIn");  //AssertErrorException
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");		
		
	}
	
	@Test
	public void createInvoicewithContactTest()
	{
		System.out.println("Execute createInvoicewithContactTest");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");		

	}
}
