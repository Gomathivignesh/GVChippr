package com.hc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeUtil {

	public static void main(String args[]) throws ParseException
	{
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		timeFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		  String time1="10:01:10";
		  String time2="00:02:00";
		Date date1 = timeFormat.parse(time1);
		Date date2 = timeFormat.parse(time2);

		long sum = date1.getTime() + date2.getTime();

		String date3 = timeFormat.format(new Date(sum));
		System.out.println("The sum is "+date3);
		
	}
}
