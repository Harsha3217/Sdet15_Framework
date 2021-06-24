package com.crm.comcast.VtigerTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.BaseClass;

public class CreateOrganizationTest extends BaseClass {
	@Test 
	public void createOrganization() throws Throwable{
		
		//Fetch Data
		String OrgName = exLib.getExcelData("sheet1", "TC_01", "OrgName")+jLib.getRandomNumber();
		
		
		//Navigate to the Organization
		driver.findElement(By.linkText("Organizations")).click();

		//Navigate to Create Organizations
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		//Enter mandatory fields and create Organization
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//Validate
		String successMsg=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(successMsg.contains("SkillRary"));
		System.out.println(successMsg);


	}


}
