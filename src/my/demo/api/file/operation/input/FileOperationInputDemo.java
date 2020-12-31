package my.demo.api.file.operation.input;

import java.io.File;
import java.io.IOException;

import my.demo.api.file.FileTool;

public class FileOperationInputDemo {

	public static void main(String[] args) throws IOException {
		// 读取指定的文件的内容
		File file = new File("E:\\桌面文件文件夹\\邹芳\\邹芳.txt");

		String string = FileTool.getFile(file);
		System.out.println(string);

	}

}
