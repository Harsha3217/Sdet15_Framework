package com.crm.comcast.VtigerTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.BaseClass;

public class CreateContactWithOrganization extends BaseClass {
	@Test 
	public void createOrganization() throws Throwable
	{
		//Fetch the Data
		String OrgName = exLib.getExcelData("sheet1", "TC_01", "OrgName")+jLib.getRandomNumber();
		String ContactLastName = exLib.getExcelData("sheet2", "Tc_01", "ContactName");
		
		//navigate to organization 
        driver.findElement(By.linkText("Organizations")).click();
	    
	    //navigate to create organization
	    driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	    
	    //enter mandatory fields and create organization
	    driver.findElement(By.name("accountname")).sendKeys(OrgName);
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    
		//Navigate to the Contacts
		driver.findElement(By.linkText("Contacts")).click();

		//Create contact by providing all valid details
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(ContactLastName);
		driver.findElement(By.xpath("//input[@name='account_name']/..//img")).click();
		
		//Switch to child browser
		wLib.switchToWindow(driver, "Accounts");
		driver.findElement(By.id("search_text")).sendKeys(OrgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(OrgName)).click();
		
		//Switch control back to parent
		wLib.switchToWindow(driver, "Contacts");
		
		//Save the Contact
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	}
}


