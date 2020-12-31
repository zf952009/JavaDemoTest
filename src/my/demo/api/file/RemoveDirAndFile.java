package my.demo.api.file;

import java.io.File;

public class RemoveDirAndFile {

	public static void main(String[] args) {
		// 删除文件夹，当文件夹里有文件时文件夹无法删除，所以需要把文件夹里面的内容都需要删除
		File file = new File("E:\\桌面文件文件夹\\邹芳\\zoufangtemp");
		RemoveDir(file);
	}

	public static void RemoveDir(File dir) {
		if (dir.isDirectory() && dir.exists()) {// 判断dir必须是文件夹并且存在

			File[] files = dir.listFiles();
			if (files != null) {// 如果目录系统级目录，Java没有访问权限，那么会返回null数组，最好加入判断

				if (dir.length() == 0) {// 判断文件夹是否为空，如果为空直接删除
					dir.delete();
					return;
				}

				for (File file2 : files) {
					if (file2.isDirectory()) {
						RemoveDir(file2);
					} else {
						System.out.println(
								file2.getName() + ":" + file2.delete());
					}
				}
				System.out.println(dir.getName() + ":" + dir.delete());
			}

		}
	}

}
