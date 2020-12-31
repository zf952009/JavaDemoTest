package my.demo.api.file.operation.input;

import java.io.File;

import my.demo.api.file.FileTool;

public class FileOperationInputDemo2 {

	public static void main(String[] args) throws Exception {
		// read(byte[]):从输入流读取一些字节数，并将它们存储到缓冲区
		// 实际开发常用此方法读取数据
		File file = new File("E:\\桌面文件文件夹\\邹芳\\myJavaFile源码.txt");

		String files = FileTool.getFile(file);
		System.out.println(files);
	}
}
