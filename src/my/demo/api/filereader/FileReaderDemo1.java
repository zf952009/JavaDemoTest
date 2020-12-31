package my.demo.api.filereader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderDemo1 {

	public static void main(String[] args) throws IOException {
		// filereader：是读取字符流的对象便捷类，使用平台默认的字符编码和默认缓冲区大小都是合适的
		// buffReaderLine();// 读取一行字符
		buffWriterLine();// 写入一行字符,按照平台默认的编码写入

	}

	public static void buffWriterLine() throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(
				new FileWriter("E:\\桌面文件文件夹\\邹芳\\邹芳12.txt"));
		for (int i = 1; i <= 10; i++) {
			bufferedWriter.write(i + "zoufang");
			bufferedWriter.newLine();
		}

		bufferedWriter.close();
	}
	public static void buffReaderLine() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new FileReader("E:\\桌面文件文件夹\\邹芳\\邹芳.txt"));
		String string = null, string2 = "";
		while ((string = bufferedReader.readLine()) != null) {
			string2 += string;
		}
		System.out.println(string2);

		bufferedReader.close();
	}

}
