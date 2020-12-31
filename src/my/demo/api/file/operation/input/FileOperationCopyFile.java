package my.demo.api.file.operation.input;

import java.io.File;

import my.demo.api.file.FileTool;

public class FileOperationCopyFile {

	public static void main(String[] args) throws Exception {
		// 将一个指定的文件复制到另一个空白文件
		// 源文件
		File srcFile = new File("E:\\桌面文件文件夹\\邹芳\\邹芳.txt");
		// 目的文件
		File destFile = new File("E:\\桌面文件文件夹\\邹芳\\zoudatou.txt");
		boolean copy = FileTool.CopyFileByBuffer(srcFile, destFile);
		if (copy) {
			System.out.println(srcFile.getName() + ":复制成功");
		}

	}

	/*
	 * public static boolean CopyFile(File srcFile, File destFile) throws
	 * IOException { if (srcFile.isFile()) { // 创建一个输出流 FileOutputStream fos =
	 * new FileOutputStream(destFile); // 创建一个输入流 FileInputStream fInput = new
	 * FileInputStream(srcFile);
	 * 
	 * // 读取输入流的文件并写入到输出流的文件 int chtemp; while ((chtemp = fInput.read()) != -1)
	 * { fos.write(chtemp); } fos.close(); fInput.close(); return true; } else {
	 * throw new FileNotFoundException(srcFile + "...系统找不到指定文件或文件夹"); }
	 * 
	 * }
	 */
}
