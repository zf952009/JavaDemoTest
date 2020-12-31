package my.demo.api.string.regex;

public class RegesReplaceAll {

	public static void main(String[] args) {
		// 替换演示
		String string = "women##women###";
		System.out.println(functionDemo01(string));
		System.out.println(functionDemo02(string));
		System.out.println(functionDemo03("15636362626"));

		System.out.println(functionDemo04("65462ergergregniuhiuhgs454544gfsgsgsfgsdf12"));

	}

	// #替换成.
	public static String functionDemo01(String string) {
		return string.replaceAll("#+", ".");
	}

	// 去掉从重复出现的符号，只保留一个
	public static String functionDemo02(String string) {
		// $1表示组1中的内容
		return string.replaceAll("(.)\\1+", "$1");
	}

	// 将手机号显示成156****1111,隐藏手机号
	public static String functionDemo03(String string) {
		return string.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
	}

	// 替换字符串中出现了5次以上的数字
	public static String functionDemo04(String string) {
		return string.replaceAll("\\d{5,}", "***");
	}

}
