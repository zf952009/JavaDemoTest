package my.demo.api.map;

import java.util.Map;
import java.util.TreeMap;

public class MapTest {

	public static void main(String[] args) {
		/*
		 * 练习：记录字母在字符串中出现的次数 ,输出格式a(1) b(1)
		 */
		String string = "z..oufangfangzuozoufangfangzoufan";
		string = getStringconter(string);
		System.out.println(string);
	}
	public static String getStringconter(String string) {
		char[] chs = string.toCharArray();
		TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
		int conter = 0;
		for (int i = 0; i < chs.length; i++) {
			// 判断必须是字母才能记录次数
			if (!(chs[i] >= 'a' && chs[i] <= 'z'
					|| chs[i] >= 'A' && chs[i] <= 'Z')) {
				continue;
			}
			Integer value = map.get(chs[i]);
			if (value != null) {
				conter = value;
			}
			conter++;
			map.put(chs[i], conter);
		}
		return maptoString(map);
	}
	private static String maptoString(Map<Character, Integer> map) {
		StringBuilder sBuilder = new StringBuilder();
		for (Character key : map.keySet()) {
			Integer value = map.get(key);
			sBuilder.append(key + "(" + value + ")");
		}
		return sBuilder.toString();
	}

}
