package com.crm.comcast.Practice;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CurrentDate {

	public static void main(String[] args) throws InterruptedException {
		
		Date dateObj=new Date();
		String todaysDate=dateObj.toString();
		String[] arr=todaysDate.split("");
		
		String date=arr[2];
	    String day=arr[0];
	    String month=arr[1];
	    String year=arr[5];
	    
	    String travelDate=date+""+day+""+month+""+year;
	    
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
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		
		driver.findElement(By.xpath("//div[@aria-label='"+travelDate+"']")).click();

	}

}
