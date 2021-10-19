package com.crm.comcast.genericUtility;

import java.io.FileInputStream;
import java.util.Properties;


/**
 * 
 * @author Deepak
 *
 */
public class FileUtility {
	/**
	 * This method used to read data from properties and return the value based on key specified
	 * @param key
	 * @return value
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream file=new FileInputStream(".\\Data\\CommonData.properties");
		Properties prop=new Properties();
		prop.load(file);
		return prop.getProperty(key);
	}



}
