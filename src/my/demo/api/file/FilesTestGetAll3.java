package my.demo.api.file;

import java.io.File;

public class FilesTestGetAll3 {

	public static void main(String[] args) {
		// 创建一个队列，用来存储每次遍历的文件夹
		// 队列和递归的结合
		File dir = new File("E:\\桌面文件文件夹\\邹芳");
		FileLinkedList<File> temp = getAllFileOrFileLinkedList(dir);
		getAllFilesOrFile(temp);

	}

	public static void getAllFilesOrFile(FileLinkedList<File> temp) {
		while (!temp.isNull()) {
			File tempfile = temp.myGet();
			System.out.println("files:" + tempfile.getName());
			FileLinkedList<File> temp1 = getAllFileOrFileLinkedList(tempfile);
			getAllFilesOrFile(temp1);
		}

	}
	public static FileLinkedList<File> getAllFileOrFileLinkedList(File file) {
		FileLinkedList<File> fileslinklist = new FileLinkedList<File>();
		if (file.exists()) {
			File[] files = file.listFiles();
			for (File dir : files) {
				if (dir.isDirectory()) {
					fileslinklist.myAdd(dir);
				} else {
					System.out.println("file:" + dir.getName());
				}
			}
		} else {
			throw new RuntimeException(file + "...文件或文件夹不存在");
		}
		return fileslinklist;
	}

}
