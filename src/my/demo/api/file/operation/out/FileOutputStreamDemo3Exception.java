package my.demo.api.file.operation.out;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo3Exception {

	public static void main(String[] args) {
		// 使用到资源时很容易发生异常，需要处理
		File dir = new File("H:\\桌面文件文件夹\\邹芳\\zoufang");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(dir, true);
			fos.write("邹芳".getBytes());
		} catch (IOException e) {
			System.out.println(e.toString() + "严重错误!!!");
		} finally {
			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {
					throw new RuntimeException("");
				}
		}
	}

}
