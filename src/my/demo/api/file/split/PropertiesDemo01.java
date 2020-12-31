package my.demo.api.file.split;

import java.util.Properties;
import java.util.Set;

public class PropertiesDemo01 {

	public static void main(String[] args) {
		// properties集合的使用
		/*
		 * 配置文件很多，需要进行存储，个数不确定，就使用集合，配置文件中信息存在对应关系，就使用map集合
		 * 
		 * 配置文件中的信息都是字符串，这些信息不在内存中而是在硬盘上
		 * 
		 * 发现一个map集合和io技术集合的集合对象properties，它存储的键值都是字符串，
		 * 
		 * 通常这个集合就是用于配置文件的操作
		 * 
		 */
		// 基本的使用
		Properties properties = new Properties();
		// 简单的存取操作
		System.out.println("--------简单的存取操作-------");
		properties.setProperty("name", "zoufang");
		properties.setProperty("age", "邹芳");
		String name = properties.getProperty("name");
		String age = properties.getProperty("age");
		System.out.println(name + ":::" + age);

		System.out.println("-------获取集合中所有的内容--------");
		// stringPropertyNames():返回Properties所有的键对象，返回值是set集合
		Set<String> set = properties.stringPropertyNames();

		for (String key : set) {
			String value = properties.getProperty(key);
			System.out.println(key + ":" + value);
		}

	}

}
