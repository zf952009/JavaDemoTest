package my.demo.api.file;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

public class FileDetailedListByByte {
	// 文件源目录
	File dir = new File("E:\\资料\\毕向东javaSE33天基础教程（2013）\\源码");

	// 指定存储到哪个文件中
	File destFile = new File("E:\\桌面文件文件夹\\邹芳\\myJavaFile源码.txt");

	// 指定过滤器
	FileFilter filter = new FileterBySuffix(".java");

	// 指定临时的集合
	ArrayList<File> list = new ArrayList<File>();

}
