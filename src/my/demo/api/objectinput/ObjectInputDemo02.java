package my.demo.api.objectinput;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

public class ObjectInputDemo02 {

	public static void main(String[] args) throws Exception {
		// 对象读取
		ObjectInput oInput = new ObjectInputStream(
				new FileInputStream(new File("E:\\桌面文件文件夹\\邹芳\\zoufang\\map.object")));
		Object object = oInput.readObject();
		System.out.println(object.toString());
		oInput.close();

	}

}
