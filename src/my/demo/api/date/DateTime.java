package my.demo.api.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {

	public static void main(String[] args) {
		long date_time = System.currentTimeMillis();// 获取当前时间
		// System.out.println(date_time);
		Date date = new Date(date_time);
		// DateFormat格式风格有：FULL ， LONG ， MEDIUM和SHORT
		// FULL--->2018年7月23日 星期一
		// LONG--->2018年7月23日
		// MEDIUM-->2018-7-23
		// SHORT--->18-7-23
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		String string_date = dateFormat.format(date);
		SimpleDateFormat time = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");// 自定义日期和时间格式
		String str_time = time.format(date);
		System.out.println(str_time);
		System.out.println(string_date);
	}

}
