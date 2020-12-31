package my.demo.api.file;

import java.io.File;
import java.io.IOException;

public class FileDemo1 {

	public static void main(String[] args) throws IOException {
		String pathName = "FileDemo1.java";
		File file = new File(pathName);
		System.out.println(file.getName());
		System.out.println(file.isAbsolute());// 测试文件路径是否为绝对路径，参考pathName
		System.out.println(file.getAbsolutePath());// 返回路径名称的绝对路径字符串
		String pathName2 = "E:\\javademo\\src\\Test.java";
		File file2 = new File(pathName2);
		long modtime = file2.lastModified();// 获取文件的上次修改时间
		long fileSiez = file2.length();// 获取文件的大小(字节表示)
		System.out.println(file2.isAbsolute());// 测试文件路径是否为绝对路径，参考pathName
		// System.out.println(file2.isFile());测试文件是否为普通文件
		System.out.println(fileSiez);
		System.out.println(modtime);

	}

}
