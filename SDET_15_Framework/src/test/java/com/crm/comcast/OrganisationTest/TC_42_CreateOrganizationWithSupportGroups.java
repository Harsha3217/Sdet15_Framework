package com.crm.comcast.OrganisationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.BaseClass;

public class TC_42_CreateOrganizationWithSupportGroups extends BaseClass {
	@Test(groups="regressionTest")
	public void createOrganization() throws Throwable{
		//Fetch Data from Excel File
		String OrgName = exLib.getExcelData("sheet1", "TC_01", "OrgName")+jLib.getRandomNumber();

		//Navigate to the Organization
		driver.findElement(By.linkText("Organizations")).click();

		//Navigate to Create Organizations
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		//Enter mandatory fields and create Organization
		driver.findElement(By.name("accountname")).sendKeys(OrgName);

		//Click on Groups Radio Button in assigned To
		WebElement rButton=driver.findElement(By.xpath("//input[@value='T']"));
		wLib.click(driver, rButton);

		//Click on ListBox
		WebElement opt=driver.findElement(By.xpath("//select[@name='assigned_group_id']"));
		wLib.mouseOver(driver, opt);
		
		//Select Support Group Option from Listbox 
		wLib.select(opt, "Support Group");
		
		//Save the Organization
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	}
}