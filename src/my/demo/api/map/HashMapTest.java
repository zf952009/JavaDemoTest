package my.demo.api.map;

import java.util.HashMap;
import java.util.Map;

import my.demo.api.component.list.Student;

public class HashMapTest {

	public static void main(String[] args) {
		// 创建hashmap集合
		Map<Student, String> hashmap = new HashMap<Student, String>();
		// 添加元素
		hashmap.put(new Student("zougfang", 18), "湖北");
		hashmap.put(new Student("zougfang", 18), "湖北麻城");
		// 同名。同年龄视为同一个元素，如法存储
		hashmap.put(new Student("zougfang", 19), "湖北麻城s");

		// 循环取出元素
		for (Student keys : hashmap.keySet()) {
			String value = hashmap.get(keys);
			String key = keys.toString();
			System.out.println(key + value);
		}

	}

}
