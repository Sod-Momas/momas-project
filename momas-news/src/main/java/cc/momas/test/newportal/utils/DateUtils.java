package cc.momas.test.newportal.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtils {
	public static String dateToStr(String pattern, Date date){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	public static Date getDateFromString(String dateStr, String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date d = null;
		try {
			d = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
}
