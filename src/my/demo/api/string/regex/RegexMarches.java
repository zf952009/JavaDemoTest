package my.demo.api.string.regex;

public class RegexMarches {

	public static void main(String[] args) {
		// 1.匹配
		// 验证QQ号是否匹配
		String string = "12345678901";
		// 规则：QQ号第一个不能为0，最长是10位
		System.out.println(string + checQQ(string));
		// 验证邮箱
		String mail = "1515aa@163.com.cn";
		System.out.println(mail + checMail(mail));

		// 验证手机号
		String tell = "13536362626";
		System.out.println(tell + checTell(tell));

	}

	// 验证手机号
	public static boolean checTell(String tell) {
		// TODO 自动生成的方法存根
		return tell.matches("^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,1,2,5-9])|(177))\\d{8}$");
	}

	// 验证固定电话
	public static boolean checTellPhone(String tell) {

		return tell.matches("^(0\\d{2}-\\d{8}(-\\d{1,4})?)|(0\\d{3}-\\d{7,8}(-\\d{1,4})?)$");
	}

	// 验证QQ号
	public static boolean checQQ(String qq) {
		return qq.matches("[1-9][0-9]{4,9}");
	}

	// 验证邮箱
	public static boolean checMail(String mail) {
		return mail.matches("[a-zA-Z_0-9]+@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,3}){1,3}");
	}

	// 验证身份证
	public static boolean checIDnumber(String IDnumber) {
		// 假设18位身份证号码:41000119910101123X 410001 19910101 123X
		// ^开头
		// [1-9] 第一位1-9中的一个 4
		// \\d{5} 五位数字 10001（前六位省市县地区）
		// (18|19|20) 19（现阶段可能取值范围18xx-20xx年）
		// \\d{2} 91（年份）
		// ((0[1-9])|(10|11|12)) 01（月份）
		// (([0-2][1-9])|10|20|30|31)01（日期）
		// \\d{3} 三位数字 123（第十七位奇数代表男，偶数代表女）
		// [0-9Xx] 0123456789Xx其中的一个 X（第十八位为校验值）
		// $结尾

		// 假设15位身份证号码:410001910101123 410001 910101 123
		// ^开头
		// [1-9] 第一位1-9中的一个 4
		// \\d{5} 五位数字 10001（前六位省市县地区）
		// \\d{2} 91（年份）
		// ((0[1-9])|(10|11|12)) 01（月份）
		// (([0-2][1-9])|10|20|30|31)01（日期）
		// \\d{3} 三位数字 123（第十五位奇数代表男，偶数代表女），15位身份证不含X
		// $结尾
		return IDnumber
				.matches("(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|"
						+ "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$");
	}

}
