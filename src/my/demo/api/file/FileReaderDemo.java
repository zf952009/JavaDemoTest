package my.demo.api.file;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {

	public static void main(String[] args) throws IOException {
		// FileReader：用于读取字符流的对象，该类的构造函数有默认的字符编码和字节缓冲区大小是适当的，是一个读取字符的便捷类
		File file = new File("E:\\桌面文件文件夹\\邹芳\\贵生.txt");
		FileReader fileReader = new FileReader(file);
		char[] bs = new char[1024];
		int len;
		String fileReaderstr = "";
		while ((len = fileReader.read(bs)) != -1) {
			fileReaderstr = new String(bs, 0, len);

		}
		fileReader.close();
		System.out.println(fileReaderstr);
	}

}
