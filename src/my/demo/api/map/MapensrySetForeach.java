package my.demo.api.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapensrySetForeach {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "星期一");
		map.put("2", "星期二");
		map.put("3", "星期三");
		map.put("4", "星期四");
		map.put("5", "星期五");
		map.put("6", "星期六");
		Set<Map.Entry<String, String>> entryset = map.entrySet();
		Iterator<Map.Entry<String, String>> it = entryset.iterator();
		// 遍历set中的映射对象
		while (it.hasNext()) {
			Map.Entry<String, String> temp = it.next();// 获取到映射关系对象
			String key = temp.getKey();
			String value = temp.getValue();
			System.out.println(key + value);
		}
		/*
		 * map集合中没有迭代器。取出元素的方式，将map集合转成单列集合，再使用单列集合的迭代器 map集合也不能直接使用foreach循环遍历
		 */
		for (Map.Entry<String, String> temp : map.entrySet()) {
			String key = temp.getKey();
			String value = temp.getValue();
			System.out.println(key + value);
		}
	}
}
