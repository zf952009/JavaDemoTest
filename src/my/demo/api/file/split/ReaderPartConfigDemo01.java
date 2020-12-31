package my.demo.api.file.split;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReaderPartConfigDemo01 {

	public static void main(String[] args) throws IOException {
		// 解析配置文件.partconfig中的信息
		File configFile = new File("E:\\桌面文件文件夹\\邹芳\\PartFile\\不要去猜_文慧如.mp4.partconfig");
		readPathConfig(configFile);
	}

	public static void readPathConfig(File configFile) throws IOException {
		/*
		 * 配置文件规律，一次读取一行，按照 = 对文本进行切割即可
		 */

		BufferedReader bufferedReader = new BufferedReader(new FileReader(configFile));
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			String[] arr = line.split("=");
			System.out.println(arr[0] + ":::" + arr[1]);
		}

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
		bufferedReader.close();

	}

}
