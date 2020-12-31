package my.demo.api.map;

import java.util.Map;
import java.util.TreeMap;

import my.demo.api.component.list.Student;
import my.demo.tools.ComparatorByName;//对姓名年龄排序

public class TreeMapTest {

	public static void main(String[] args) {
		// 创建hashmap集合
		/*
		 * Map<Student, String> hashmap = new HashMap<Student, String>( new
		 * ComparatorByName());
		 */
		// 添加元素
		Map<Student, String> treemap = new TreeMap<Student, String>(
				new ComparatorByName());
		treemap.put(new Student("zougfang", 18), "湖北");
		treemap.put(new Student("zougfang", 18), "湖北麻城");
		// 同名。同年龄视为同一个元素，如法存储
		treemap.put(new Student("zougfang", 19), "湖北麻城s");
		treemap.put(new Student("zougfang", 20), "湖北麻城s");
		treemap.put(new Student("zougfang", 17), "湖北麻城s");
		for (Map.Entry<Student, String> temp : treemap.entrySet()) {
			Student key = temp.getKey();
			String value = temp.getValue();
			System.out.println(key + value);
		}

	}

}
