package com.crm.comcast.OrganisationTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.BaseClass;

public class TC_41_SearchOrganizationTest extends BaseClass{
	@Test(groups="SmokeTest")
	public void searchOrganization() throws Throwable{
		
		//Fetch Data from Excel File
		String OrgNo = exLib.getExcelData("sheet1", "TC_01", "OrgNumber");
		
		//Navigate to the Organization
		driver.findElement(By.linkText("Organizations")).click();

		//Search the Organization with Organization Number
		driver.findElement(By.name("search_text")).sendKeys(OrgNo);
		driver.findElement(By.name("submit")).click();

	}
}
