package my.demo.api.file;

import java.io.File;

public class FileListFiles {

	public static void main(String[] args) {
		File file = new File("E:\\桌面文件文件夹\\邹芳");

		// list返回一个字符串数组。存储的是抽象路径中的所有文件和目录
		String[] liStringFile = file.list();
		for (String liStrings : liStringFile) {
			System.out.println(liStrings);
		}

		System.out.println("---我是分隔线---");
		// 过滤对象路径中的所有.txt类型的文件
		File[] files = file.listFiles(new FileFilerBySuffix(".txt"));
		for (File file2 : files) {
			System.out.println(file2);
		}

		System.out.println("---我是分隔线---");
		// 过滤对象路径中的所有文件夹
		File[] filesdir = file.listFiles(new FileFilterDir("文件夹"));
		for (File file2 : filesdir) {
			System.out.println(file2);
		}
	}

}
