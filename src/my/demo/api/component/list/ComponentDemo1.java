package my.demo.api.component.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import my.demo.api.component.list.Student;

public class ComponentDemo1 {

	public static void main(String[] args) {
		List<Student> student = new ArrayList<Student>();
		student.add(new Student("zoufang1", 128));
		student.add(new Student("zoufang2", 19));
		student.add(new Student("zoufang3", 221));
		student.add(new Student("zoufang4", 21));
		System.out.println(student.get(2));//获取指定索引的元素
		
		//集合迭代器Iterator，iterator迭代所有元素
		for (Iterator<Student> it = student.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}

	}

}
