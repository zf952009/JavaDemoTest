package my.demo.api.string.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegesGet {

	public static void main(String[] args) {
		// 根据规则获取满足规则的数据
		// 取出由三个字母组成的单词
		String string = "women min emm mm eo eeee.";

		String reges = "\\b[a-zA-Z]{3}\\b";
		String string2 = functionDemo01(string, reges);
		System.out.println(string2);
	}

	public static String functionDemo01(String string, String reges) {
		// 获取正则表达式对象
		Pattern pattern = Pattern.compile(reges);

		// 获取匹配器对象
		Matcher matcher = pattern.matcher(string);
		String lin = "";
		while (matcher.find())
			lin += matcher.group() + ".";
		return lin;
	}

	// ip排序
	public static void functionDemo02(String string) {

	}

}
