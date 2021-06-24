package com.crm.comcast.GenericUtils;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * This class reads data from Property File
 * @author 91832
 *
 */

public class PropertyFileUtility {
	/**
	 * This method reads data from Propert File
	 * @param key
	 * @return
	 * @throws Throwable
	 */
        public String readDataFromPropertyFile(String key) throws Throwable {
        	//Read Data from Property
        	FileInputStream fis=new FileInputStream(IPathConstants.PROPERTYFILEPATH);
        	
        	//Create obj of properties and load file
        	Properties pFile=new Properties();
        	pFile.load(fis);
        	
        	//Get the Value
        	String value=pFile.getProperty(key);
        	System.out.print(value);
			return value;
        	
        }
}
 