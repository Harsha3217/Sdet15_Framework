package com.crm.comcast.GenericUtils;

import java.util.Date;
import java.util.Random;
/**
 * This class gives Random numbers
 * @author Harsha
 *
 */

public class JavaUtility {
	/**
	 * This method gives Random numbers
	 * @return
	 */
	Date dateObj=new Date();
	public int getRandomNumber()
	{
		Random random=new Random();
		int ran=random.nextInt();
		return ran;
		
	}
	/**
	 * This method gives current year
	 * @param year
	 * @return
	 */
	
	public String getYear(String year)
	{
		String todaysDate=dateObj.toString();
		String[] arr=todaysDate.split("");
		return arr[5];
	}
	/**
	 * This method gives current month
	 * @param month
	 * @return
	 */
	
	public String getMonth(String month)
	{
		String todaysDate=dateObj.toString();
		String[] arr=todaysDate.split("");
		return arr[1];
	}
	/**
	 * This method gives current day
	 * @param day
	 * @return
	 */
	public String getDay(String day)
	{
		String todaysDate=dateObj.toString();
		String[] arr=todaysDate.split("");
		return arr[0];
	}
	/**
	 * This method gives current date
	 * @param date
	 * @return
	 */
	public String getDate(String date)
	{
		String todaysDate=dateObj.toString();
		String[] arr=todaysDate.split("");
		return arr[2];
	}

}
