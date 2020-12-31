package my.demo.api.file;

import java.io.File;

public class FilesTestGetAll {

	public static void main(String[] args) {
		/*
		 * 显示所有子目录中的内容 ，递归遍历
		 */
		File file = new File("E:\\桌面文件文件夹\\邹芳");
		// File file2 = new File("E:\\MYJAVADEMO");
		lastAll(file);
		// lastAll(file2);

	}

	public static void lastAll(File tempfiles) {
		if (!tempfiles.exists()) {
			throw new RuntimeException(tempfiles + ".....该目录或文件不存在");
		}
		File[] files = tempfiles.listFiles();
		for (File file2 : files) {
			if (file2.isDirectory()) {
				System.out.println("dir:" + file2.getAbsolutePath());
				lastAll(file2);
			}
			System.out.println("file:" + file2.getName());
		}
	}

}
