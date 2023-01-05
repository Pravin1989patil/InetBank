package com.inetbank.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.inetbank.base.BaseClass;
import com.inetbank.pageObjects.LoginPage;
import com.inetbank.pageObjects.NewCustomerPage;

public class TC_NewCustomerTest extends BaseClass {

	
	NewCustomerPage cust;
	LoginPage lp;

	@Test
	public void addNewCustomerTest() {
		lp = new LoginPage(driver);
		lp.setUserName(config.getUserName());
		lp.setuserPassword(config.getPassword());
		lp.clickLoginButton();
		cust = new NewCustomerPage(driver);
		cust.clickNewCustomerLink();
		cust.setCustomerName();
		cust.setGender();
		cust.setDOB();
		cust.setAddress();
		cust.setCity();
		cust.setState();
		cust.setPinNumber();
		cust.setTelephoneNumber();
		cust.setEmail();
		cust.clickSubmitButton();
	}

}
