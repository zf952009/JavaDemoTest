package my.demo.api.appruncount;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class AppRunCountTest01 {

	public static void main(String[] args) throws IOException {
		// 记录程序的运行次数，一旦到达指定的次数就需要注册
		/*
		 * 思路：在程序运行前先读取配置文件，记录运行的次数 程序
		 * 
		 * 每运行一次，配置文件中记录次数的参数自增，并写入到配置文件中
		 * 
		 * 输入流:读取配置文件
		 * 
		 * 判断配置文件中的次数，达到指定次数提醒用户注册，未达到指定次数程序正常运行，次数自增
		 * 
		 * 输出流将配置参数写入到配置文件中保存
		 * 
		 * 
		 */

		File file = new File("E:\\桌面文件文件夹\\邹芳\\appruntime\\appruncount.propertion");
		file.createNewFile();
		if (isStop(file)) {
			System.out.println("试用次数已到，请注册!!");
			return;
		}
		run();

	}

	private static boolean isStop(File file) throws IOException {
		// 读取配置文件
		FileInputStream fis = new FileInputStream(file);

		Properties properties = new Properties();

		// 将配置文件加载到配置文件集合中
		properties.load(fis);

		//
		fis.close();

		// 读取配置参数
		String value = properties.getProperty("count");
		int count = 0;

		// 判断参数
		if (value == null) {
			count++;
			properties.setProperty("count", String.valueOf(count));
			// 创建配置文件输出流
			FileOutputStream fos = new FileOutputStream(file);
			// 程序运行次数写到配置文件中
			properties.store(fos, "app run count");
			fos.close();
			return false;
		} else if ((count = Integer.valueOf(value)) >= 5) {
			return true;
		} else {
			count++;
			properties.setProperty("count", String.valueOf(count));
			// 创建配置文件输出流
			FileOutputStream fos = new FileOutputStream(file);
			// 程序运行次数写到配置文件中
			properties.store(fos, "app run count");
			fos.close();
			return false;
		}
	}

	// 配置文件写入
	/*
	 * 需要配置文件，配置参数
	 */
	@SuppressWarnings("unused")
	private void setApprunCountPropertion(File file, String key, String value, String remarks) throws IOException {
		// 创建配置文件输入流
		FileInputStream fileInputStream = new FileInputStream(file);

		// 将配置文件加载到集合中
		Properties properties = new Properties();
		properties.load(fileInputStream);

		// 创建配置文件输出流
		FileOutputStream fOutputStream = new FileOutputStream(file);

		// 将配置参数写入集合中
		properties.setProperty(key, value);
		// 将集合中的数据写入到配置文件中
		properties.store(fOutputStream, remarks);

		// 关闭流，释放资源
		try {

		} finally {
			fOutputStream.close();
			fileInputStream.close();

		}

	}

	// 程序代码主体
	public static void run() {
		System.out.println("程序运中……");

	}

}
