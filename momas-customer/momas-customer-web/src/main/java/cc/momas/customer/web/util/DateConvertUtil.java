package cc.momas.customer.web.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvertUtil {

	/**
	 * 字符串转日期
	 * 
	 * @param dateString
	 *            用于转换成日期的字符串
	 * @param dateFormat
	 *            传进来的日期格式，如果为<b>null</b>则使用 <b>yyyy/MM/dd</b>的格式转换<br/>
	 *            e.g. 
	 *            <ul>
	 *            	<li>yyyy-MM-dd</li>
	 *            	<li>yyyy/MM/dd</li>
	 *            	<li>MM-dd-yyyy</li>
	 *            	<li>MM/dd/yyyy</li>
	 *            </ul>
	 * @return 
	 * @throws ParseException
	 */
	public static Date getDate(String dateString, String dateFormat) throws ParseException {
		if(dateString == null || "".equals(dateString)) {
			return null;
		}
		if (null == dateFormat) {
			return new SimpleDateFormat("yyyy/MM/dd").parse(dateString);
		} else {
			return new SimpleDateFormat(dateFormat).parse(dateString);
		}
	}

	/**
	 * 日期转字符串
	 * 
	 * @param paramDate
	 * @param dateFormat
	 * @return
	 * @throws Exception
	 */
	public static String dateToString(Date paramDate, String dateFormat) throws Exception {
		if (paramDate == null || dateFormat == null || "".equals(dateFormat)) {
			return null;
		}
		return new SimpleDateFormat(dateFormat).format(paramDate);
	}
}
