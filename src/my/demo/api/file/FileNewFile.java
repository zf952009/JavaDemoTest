package my.demo.api.file;

import java.io.File;
import java.io.IOException;

public class FileNewFile {
	// java.io.IOException: 系统找不到指定的路径。
	public static void main(String[] args) throws IOException {
		String prefix = "zoufnag";// 文件前缀
		String suffix = ".mp4";// 文件后缀，即文件类型
		// File dir = new File("e:\\桌面文件文夹\\");指定文件夹不存在会抛出异常
		File dir = new File("E:\\桌面文件文件夹\\");
		// 在指定文件目录中创建文件
		File.createTempFile(prefix, suffix, dir);

		// 在默认临时文件目录中创建文件(当前文件路径)，
		File.createTempFile(prefix, suffix);

	}

}
