package my.demo.api.file.operation.out;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDeomo2 {

	private static final String LINE_SEPARATOR = System
			.getProperty("line.separator");// 定义系统平台的换行符为常量

	public static void main(String[] args) throws IOException {
		// 续写一个存在的文件
		// FileOutputStream(File file, boolean append) 创建文件输出流以写入由指定的
		// File对象表示的文件。append为true时即可以续写文件
		File dir = new File("E:\\桌面文件文件夹\\邹芳\\zoufang");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		String filestr = "zoufang.txt";
		File file = new File(dir, filestr);

		// 创建一个用于操作文件的文件输出流，一创建就明确需要操作的文件
		// 文件输出流的是文件，会自动创建文件，如果文件存在就覆盖该文件
		FileOutputStream filefos = new FileOutputStream(file, true);
		String string = LINE_SEPARATOR + "zoufangdou";
		byte[] bs = string.getBytes();
		filefos.write(bs);
		filefos.close();

	}

}
