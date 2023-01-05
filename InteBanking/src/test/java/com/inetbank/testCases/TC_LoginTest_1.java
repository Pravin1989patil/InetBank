package com.inetbank.testCases;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import com.inetbank.base.BaseClass;
import com.inetbank.pageObjects.LoginPage;
import com.inetbank.utilities.XlUtils;
import org.testng.annotations.Test;
public class TC_LoginTest_1 extends BaseClass{

	LoginPage lp;
	
	@Test(dataProvider = "LoginData")
	public void loginTest(String username, String password) throws IOException
	{
		lp= new LoginPage(driver);
		lp.setUserName(username);
		lp.setuserPassword(password);
		lp.clickLoginButton();
		boolean result=isAlertPresent();
		if(result)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(true);
			lp.clickLogoutLink();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
	}
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException{
		
		int rowcount= XlUtils.getRowCount("LoginTestData", "LoginDetails");
		int colcount= XlUtils.getCellCount("LoginTestData", "LoginDetails", 1);
		String logindata[][]= new String[rowcount][colcount];
		for(int i=1; i<=rowcount; i++)
		{
			for(int j=0; j<colcount;j++)
			{
				logindata[i-1][j]=XlUtils.getCellData("LoginTestData", "LoginDetails", i, j);
			}
		}
		
		return logindata;
		
	}
	
	
	
}
