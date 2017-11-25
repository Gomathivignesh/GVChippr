package com.hc.util;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	
	private SecureRandom random = new SecureRandom();
	private static Util instance = null;

	protected Util() {

	}
	
	public static Util getInstance() {
	   if(instance == null) {
	       instance = new Util();
	   }
	   return instance;
	}
	
	/**
	 * This method takes String as input and returns formatted date.
	 * Input string should be dd-MMM-yy (11-Jun-07)
	 * @param dt
	 * @return
	 * @throws ParseException
	 */
	public static Date formatDate(String dt) throws ParseException {
		Date date = null;
		if (dt != null) {
			DateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
			date = formatter.parse(dt);
		}
		return date;
	}
	
	public String generateToken() {
	    return new BigInteger(130, random).toString(32);
	}
}
