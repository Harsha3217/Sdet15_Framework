package com.crm.comcast.Practice;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.JavaUtility;
import com.crm.comcast.GenericUtils.XmlFileUtility;

public class CreateOrganizationTest {
	@Test 
	public void createOrganization() throws Throwable{
		WebDriver driver;
		XmlFileUtility xLib=new XmlFileUtility();
		JavaUtility jLib=new JavaUtility();
		int random=jLib.getRandomNumber();
		
		String URL=xLib.readDataFromXMLFile("url");
		String UN=xLib.readDataFromXMLFile("username");
		String PWD=xLib.readDataFromXMLFile("password");
		String BROWSER=xLib.readDataFromXMLFile("browser");
		//Launch Browser
		if(BROWSER.equals("chrome"))
			{
			  driver=new ChromeDriver();
			}
		else if(BROWSER.equals("firefox"))
		{ 
			driver=new FirefoxDriver();
		}
		else {
			 driver=new EdgeDriver();
		     }
		//Navigate to the Url
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Login to the Application-vTiger
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		
		//Navigate to the Organization
		driver.findElement(By.linkText("Organizations")).click();
		
		//Navigate to Create Organizations
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Enter mandatory fields and create Organization
		driver.findElement(By.name("accountname")).sendKeys("SkillRary_"+random);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Validate
		String successMsg=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(successMsg.contains("SkillRary"));
		System.out.println(successMsg);
		
		//Logout from Application
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
		
	}
	
}
