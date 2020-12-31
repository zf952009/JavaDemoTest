package my.demo.api.file.merge;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import my.demo.api.buffer.BufferTool;

public class MergeDemo01 {

	public static void main(String[] args) throws IOException {
		// 碎片文件合并的方法，没有使用配置文件
		/*
		 * 1.碎片文件有很多，每一个碎片文件 都需要和读取流关联
		 * 
		 * 2.每一个读取流读取到的数据都需要通过一个输出流写入到一个文件中
		 * 
		 * 3.原理:多个流对应一个目的地
		 * 
		 * 将流对象和碎片文件关联后存储到容器中
		 * 
		 * 遍历容器获取其中的流对象，再进行频繁的读写操作
		 * 
		 * 关流也是遍历容器对每一个流对象进行close的调用
		 * 
		 */

		List<FileInputStream> list = new ArrayList<FileInputStream>();

		for (int i = 0; i <= 35; i++) {
			list.add(new FileInputStream("E:\\桌面文件文件夹\\邹芳\\PartFile\\" + i + ".part"));
		}

		FileOutputStream foStream = new FileOutputStream("E:\\桌面文件文件夹\\邹芳\\不要去猜.mp4");

		byte[] buf = new byte[BufferTool.BUFFER_SIZE];

		for (FileInputStream fileInputStream : list) {
			int len = 0;
			while ((len = fileInputStream.read(buf)) != -1) {
				foStream.write(buf, 0, len);
			}
		}
		foStream.close();
		for (FileInputStream fileInputStream : list) {
			fileInputStream.close();
		}

	}

}
