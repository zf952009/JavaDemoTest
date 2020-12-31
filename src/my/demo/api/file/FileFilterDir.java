package my.demo.api.file;

import java.io.File;
import java.io.FileFilter;

/*
 * 获取路径中所有的文件夹
 * */
public class FileFilterDir implements FileFilter {
	private String string;
	@SuppressWarnings("unused")
	private String suffix;
	public FileFilterDir(String string) {
		this.string = string;
	}

	public FileFilterDir(String string, String suffix) {
		this.string = string;
		this.suffix = suffix;
	}

	@Override
	public boolean accept(File pathname) {
		// string=文件，即获取所有的文件
		// string=文件夹，即获取搜有的文件夹
		if (string == null) {
			return false;
		}

		if (pathname.isDirectory() && string == "文件夹") {
			return true;
		}
		if (pathname.isFile() && string == "文件") {
			return true;
		}
		return false;

	}
	// public boolean accept(File pathname, String suffix) throws Exception {
	// System.out.println(2333333);
	//
	// if (pathname.isDirectory() && string == "文件") {
	// return suffix.endsWith(suffix);
	// }
	// return false;
	//
	// }

}
