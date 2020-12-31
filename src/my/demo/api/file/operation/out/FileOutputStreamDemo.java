package my.demo.api.file.operation.out;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {

	public static void main(String[] args) throws IOException {
		// 创建一个文件并写入内容
		File dir = new File("E:\\桌面文件文件夹\\邹芳\\zoufang");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		String filestr = "zoufang.txt";
		File file = new File(dir, filestr);

		// 创建一个用于操作文件的文件输出流，一创建就明确需要操作的文件
		// 文件输出流的是文件，会自动创建文件，如果文件存在就覆盖该文件
		FileOutputStream filefos = new FileOutputStream(file);
		// 将字符转换为字节数组
		byte[] data = "邹芳，邹大头。".getBytes();
		filefos.write(data);// 将字节流写入到文件中
		filefos.close();// 关闭文件输出流的系统资源

	}

}
