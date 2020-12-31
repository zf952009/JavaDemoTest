package my.demo.api.writer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class SpliterMergeTest01 {

	private static final int BUFFER_SIZE = 1024 * 1024;

	public static void main(String[] args) throws IOException {
		// 文件切割和合并

		// 源文件
		String dirfile = "E:\\Java_8编程官方参考教程_第9版.pdf";
		File dir_file = new File(dirfile);

		// 碎片文件夹
		String srcFile = "E:\\Java_8编程官方参考教程_第9版part\\";
		File src_File = new File(srcFile);

		// 碎片文件大小,M为单位,当PartSize超过3时会抛出异常IndexOutOfBoundsException，索引超出范围
		int PartSize = 3;

		src_File.mkdirs();

		spliter2M(dir_file, srcFile, PartSize);

		// merge2M(src_File);

	}

	// 将碎片为2M的碎片和并
	public static void merge2M(File src_File) throws IOException {
		// 碎片文件夹

		// 将所有的碎片输入流存储到集合中
		ArrayList<FileInputStream> list = new ArrayList<FileInputStream>();
		for (int i = 1; i <= 123; i++) {
			list.add(new FileInputStream(new File(src_File, i + ".part")));
		}

		// 合并后的文件
		FileOutputStream fileOutputStream = new FileOutputStream(new File(src_File, "Java编程集合.pdf"));

		// 缓冲区
		byte[] buff = new byte[BUFFER_SIZE * 2];

		for (FileInputStream fileInputStream : list) {
			int len = 0;
			while ((len = fileInputStream.read(buff)) != -1) {
				fileOutputStream.write(buff, 0, len);
				fileOutputStream.flush();
				fileInputStream.close();
			}
			fileOutputStream.close();
		}

	}

	// 将文件切割成2M的碎片
	public static void spliter2M(File dir_file, String srcFile, int PartSize)
			throws FileNotFoundException, IOException {
		// 文件输出流
		FileOutputStream outputStream = null;

		// 文件输入流
		FileInputStream inputStream = new FileInputStream(dir_file);

		// 缓冲区
		byte[] by = new byte[BUFFER_SIZE];
		int len = 0;
		int count = 0;

		while ((len = inputStream.read(by)) != -1) {

			outputStream = new FileOutputStream(new File(srcFile, ++count + ".part"), true);
			outputStream.write(by, 0, len);
			outputStream.flush();

			// 判断碎片文件切割的大小
			if (PartSize > 1) {
				for (int i = 1; i <= PartSize - 1; i++) {
					len = inputStream.read(by);
					outputStream.write(by, 0, len);
					outputStream.flush();
				}
			}
			outputStream.close();
		}
		inputStream.close();

		// 碎片文件配置信息
		// 源文件名称
		String fileName = dir_file.getName();
		// 碎片数量
		String fileCount = Integer.valueOf(count).toString();
		// 碎片文件大小
		String PartFileSize = Integer.valueOf(PartSize).toString() + "M";
		// 碎片存储目录
		String partFileDir = srcFile;

		Properties properties = new Properties();
		properties.setProperty("fileName", fileName);
		properties.setProperty("fileCount", fileCount);
		properties.setProperty("ParFileSize", PartFileSize);
		properties.setProperty("partFileDir", partFileDir);

		// 将配置文件保存到碎片目录中
		FileWriter fileWriter = new FileWriter(new File(partFileDir, fileName + ".properties"));
		properties.store(fileWriter, "1233");
		fileWriter.close();

	}

}
