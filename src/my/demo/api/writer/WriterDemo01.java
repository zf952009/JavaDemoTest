package my.demo.api.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterDemo01 {

	public static void main(String[] args) throws IOException {
		// 字符写入到文件中
		String string = "我是内容";
		Writer writer = new FileWriter(new File("E:\\桌面文件文件夹\\邹芳\\贵生.txt"));
		writer.write(string);
		writer.close();

		// 用于将文本写入字符输出流，缓冲字符，提供数组和字符的高效写入
		BufferedWriter writer2 = new BufferedWriter(new FileWriter(new File("E:\\桌面文件文件夹\\邹芳\\贵生1.txt"), true));
		char[] ch = string.toCharArray();
		for (int i = 0; i <= 100; i++) {
			writer2.write(String.valueOf(i).toCharArray());
			writer2.newLine();
			writer2.write(ch, 0, ch.length);
			writer2.flush();
		}
		writer2.close();

	}

}
