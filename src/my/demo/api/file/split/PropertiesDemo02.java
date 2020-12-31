package my.demo.api.file.split;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo02 {

	public static void main(String[] args) throws IOException {
		// 将配置文件中的数据加载集合中
		demo01();
		// 将集合中的数据保存到文件中
		demo02();
	}

	// 将集合中的数据保存到文件中
	public static void demo02() throws IOException {
		Properties properties = new Properties();
		properties.setProperty("filename", "我是名称");
		properties.setProperty("filesize", "515");

		// 想要把数据保存到文件中,需要输出流
		FileWriter fileWriter = new FileWriter("E:\\桌面文件文件夹\\邹芳\\properties.partconfig");

		properties.store(fileWriter, "my name is zoufang");

		fileWriter.close();

	}

	// 将配置文件中的数据加载集合中,需要输入流
	public static void demo01() throws IOException {
		File file = new File("E:\\桌面文件文件夹\\邹芳\\PartFile\\不要去猜_文慧如.mp4.partconfig");
		FileReader fileReader = new FileReader(file);

		Properties properties = new Properties();
		// 使用Properties集合中load()方法，就可以将流中的数据加载到集合中
		properties.load(fileReader);

		Set<String> set = properties.stringPropertyNames();
		for (String key : set) {
			String value = properties.getProperty(key);
			System.out.println(key + ":" + value);
		}
	}

}
