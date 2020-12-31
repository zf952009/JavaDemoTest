package my.demo.api.string.regex;

public class RegesSpli {

	public static void main(String[] args) {
		// 2.切割演示
		/*
		 * String string = "wo shi   sow   sp    so   ss  ."; String[] strings =
		 * functionDemo01(string); for (String string2 : strings) {
		 * System.out.println(string2); }
		 * 
		 * string = "wo shi  , sow spsos."; strings = functionDemo02(string);
		 * for (String string2 : strings) { System.out.println(string2); }
		 */
		String string = "aahuhuununuhuyhe##eee#######frfrggggg";
		String[] strings = functionDemo4(string);
		for (String string2 : strings) {
			System.out.println(string2);
		}

	}

	// 去掉空格演示
	public static String[] functionDemo01(String string) {
		return string.split(" +");
	}

	// 去掉逗号
	public static String[] functionDemo02(String string) {
		return string.split(",");
	}

	// 特殊的，去掉.号
	public static String[] functionDemo03(String string) {
		return string.split("\\.");
	}

	// 去叠词
	public static String[] functionDemo4(String string) {
		return string.split("(.)\\1+");
	}

}
