package my.demo.api.system.in;

import java.io.IOException;
import java.io.InputStream;

public class ReadKeyDemo {

	public static void main(String[] args) throws IOException {
		/**
		 * 将键盘录入的数据存储到文件中
		 * 
		 * 一次读取一个字符
		 * 
		 * 获取键盘录入
		 * 
		 * 将键盘录入的文件存储到文件中
		 */
		InputStream in = System.in;

		int ch = in.read();
		System.out.println(ch);
		ch = in.read();
		System.out.println(ch);
		ch = in.read();
		System.out.println(ch);
		ch = in.read();
		System.out.println(ch);

	}

}
