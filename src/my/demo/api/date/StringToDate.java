package my.demo.api.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate {

	public static void main(String[] args) throws ParseException {
		// 将时间转换成日期对象2011-02-25
		String str_date = "2011-02-25 11:25:26";
		DateFormat dateFormat = DateFormat.getDateTimeInstance();
		Date date = dateFormat.parse(str_date);// 将给定的日期解析成日期时间对象
		System.out.println(date);
		// 将自定义的日期格式转换成日期时间对象
		String str_date1 = "1997-12-12 14-25-22";// 自定义的日期时间
		String strtemp = "yyy-MM-dd hh-mm-ss";// 自定义的日期时间格式
		DateFormat dateformat = new SimpleDateFormat(strtemp);
		Date date2 = dateformat.parse(str_date1);
		System.out.println(date2);

	}

}
