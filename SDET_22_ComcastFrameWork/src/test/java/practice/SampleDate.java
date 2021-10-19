package practice;

import java.util.Date;

import org.openqa.selenium.By;

public class SampleDate {

	public static void main(String[] args) {
	
		
		Date dateobj = new Date();
		String currentTimeAndDate =  dateobj.toString();
		
		int month = dateobj.getMonth()+1;
		
		int date = dateobj.getDate();
		
	   String year = currentTimeAndDate.split(" ")[5];
	   
	   String actdate = year+"-"+month+"-"+date;
	   
	   System.out.println(actdate);
	 

	}

}
