package Practice.test;

import java.util.Date;

public class CaptureTimeStamp 
{

	public static void main(String[] args)
	{
	
		String date =  new Date().toString().replace(" ","_").replace(":","_");
		//String date =  new Date().toString();
		System.out.println(date);

	}

}
