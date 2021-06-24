package com.crm.comcast.GenericUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseClass {
	public DatabaseUtility dLib=new DatabaseUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public ExcelFileUtility exLib=new ExcelFileUtility();
	public XmlFileUtility xLib=new XmlFileUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriver driver;
	
	@BeforeSuite(groups={"SmokeTest","regressionTest"})
	public void connectToDB() throws Throwable
	{
		dLib.connectionToDB();
	}
	//@Parameters("browser")
	@BeforeClass(groups={"SmokeTest","regressionTest"})
	public void launchBrowser() throws Throwable
	{
		String BROWSER=xLib.readDataFromXMLFile("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new InternetExplorerDriver();
		}
	}
	
	@BeforeMethod(groups={"SmokeTest","regressionTest"})
	public void loginToApplication() throws Throwable
	{
		String USERNAME = xLib.readDataFromXMLFile("username");
		String PASSWORD = xLib.readDataFromXMLFile("password");
		String URL = xLib.readDataFromXMLFile("url");
		
		wLib.maximizeWindow(driver);
		driver.get(URL);
		wLib.waitForPageToUpload(driver);
		

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	    driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	    driver.findElement(By.id("submitButton")).click();
	}
	
	@AfterMethod(groups={"SmokeTest","regressionTest"})
	public void logoutFromApplication()
	{
		WebElement logoutImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        wLib.mouseOver(driver, logoutImg);
        wLib.waitForPageToUpload(driver);
        wLib.waitForElementToBeVisible(driver, logoutImg);
        driver.findElement(By.linkText("Sign Out")).click();
		
	}
	@AfterClass(groups={"SmokeTest","regressionTest"})
	public void closeBrowser()
	{
		driver.close();
	}
	@AfterSuite(groups={"SmokeTest","regressionTest"})
	public void closeDB() throws Throwable
	{
		dLib.closeDB();
	}
	

}
