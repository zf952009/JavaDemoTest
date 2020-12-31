package my.demo.api.string;

public class StringFunctionDemo {

	public static void main(String[] args) {

		String string = "zoufang my love";
		// 字符串装换成数
		char[] c = tochar(string);
		printcharArray(c);

		// 通过制定的索引查找字符
		char indexc = indexString(string, 0);
		System.out.println(indexc);

		// 获取指定索引出的字符

	}
	public static char indexString(String string, int i) {

		return string.charAt(i);
	}
	private static void printcharArray(char[] cs) {
		for (int x = 0; x < cs.length; x++) {
			System.out.println("索引" + x + ":" + cs[x]);
		}

	}
	public static char[] tochar(String string) {
		return string.toCharArray();
	}

}
