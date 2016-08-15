/**
 * 
 */
package com.infrastructure.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Administrator
 *
 */
public class TimeRoutine {
	
	static public String takeTimeInFormat(String format, int year, 
			int month, int day, int hour, int min, int sec) {
		switch (format) {
		case "yyyy/MM/dd HH:mm:ss":
		case "yyyy-MM-dd HH:mm:ss":
			break;
		default:
			return null;
		}
				
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, min);
		calendar.set(Calendar.SECOND, sec);        
        
        SimpleDateFormat formatter = new SimpleDateFormat(format);
		Date curDate = new Date(calendar.getTimeInMillis());		
		return formatter.format(curDate);        
	}
	
	static public String getSysTimeInFormat() {
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");//12Сʱ��
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//24Сʱ��
		Date curDate = new Date(System.currentTimeMillis());			
		return formatter.format(curDate);
	}
	
	static public int getCurMonth() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.MONTH)+ 1;
	}
	
}
