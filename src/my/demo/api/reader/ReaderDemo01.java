package my.demo.api.reader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class ReaderDemo01 {

	public static void main(String[] args) throws IOException {
		// 字符写入
		File file = new File("E:\\桌面文件文件夹\\邹芳\\贵生.txt");

		Reader reader = new FileReader(file);

		Writer writer = new FileWriter(file, true);

		String string = "1215我是续写";

		writer.write(string);
		char[] ch = new char[1024];
		reader.read(ch);
		String string2 = String.valueOf(ch);
		System.out.println(string2);

		reader.close();
		writer.close();

	}

}
