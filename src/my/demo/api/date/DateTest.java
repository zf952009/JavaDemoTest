package my.demo.api.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) throws ParseException {
		// 计算两个日期相差多少天
		String str_date1 = "1997-12-25";
		String str_date2 = "2018年07月29日";
		// 需要对应的日期解析风格
		int style1 = DateFormat.MEDIUM;// 默认的日期解析风格
		int style2 = DateFormat.LONG;// 本地的日期解析风格
		int days = getDays(str_date1, str_date2, style1, style2);
		System.out.println("days:" + days);

	}

	public static int getDays(String str_date1, String str_date2, int style1,
			int style2) throws ParseException {
		// 定义两个对应的日期解析格式器
		DateFormat dateFormat1 = DateFormat.getDateInstance(style1);
		DateFormat dateFormat2 = DateFormat.getDateInstance(style2);

		// 将两个日期解析成日期对象
		Date date1 = dateFormat1.parse(str_date1);
		Date date2 = dateFormat2.parse(str_date2);

		// 获取两个日期对应的毫秒
		long date_time1 = date1.getTime();
		long date_time2 = date2.getTime();
		// 计算两个日期之间相差的毫秒数
		long time = Math.abs(date_time1 - date_time2);

		// 将相差的毫秒值计算成相差的天数
		int days = (int) (time / 1000 / 60 / 60 / 24);

		return days;
	}

}
