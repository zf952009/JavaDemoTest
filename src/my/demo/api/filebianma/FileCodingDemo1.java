package my.demo.api.filebianma;

import java.io.File;
import java.io.IOException;

import my.demo.api.file.FileTool;

public class FileCodingDemo1 {

	public static void main(String[] args) throws IOException {
		// 按照指定的编码读取字符文件和指定的编码写入字符文件
		// 字节--->字符：称之为解码过程 InputStreamReader :将字节数据按照指定的字符编码标准，解码成字符
		// 字符--->字节：称之为编码过程 OutputStreamWriter :将字符按照指定的字符编码标准，编码成字节
		// nextCharset();
		// writerCharset();
		File dir = new File("E:\\桌面文件文件夹\\邹芳\\utf-8.txt");
		String string = "大头邹芳zou";
		String charset = "utf-8";
		// FileTool.writer2Charset(dir, string);
		FileTool.writer2Charset(dir, string, charset);
		FileTool.getFile(dir, charset);

	}
	// public static void writerCharset() throws IOException {
	// OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
	// new FileOutputStream("E:\\桌面文件文件夹\\邹芳\\邹芳123.txt"), "utf-8");
	//
	// for (int i = 0; i <= 20; i++) {
	// outputStreamWriter.write("邹大头" + i);
	// outputStreamWriter.flush();// 每次写入文件都将流刷新一次
	// }
	//
	// outputStreamWriter.close();
	// }
	// public static void nextCharset() throws IOException {
	// InputStreamReader inputStreamReader = new InputStreamReader(
	// new FileInputStream("E:\\桌面文件文件夹\\邹芳\\邹芳123.txt"), "utf-8");
	// // String string = "";
	// char[] chbuff = new char[1024];
	// int len = 0;
	// while ((len = inputStreamReader.read(chbuff)) != -1) {
	// System.out.println(new String(chbuff, 0, len));
	// }
	//
	// inputStreamReader.close();
	// }

}
