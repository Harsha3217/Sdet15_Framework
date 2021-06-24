package com.crm.comcast.Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.XmlFileUtility;

public class DynamicWebTableSelectFirst5CB {
	@Test 
	public void selectFirst5CB() throws Throwable{
		WebDriver driver;
		XmlFileUtility xLib=new XmlFileUtility();
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
		
		//click on first 5 check boxes
		List<WebElement> list =driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[*]//input"));
		for(int i=1;i<=5;i++)
		{
		list.get(i).click();
		}
		driver.quit();
	}

}
