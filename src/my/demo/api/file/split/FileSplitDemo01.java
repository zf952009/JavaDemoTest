package my.demo.api.file.split;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import my.demo.api.buffer.BufferTool;
import my.demo.api.system.SystemoTool;

public class FileSplitDemo01 {

	public static void main(String[] args) throws IOException {
		/*
		 * 文件切割演示
		 * 
		 * 将一个文件切割成多个碎片文件
		 * 
		 * 思路
		 * 
		 * 1.读取源文件，将源文件分别复制到多个文件中
		 * 
		 * 2.切割为的方法有两种：按照个数切割，按照碎片文件指定大小切
		 * 
		 * 3.将一个输入流对应多个输出流
		 * 
		 * 4.每一个碎片文件都要编号，顺序不要错
		 * 
		 */
		// 源文件
		File srcFile = new File("E:\\桌面文件文件夹\\邹芳\\不要去猜_文慧如.mp4");
		// 碎片文件目录
		File parstFile = new File("E:\\桌面文件文件夹\\邹芳\\PartFile");

		splitFile(srcFile, parstFile);
	}

	public static void splitFile(File srcFile, File parstFile) throws IOException {
		// 功能完整性判断
		// 判断源文件是否存在
		if (!(srcFile.exists() && srcFile.isFile())) {
			throw new RuntimeException(srcFile.getName() + ":::不是正确的文件或文件不存在");
		}

		// 判断碎片文件夹是否存在,如果文件夹不存在就创建碎片文件夹
		if (!parstFile.exists()) {
			parstFile.mkdirs();
		}

		// 文件输入流
		FileInputStream fileInputStream = new FileInputStream(srcFile);
		// 文件输出流
		FileOutputStream fileOutputStream = null;

		// 定义一个1M的缓冲区
		byte[] bs = new byte[BufferTool.BUFFER_SIZE];
		int len = 0;
		int count = 0;
		while ((len = fileInputStream.read(bs)) != -1) {
			fileOutputStream = new FileOutputStream(new File(parstFile, (count++) + ".part"));
			fileOutputStream.write(bs, 0, len);
			fileOutputStream.close();
		}

		/*
		 * 将源文件以及切割的一些信息保存为配置文件和碎片文件一起发送
		 * 
		 * 需要存储的信息:
		 * 
		 * 1.源文件的名称(文件类型)
		 * 
		 * 2.切割的碎片文件个数
		 * 
		 * 将这些信息存储到一个单独文件中
		 */

		// 文件名称
		String filename = srcFile.getName();
		// 文件数量
		String filecount = Integer.valueOf(count).toString();
		// 创建文件配置文件输出流
		FileOutputStream fileOutputStream2 = new FileOutputStream(new File(parstFile, (filename) + ".partconfig"));

		String temp = "filename=" + filename + SystemoTool.LINE_SEPARATOR + "filecount=" + filecount;
		fileOutputStream2.write(temp.getBytes());
		fileOutputStream2.close();
		fileInputStream.close();
	}

}
