package my.demo.api.file;

import java.io.File;
import java.io.FilenameFilter;
/*
 * 过滤指定的文件类型
 * */
public class FileFilerBySuffix implements FilenameFilter {
	private String Suffix;

	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(Suffix);

	}

	FileFilerBySuffix(String suffix) {
		super();
		this.Suffix = suffix;
	}

}
