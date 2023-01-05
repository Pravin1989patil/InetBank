package com.inetbank.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {
	WebDriver driver;
	public NewCustomerPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy (linkText = "New Customer")
	WebElement linkNewCustomer;
	
	@FindBy(name = "name")
	WebElement txtCustomerName;
	
	@FindBy(name ="rad1")
	WebElement radioGender;
	
	@FindBy(name = "dob")
	WebElement txtdob;
	
	@FindBy(name = "addr")
	WebElement txtAddress;
	
	@FindBy(name = "city")
	WebElement txtCity;
	
	@FindBy(name = "state")
	WebElement txtState;
	
	@FindBy(name = "pinno")
	WebElement txtPinno;
	
	@FindBy(name = "telephoneno")
	WebElement txtTelephoneno;
	
	@FindBy(name = "emailid")
	WebElement txtEmailid;
	
	@FindBy(name = "sub")
	WebElement txtSub;
	
	public void clickNewCustomerLink() {
		linkNewCustomer.click();
	}
	
	public void setCustomerName()
	{
		txtCustomerName.sendKeys("Pravin");
	}
	public void setGender() {
		radioGender.click();
	}
	public void setDOB() {
		txtdob.sendKeys("17-09-1989");
	}
	public void setAddress()
	{
		txtAddress.sendKeys("Samarth Krupa Nivas");
	}
	
	public void setCity()
	{
		txtCity.sendKeys("Pune");
	}
	public void setState()
	{
		txtState.sendKeys("Maharashtra");
	}
	
	public void setPinNumber()
	{
		txtPinno.sendKeys("416006");
	}
	public void setTelephoneNumber()
	{
		txtTelephoneno.sendKeys("9028730571");
	}
	public void setEmail()
	{
		txtEmailid.sendKeys("testave123@gmail.com");
	}
	public void clickSubmitButton() {
		txtSub.click();
	}
	
}
