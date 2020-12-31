package my.demo.api.file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import my.demo.api.system.SystemoTool;

public class FileDetailedList {

	public static void main(String[] args) throws Exception {
		// 获取指定目录下的所有.java文件(包含子目录中的)
		// 将这些文件的绝对路径写入到一个文件中。建立一个java文件清单列表
		/*
		 * 因为是子目录，必须递归 写数据到文件中，输出流 只要java文件，需要过滤器
		 * 满足过滤需求的文件可能会非常多，先利用集合进行临时存储，再写入到文件中去
		 */
		// 指定的需要列出清单的目录
		File dir = new File("E:\\资料\\毕向东javaSE33天基础教程（2013）\\源码");
		// 指定存储到哪个文件中
		File destFile = new File("E:\\桌面文件文件夹\\邹芳\\myJavaFile源码.txt");

		// 指定过滤器
		FileFilter filter = new FileterBySuffix(".java");

		// 指定临时的集合
		ArrayList<File> list = new ArrayList<File>();
		FileTool.getFileByJavaList(dir, filter, list);
		System.out.println(list.size());
		FileTool.write2FileByTxT(list, destFile);

	}

	// 将集合中的数据写入到文件中
	public static void write2File(ArrayList<File> list, File destFile)
			throws IOException {
		FileOutputStream fos = null;
		BufferedOutputStream buffos = null;
		try {
			fos = new FileOutputStream(destFile);
			buffos = new BufferedOutputStream(fos);
			for (File file : list) {
				String info = file.getAbsolutePath()
						+ SystemoTool.LINE_SEPARATOR;
				buffos.write(info.getBytes());
				buffos.flush();// 每写一次路径就刷新一次
			}
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception e) {
					throw new RuntimeException("关闭失败");
				}
			}
		}

	}
	// 指定目录。指定格式的文件存储到集合中
	public static void getFileByJavaList(File dir, FileFilter fileFilter,
			ArrayList<File> list) {
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				getFileByJavaList(file, fileFilter, list);
			} else {
				if (fileFilter.accept(file)) {
					list.add(file);
				}
			}
		}

	}

}
