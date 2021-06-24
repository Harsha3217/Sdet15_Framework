package com.crm.comcast.GenericUtils;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
/** 
 * This class has methods to read data from xml file
 * @author Harsha
 *
 */

public class XmlFileUtility {
	/**
	 * This method reads data from XML file
	 * @param node
	 * @return
	 * @throws DocumentException
	 */

	public String readDataFromXMLFile(String node) throws DocumentException {
		//Read the file from location
		File inputFile=new File(IPathConstants.XMLPATH);
		
		//Read the XML from input
		SAXReader reader=new SAXReader();
		Document doc=reader.read(inputFile);
		
		//Navigate to a particular node to get the value
		String value=doc.selectSingleNode("//commonData/"+node).getText();
		return value;
		
	}

}
