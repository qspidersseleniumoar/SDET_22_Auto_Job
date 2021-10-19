package com.crm.comcast.genericUtility;

import java.util.Date;
import java.util.Random;

/**
 * This class contains java specific generic libraries
 * @author Deepak
 */

public class JavaUtility {
	
	/**
	 * generate random number 
	 * 
	 */
	public static String getRandomData()
	{
		Random random=new Random();
		int ran=random.nextInt(1000);
		return ""+ran;			
	}
	
	/**
	 * Generate current system date
	 */
	public String getCurrentSystemDate()
	{
		Date date = new Date();
		String currentDate=date.toString();
		return currentDate;
		
	}
	

}
