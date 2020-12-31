package my.demo.api.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import my.demo.api.component.list.Student;

public class StuderToFileTest {

	private static final String LINE_SEPARATOR = System
			.getProperty("line.separator");

	public static void main(String[] args) throws IOException {

		// 创建一个可以存储学生对象的集合
		Set<Student> set = new TreeSet<Student>(Collections.reverseOrder());
		// 将学生对象添加到集合中
		set.add(new Student("邹芳1", 63, 63, 56));
		set.add(new Student("邹芳2", 93, 20, 30));
		set.add(new Student("邹芳3", 60, 70, 50));
		set.add(new Student("邹芳4", 12, 36, 59));
		set.add(new Student("邹芳5", 75, 68, 92));
		set.add(new Student("邹芳6", 70, 63, 48));
		set.add(new Student("邹芳7", 60, 49, 56));
		set.add(new Student("邹芳8", 80, 82, 51));
		set.add(new Student("邹芳9", 100, 28, 56));

		// 明确学生数据的存储目的地
		File file = new File("E:\\桌面文件文件夹\\邹芳\\Student_info.txt");
		// 将学生集合和存储学生数据的目的地
		write2File(set, file);

	}

	public static void write2File(Set<Student> set, File file)
			throws IOException {
		FileOutputStream fos = null;
		String student_str = "姓名 " + " : " + "总成绩" + LINE_SEPARATOR;
		try {
			fos = new FileOutputStream(file);
			fos.write(student_str.getBytes());
			for (Student student : set) {
				student_str = student.getName() + " : " + student.getSum()
						+ LINE_SEPARATOR;
				fos.write(student_str.getBytes());
			}

		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception e2) {
					throw new RuntimeException("系统资源关闭错误");
				}

			}

		}

	}

}
