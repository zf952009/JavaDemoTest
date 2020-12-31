package my.demo.api.file;

import java.io.File;
import java.util.LinkedList;

public class FilesTestGetAll2 {

	public static void main(String[] args) {
		// 利用递归调用获取子目录中的文件容易引发溢出的异常，
		// 利用文件队列解决问题
		File dir = new File("E:\\桌面文件文件夹\\邹芳");
		//
		FileLinkedList<File> files = new FileLinkedList<File>();
		//
		File[] files2 = dir.listFiles();
		for (File file : files2) {
			if (file.isDirectory()) {
				files.myAdd(file);
			} else {
				System.out.println(file.getName());
			}
		}

		while (!files.isNull()) {
			// 获取队列中的文件，判断是否为文件夹，为文件夹继续存储到列队中，不是文件夹就输出
			File dirfile = files.myGet();
			System.out.println(dirfile.getName());

			File[] files3 = dirfile.listFiles();
			for (File file : files3) {
				if (file.isDirectory()) {
					files.myAdd(file);
				} else {
					System.out.println(file.getName());
				}
			}

		}

	}

}
class FileLinkedList<E> {
	private final LinkedList<E> link = new LinkedList<E>();
	/*
	 * 提供构造队列对象的构造器
	 */
	/*
	 * public FileLinkedList() { link = ; }
	 */
	/*
	 * 添加元素的方法
	 */
	public void myAdd(E obj) {
		link.addFirst(obj);
	}
	/*
	 * 获取元素的方法
	 */
	public E myGet() {
		return link.removeLast();
	}
	/*
	 * 判断队列是否为空
	 */
	public boolean isNull() {
		return link.isEmpty();
	}

}
