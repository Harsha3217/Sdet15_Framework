package com.crm.comcast.Practice;

import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.DatabaseUtility;
import com.crm.comcast.GenericUtils.JsonFileUtility;
import com.crm.comcast.GenericUtils.PropertyFileUtility;
import com.crm.comcast.GenericUtils.XmlFileUtility;

public class DemoRead {
@Test
public void readJson() throws Throwable
{
	//Reading from Property File
	PropertyFileUtility pLib=new PropertyFileUtility();
	String username=pLib.readDataFromPropertyFile("username");
	System.out.println(username);
	
	//Read Data from JSON File
	JsonFileUtility jsonLib=new JsonFileUtility();
	String Url=jsonLib.readDataFromJSON("url");
	System.out.println(Url);
	
	//Read Data from XML File
	XmlFileUtility xLib=new XmlFileUtility();
	String password=xLib.readDataFromXMLFile("password");
	System.out.println(password);
	
	//Read Data from DataBase
	DatabaseUtility dLib=new DatabaseUtility();
	dLib.connectionToDB();
	String value=dLib.executeQueryAndGetData("select * from employee;", 1, "harsha");
	System.out.println(value);
	
	dLib.closeDB();
	
	
	
}
}
