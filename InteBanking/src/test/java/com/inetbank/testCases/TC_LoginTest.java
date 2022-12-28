package com.inetbank.testCases;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.Test;
import com.inetbank.base.BaseClass;
import com.inetbank.pageObjects.LoginPage;

public class TC_LoginTest extends BaseClass{

	LoginPage lp;
	@Test
	public void LoginTest() throws IOException
	{
		 lp= new LoginPage(driver);
		 lp.setUserName(config.getUserName());
		 //logger.info("UserName is entered: "+ config.userName);
		 lp.setuserPassword(config.getPassword());
		// logger.info("Password is entered: "+ config.password);
		 lp.clickLoginButton();
		 logger.info("User clicked on login button");
		 String pageTitile=driver.getTitle();
		 if(pageTitile.equals("GTPL Bank Manager HomePage"))
		 {
			 assertTrue(true);
		 }
		 else
		 {	
			 takeScreenshot(driver, "LoginTest");
			 assertTrue(false);
		 }
	}
	
}
