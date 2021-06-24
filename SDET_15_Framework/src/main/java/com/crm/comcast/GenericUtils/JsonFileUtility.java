package com.crm.comcast.GenericUtils;

import java.io.FileReader;
import java.util.HashMap;
import org.json.simple.parser.JSONParser;
/**
 * This class reads Data from Json file
 * @author Harsha
 *
 */
public class JsonFileUtility {
	/**
	 * This method reads data from Json file
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromJSON(String key) throws Throwable {
		//Read data from json
		FileReader inputFile=new FileReader(IPathConstants.JSONPATH);
		
		//Parse the json object into java data stream
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(inputFile);
		
		//Type cast the object into hashmap and read the data in key value format
		HashMap jobj=(HashMap)obj;
		String value=jobj.get(key).toString();
		
		return value;
		
	}

}

