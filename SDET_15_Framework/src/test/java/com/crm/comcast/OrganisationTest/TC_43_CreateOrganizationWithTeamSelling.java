package com.crm.comcast.OrganisationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.BaseClass;

public class TC_43_CreateOrganizationWithTeamSelling extends BaseClass{
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

		//Click on Groups Radio button in Assigned To
		WebElement rButton=driver.findElement(By.xpath("//input[@value='T']"));
		wLib.click(driver, rButton);

		//Click on ListBox
		WebElement opt=driver.findElement(By.xpath("//select[@name='assigned_group_id']"));
		wLib.click(driver, opt);

		//Select the Option Team Selling and Click on Save
		wLib.select(opt,"Team Selling");
		
		//Save the Organization
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	}
}
