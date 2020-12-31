package my.demo.api.file;

import java.io.File;
import java.io.IOException;

public class FileMeth {

	public static void main(String[] args) throws IOException {
		// File file1 = new File("e:\\桌面文件文件夹\\邹芳\\邹芳.txt");
		File file2 = new File("e:\\桌面文件文件夹\\邹芳\\zoufang.txt");
		// boolean delFile = file.delete();删除文件,不去回收站，直接永久性删除
		// boolean isFile = file.exists(); 判断文件是否存在
		// 对目录的操作
		// file2.mkdirs();// 创建为多级目录，
		// file2.mkdir();创建为目录
		file2.createNewFile();// 创建为文件，
		file2.isDirectory();// 测试是否为路径
		file2.isFile();// 测试是否为文件
		file2.isHidden();// 测试是否为隐藏文件
		file2.length();// 获取文件的长度（返回字节）

	}

}
