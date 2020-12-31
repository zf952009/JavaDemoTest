package my.demo.api.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MapValues {

	public static void main(String[] args) {
		// 获取所有的values值
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "星期一");
		map.put("2", "星期二");
		map.put("3", "星期三");
		map.put("4", "星期四");
		map.put("5", "星期五");
		map.put("6", "星期六");
		Collection<String> values = map.values();
		System.out.println(values);

	}

}
