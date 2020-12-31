package my.throwe.exception.ioexception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IOExceptions {
	// io异常类

	private IOExceptions() {
		super();
	}
	// 文件不存在异常
	public static void FileNotExceptin(File file) throws IOException {
		if (!file.exists()) {
			throw new FileNotFoundException(file + "...文件不存在");
		}
	}
	// 文件为文件夹
	public static void FileNotExist(File file) throws IOException {
		if (file.isDirectory()) {
			throw new FileNotFoundException(file + "...该文件为文件夹");
		}
	}

}
