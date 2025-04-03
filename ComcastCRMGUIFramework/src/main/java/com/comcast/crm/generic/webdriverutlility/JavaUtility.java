package com.comcast.crm.generic.webdriverutlility;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class JavaUtility 
{

	public int  getRandomNumber()
	{
		Random r = new Random();		
		int randomNumber  = r.nextInt(5000);		
		return randomNumber;
		
	}
	
	public String getCurrentDate()
	{
		LocalDate d= LocalDate.now();		
		String date = d.toString();
		return date;
		
	}
	
	/*public String getSystemDateYYYYMMDD()
	{
		Date date = new Date();		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String actualDate = sdf.format(date);
		return actualDate;
	
	}*/
	
	public String getRequiredDate(int days)
	{
		String eDate="";
		LocalDate d = LocalDate.now();
		if(days>0)
		{
	    eDate = d.plusDays(days).toString();  
		}
		else if(days<0)
		{
		  int endDate = (days)*(-1);	
		  eDate = d.minusDays(endDate).toString();
		}
		return eDate;
	}
	
	

	
	
	
}
