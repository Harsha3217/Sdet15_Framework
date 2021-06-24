package com.crm.comcast.OrganisationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.BaseClass;

public class TC_44_CreateOrganizationWithoutEmailOptOutput extends BaseClass{
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

		//Check whether Email opt Output Check Box is selected or Not
		WebElement opCheckBox=driver.findElement(By.xpath("//input[@name='emailoptout']"));

		if(opCheckBox.isSelected())
		{
			System.out.println("Pass:is selected");
		}
		else
		{
			System.out.println("Fail:is not selected");
		}

		//Saving the Organization	
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}

}
