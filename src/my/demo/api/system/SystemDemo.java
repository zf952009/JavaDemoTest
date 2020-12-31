package my.demo.api.system;

import java.util.Properties;
import java.util.Set;

public class SystemDemo {

	public static void main(String[] args) {
		// 获取当前时间，以毫秒为单位
		long new_datetime = System.currentTimeMillis();
		System.out.println(new_datetime);
		// 获取当前操作系统
		String os_name = System.getProperty("os.name");
		System.out.println(os_name);
		// 获取当前系统编码
		String charset = System.getProperty("sun.jnu.encoding");
		System.out.println(charset);
		// 获取国家
		String language = System.getProperty("user.language");
		System.out.println(language);
		// 系统账户名
		String user_name = System.getProperty("user.name");
		System.out.println(user_name);
		// jdk运行版本
		String java_version = System.getProperty("java.version");
		System.out.println(java_version);
		// 获取文件分隔符,不同的操作系统分隔符不一样
		String file_separator = System.getProperty("file.separator");
		System.out.println(file_separator);

		// 获取所有系统属性
		Properties osProperties = System.getProperties(); // 获取键集合
		Set<String> set = osProperties.stringPropertyNames();
		for (String key : set) {
			// 通过键获取对应的值
			String value = osProperties.getProperty(key);
			System.out.println("属性(key):" + key + "--->值(value):" + value);
		}

	}

}
