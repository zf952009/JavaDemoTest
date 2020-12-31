package my.demo.api.date;

import java.util.Calendar;

public class DateDemo2 {

	public static void main(String[] args) {
		// 获取日期时间字符串中指定的日期时间信息，获取日历对象
		Calendar calendar = Calendar.getInstance();// 获取当前日期时间的日历对象
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONDAY) + 1;// 月份需要加一
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int week = calendar.get(Calendar.DAY_OF_WEEK);
		String getZHweek = getzhweek(week);
		int host = calendar.get(Calendar.HOUR_OF_DAY);
		int mm = calendar.get(Calendar.MINUTE);
		int ss = calendar.get(Calendar.SECOND);
		int week_of_year = calendar.get(Calendar.WEEK_OF_YEAR);// 当前第几周
		String date_string = year + "年" + month + "月" + day + "日" + getZHweek;
		String time_string = host + ":" + mm + ":" + ss;

		System.out.println(date_string + "\n" + time_string);
		System.out.println("当前周" + week_of_year);

	}

	public static String getzhweek(int week) {
		if (week < 0 || week > 7) {
			throw new RuntimeException(week + "没有对应的星期");

		}
		String[] week_str = {"", "星期日", "星期一", "星期二", "星期三", "星期四", "星期五",
				"星期六"};
		return week_str[week];
	}

}
