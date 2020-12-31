package my.demo.file.string.test;

public class CuotFileStringTest {

	public static void main(String[] args) {
		/*
		 * 将获取到的字符串按照指定的字节长度截取，如果截取到的是中文的一部分就是舍弃，
		 * 
		 * 
		 * 1、一个中文gbk两个字节都是负数，在截取时看看最后一位是不是负数，如果不是就直接截取，
		 * 如果是负数，不要直接舍弃，在看看该负数之前连续出现了几个负数，因为中文两个字节，出现的负数个数是偶数，不要舍弃，
		 * 负数个数是奇数，就舍弃最后一个
		 */

		String string = "zoufang....邹芳·芳";

		int i = string.getBytes().length;
		for (int len = 0; len <= i; len++) {
			String string2 = cutString(string, len);
			System.out.println("截取的长度:" + len + "::" + string2);
		}

	}

	public static String cutString(String string, int len) {
		byte[] ch = string.getBytes();
		int connt = 0;
		for (int i = len - 1; i >= 0; i--) {
			if (ch[i] < 0) {
				connt++;
			} else {
				break;
			}
		}
		if (connt % 2 == 0) {
			return new String(ch, 0, len);
		} else {
			return new String(ch, 0, len - 1);
		}
	}

}
