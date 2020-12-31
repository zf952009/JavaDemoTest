package my.demo.api.file;

import java.io.File;
import java.io.FileFilter;

public class FileterBySuffix implements FileFilter {
	// 文件后缀过滤器
	private String Suffix;
	public FileterBySuffix(String Suffix) {
		super();
		this.Suffix = Suffix;
	}
	public boolean accept(File pathname) {
		return pathname.getName().endsWith(Suffix);
	}

}
