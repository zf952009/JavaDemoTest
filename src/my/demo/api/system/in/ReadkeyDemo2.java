package my.demo.api.system.in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadkeyDemo2 {

	public static void main(String[] args) throws IOException {
		// 一次读取一行键盘录入
		/*
		 * InputStream inputStream = System.in;
		 * 
		 * InputStreamReader inputStreamReader = new
		 * InputStreamReader(inputStream);
		 * 
		 * BufferedReader bufferedReader = new
		 * BufferedReader(inputStreamReader);
		 */
		// 标准键盘输入流
		BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(System.in));

		String string = null;

		while ((string = bufferedReader2.readLine()) != null) {
			if ("over".equals(string)) {
				break;
			}
			System.out.println(string);
		}
	}

}
