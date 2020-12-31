package my.demo.api.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest01 {

	public static void main(String[] args) throws IOException {
		// 字符高效写入
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("E:\\桌面文件文件夹\\邹芳\\贵生2.txt"), true));
		String string = "一级菜单：首页，秒杀，居家，服饰，电器，杂货，饮食，配件，洗护，全球购，服务与支持二级菜单：居家：床品件套，被枕，家具，收纳，布艺软装，家饰服饰：毛衫，外衣，卫衣，裤装，衬衫，T恤，内衣电器：生活电器，厨房电器，个护健康，数码，影音娱乐杂货：海外，黑风力系列，旅行用品，户外，文具饮食：糕点，小食，坚果炒货，果干，冲饮，茗茶，肉制品配件：行李箱，男士包装，女士包装，钱包及小皮件，男鞋，女鞋，拖鞋，围巾件套，配饰，眼镜洗护：毛巾，家庭清洁，美妆，面部护理，身体护理，香薰，洗发护发，浴室用品服务与支持：在线服务，帮助中心，商务合作，开放平台";
		bufferedWriter.write(string.toCharArray());

		// 文件读取
		FileReader fileReader = new FileReader(new File("E:\\桌面文件文件夹\\邹芳\\贵生2.txt"));
		char[] ch = new char[10];
		int len = 0;
		while ((len = fileReader.read(ch)) != -1) {
			bufferedWriter.newLine();
			bufferedWriter.write(ch, 0, len);

		}
		bufferedWriter.close();
		fileReader.close();

	}

}
