package com.inetbank.base;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.inetbank.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
 

public class BaseClass {

	public WebDriver  driver;
	public static Logger logger;
	public ReadConfig config;
	
	@BeforeClass
	public void initialSetup() throws IOException
	{
		logger=LogManager.getLogger(BaseClass.class);
		config= new ReadConfig();
	}
	
	@Parameters("browser")
	@BeforeMethod
	public void browserSetup(String browser)
	{
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if(browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			
		}
		driver.get(config.getBaseUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	public void takeScreenshot(WebDriver driver, String tname) throws IOException 
	{
		TakesScreenshot ts= ((TakesScreenshot)driver);
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
		System.out.println("In screenshot method "+ System.getProperty("user.dir")+"\\Screenshots\\"+tname+".png");
		File target= new File(System.getProperty("user.dir")+"\\Screenshots\\"+tname+".png");
		FileUtils.copyFile(srcFile, target);
	}
public boolean isAlertPresent() {
		
		try
		{
			driver.switchTo().alert();
			return true;
			
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
}
