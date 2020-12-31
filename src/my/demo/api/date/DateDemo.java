package my.demo.api.date;

import java.text.DateFormat;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
		long date = System.currentTimeMillis();
		date = 1532834855989l;// 1532834855989
		Date time = new Date(date);
		String date_time_Format = DateFormat.getDateTimeInstance().format(time);
		// getDateTimeInstance：日期和时间格式器
		String date_Format = DateFormat.getDateInstance(DateFormat.LONG)
				.format(time);// getDateInstance：日期格式器
		String time_Format = DateFormat.getTimeInstance(DateFormat.SHORT)
				.format(time);// getTimeInstance：时间格式器
		System.out.println(date_time_Format);
		System.out.println(date_Format);
		System.out.println(time_Format);
	}

}
