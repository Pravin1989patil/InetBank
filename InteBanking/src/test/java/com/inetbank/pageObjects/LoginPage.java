package com.inetbank.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(name="uid")
	WebElement txtUserName;
	
	@FindBy(name="password")
	WebElement txtUserPassword;
	
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	@FindBy(linkText = "Log out")
	WebElement linkLogout;
	
	public void setUserName(String userName)
	{
		txtUserName.sendKeys(userName);
	}
	
	public void setuserPassword(String password)
	{
		txtUserPassword.sendKeys(password);
	}
	public void clickLoginButton()
	{
		btnLogin.click();
	}
	public void clickLogoutLink() {
		linkLogout.click();
	}
	
}

