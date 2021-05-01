package cc.momas.housetenacy.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class DateConvert extends StrutsTypeConverter{
	
	private static List<SimpleDateFormat> fmts = new ArrayList<SimpleDateFormat>();
	static{
		fmts.add(new SimpleDateFormat("yyyy/MM/dd"));
		fmts.add(new SimpleDateFormat("yyyy-MM-dd"));
		fmts.add(new SimpleDateFormat("yy-MM-dd"));
		fmts.add(new SimpleDateFormat("MM-dd-yyyy"));
		fmts.add(new SimpleDateFormat("MM/dd/yyyy"));
		fmts.add(new SimpleDateFormat("yyyy年MM月dd日"));
	}
	
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		Date d = null;
		for (int i = 0; i < fmts.size(); i++) {
			try {
				d = fmts.get(i).parse(arg1[0]);
				break;
			} catch (ParseException e) {
				continue;
			}
		}
		return d;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		return null;
	}

}
