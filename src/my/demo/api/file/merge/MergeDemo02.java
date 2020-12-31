package my.demo.api.file.merge;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import my.demo.api.buffer.BufferTool;

public class MergeDemo02 {

	public static void main(String[] args) throws IOException {
		// 碎片文件合并，使用配置文件合并
		// 读取配置文件中的信息，文件名和碎片文件数量
		File srcProperties = new File("E:\\桌面文件文件夹\\邹芳\\体面_于文文.mp4PartFile\\体面_于文文.mp4.properties");
		FileReader fileReader = new FileReader(srcProperties);

		Properties properties = new Properties();
		properties.load(fileReader);
		// 文件名
		String fileName = properties.getProperty("fileName");
		// 碎片文件数量
		int fileCount = Integer.valueOf(properties.getProperty("fileCount")).intValue();
		// 碎片文件存储文件夹

		ArrayList<FileInputStream> list = new ArrayList<FileInputStream>();
		for (int i = 0; i < fileCount; i++) {
			list.add(new FileInputStream("E:\\桌面文件文件夹\\邹芳\\体面_于文文.mp4PartFile\\" + i + ".part"));
		}

		byte[] buf = new byte[BufferTool.BUFFER_SIZE];

		FileOutputStream foStream = new FileOutputStream("E:\\桌面文件文件夹\\邹芳\\体面_于文文.mp4PartFile\\" + fileName);

		for (FileInputStream fileInputStream : list) {
			int len = 0;
			while ((len = fileInputStream.read(buf)) != -1) {
				foStream.write(buf, 0, len);
			}
			fileInputStream.close();
		}
		foStream.close();

	}

}
