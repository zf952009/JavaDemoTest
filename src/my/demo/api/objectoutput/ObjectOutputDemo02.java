package my.demo.api.objectoutput;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class ObjectOutputDemo02 {

	public static void main(String[] args) throws Exception {
		// 对象存储演示
		ObjectOutput output = new ObjectOutputStream(
				new FileOutputStream(new File("E:\\桌面文件文件夹\\邹芳\\zoufang\\map.object")));
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "zoufang");
		map.put("age", "18");
		output.writeObject(map);
		output.close();

	}

}
