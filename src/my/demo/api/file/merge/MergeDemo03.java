package my.demo.api.file.merge;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.regex.Pattern;

import my.demo.api.buffer.BufferTool;

public class MergeDemo03 {

	public static void main(String[] args) throws IOException {
		// 根据配置文件合并碎片文件
		File dir_properties = new File("E:\\桌面文件文件夹\\邹芳\\不要去猜_文慧如.mp4PartFile\\不要去猜_文慧如.mp4.properties");
		merge(dir_properties);

	}

	// 判断字符串是否为数字
	private static boolean isNumber(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();

	}

	// 合并碎片文件
	public static void merge(File dir_properties) throws IOException {
		/*
		 * 健壮性判断
		 * 
		 * 需要判断配置文件是否存在，
		 * 
		 * 配置参数是否为空，源文件名，碎片文件路径，碎片文件数量
		 * 
		 */
		if (!(dir_properties.exists()) && (dir_properties.isFile())) {
			throw new RuntimeException(dir_properties.getName() + "::配置文件不存在");
		}

		Properties properties = new Properties();
		properties.load(new FileReader(dir_properties));
		String fileName = properties.getProperty("fileName");
		String filePath = properties.getProperty("filePath");
		String fileCount = properties.getProperty("fileCount");
		// 判断源文件名，碎片文件数量，碎片文件路径，
		// isNumber():判断字符串是否为数字
		if (fileCount == null || fileName == null || filePath == null || isNumber(fileCount) != true) {
			throw new RuntimeException("配置参数错误");
		}
		int Count = Integer.valueOf(fileCount);

		// 创建一个集合存储碎片文件输入流
		ArrayList<FileInputStream> list = new ArrayList<FileInputStream>();
		for (int i = 0; i < Count; i++) {
			list.add(new FileInputStream(filePath + "\\" + i + ".part"));
		}

		// 缓冲区
		byte[] buff = new byte[BufferTool.BUFFER_SIZE];

		// 定义文件输出流,文件合并后文件存储的路径
		FileOutputStream fileOutputStream = new FileOutputStream(new File("E:\\桌面文件文件夹\\邹芳\\zoufang\\" + fileName));

		// 将集合中的输入流遍历取出，写入到输出流
		for (FileInputStream fileInputStream : list) {
			int len = 0;
			while ((len = fileInputStream.read(buff)) != -1) {
				fileOutputStream.write(buff, 0, len);
			}
			fileInputStream.close();
		}
		fileOutputStream.close();
	}

}
