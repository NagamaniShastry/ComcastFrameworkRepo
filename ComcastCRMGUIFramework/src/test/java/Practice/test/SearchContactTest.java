package Practice.test;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.LoginPage;

/**
  * test class for contact module
  * @author Admin
  */

public class SearchContactTest extends BaseClass{

	/**
	 * Scenario: login()==>navigateContact==>createcontact()==verify
	 */
    
	@Test
    public void searchContactTest()
    {
	  
		LoginPage lp = new LoginPage(driver);
		
    }
  
  
}
