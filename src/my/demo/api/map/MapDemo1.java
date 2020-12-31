package my.demo.api.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo1 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "星期一");
		map.put("2", "星期二");
		map.put("3", "星期三");
		map.put("4", "星期四");
		map.put("5", "星期五");
		map.put("6", "星期六");
		System.out.println(map.get("星期一"));
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = map.get(key);
			System.out.println(key + "::" + value);
		}
		System.out.println("----------");
		for (Iterator<String> it1 = set.iterator(); it1.hasNext();) {
			System.out.println(it1.next());

		}

	}

}
