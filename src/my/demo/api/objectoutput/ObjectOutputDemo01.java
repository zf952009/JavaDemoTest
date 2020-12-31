package my.demo.api.objectoutput;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ObjectOutputDemo01 {

	public static void main(String[] args) throws IOException {
		// 对象序列化演示，对象多了就需要把对象存储起来

		ObjectOutput output = new ObjectOutputStream(
				new FileOutputStream(new File("E:\\桌面文件文件夹\\邹芳\\zoufang\\objectdemo.object")));
		ArrayList<String> list = new ArrayList<String>();
		list.add("name");
		list.add("zoufang");
		list.add("age");
		list.add("18");
		output.writeObject(list);
		output.close();

		studer studer = new studer("zoufang", 18);
		studer studer2 = new studer("黄浩", 19);
		ObjectOutput objectOutput = new ObjectOutputStream(
				new FileOutputStream(new File("E:\\桌面文件文件夹\\邹芳\\zoufang\\studer.object")));
		objectOutput.writeObject(studer);
		objectOutput.writeObject(studer2);
		objectOutput.close();

	}

}

abstract interface str {

}

class studer {
	String name;
	int age;

	public studer(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
