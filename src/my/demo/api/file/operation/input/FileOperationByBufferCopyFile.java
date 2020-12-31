package my.demo.api.file.operation.input;

import java.io.File;

import my.demo.api.file.FileTool;

/**
 * @author Administrator
 *
 */
public class FileOperationByBufferCopyFile {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		File srcFile = new File("E:\\桌面文件文件夹\\邹芳\\邹芳.txt");
		File destFile = new File("E:\\桌面文件文件夹\\邹芳\\datouzou.java");
		boolean copy = FileTool.CopyFileByBuffer(srcFile, destFile);
		if (copy) {
			System.out.println(srcFile.getName() + ":复制成功");
		}

	}
}
