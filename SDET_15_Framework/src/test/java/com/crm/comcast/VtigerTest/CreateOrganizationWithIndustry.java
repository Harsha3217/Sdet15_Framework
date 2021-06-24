package com.crm.comcast.VtigerTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.BaseClass;

public class CreateOrganizationWithIndustry extends BaseClass {
	@Test 
	public void createOrganization() throws Throwable{
		
		//Fetch Data
		String OrgName = exLib.getExcelData("sheet1", "TC_01", "OrgName")+jLib.getRandomNumber();
		String IndType = exLib.getExcelData("sheet3", "TC_01", "IndustryType");
		
		//Navigate to the Organization
		driver.findElement(By.linkText("Organizations")).click();

		//Navigate to Create Organizations
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		//Enter mandatory fields and create Organization
		driver.findElement(By.name("accountname")).sendKeys(OrgName);

		//Clicking Industry drop down list box and selecting Education as Industry type
		WebElement industryListBox=driver.findElement(By.name("industry"));
		wLib.select(industryListBox,IndType);
		
		//Save organization
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	}
	


}
