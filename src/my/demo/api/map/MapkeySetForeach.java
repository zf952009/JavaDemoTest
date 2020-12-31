package my.demo.api.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapkeySetForeach {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "星期一");
		map.put("2", "星期二");
		map.put("3", "星期三");
		map.put("4", "星期四");
		map.put("5", "星期五");
		map.put("6", "星期六");
		Set<String> values = map.keySet();// 获取到所有的键
		for (Iterator<String> it = values.iterator(); it.hasNext();) {
			String key = it.next();
			String value = map.get(key);
			System.out.println(key + value);

		}
		// 利用foreach循环遍历集合
		for (String key : values) {
			String value = map.get(key);
			System.out.println(key + value);
		}

	}

}
