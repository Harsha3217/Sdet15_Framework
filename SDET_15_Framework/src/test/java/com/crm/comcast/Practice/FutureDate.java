package com.crm.comcast.Practice;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FutureDate {

	public static void main(String[] args) throws InterruptedException {

	    WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com");
		
		Actions action=new Actions(driver);
		action.moveByOffset(10, 10).click().perform();
		
		WebElement src=driver.findElement(By.xpath("//input[@id='fromCity']"));
		WebElement dest=driver.findElement(By.xpath("//input[@id='toCity']"));
		
		src.sendKeys("Mumbai");
		driver.findElement(By.xpath("//div[contains(text(),'BOM')]")).click();
		
		Thread.sleep(2000);
		
		dest.sendKeys("Chennai");
		driver.findElement(By.xpath("//div[contains(text(),'MAA')]")).click();
		
		WebElement departTextField=driver.findElement(By.xpath("//span[text()='DEPARTURE']"));
		
		departTextField.click();
		
		int count=0;
		for(int i=0;i<11;i++)
		{
			try
			{
				driver.findElement(By.xpath("//div[@aria-label='Sat Oct 02 2021']")).click();
				count++;
				break;
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
		
		driver.quit();

	}

}
