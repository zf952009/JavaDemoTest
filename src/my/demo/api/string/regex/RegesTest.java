package my.demo.api.string.regex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegesTest {

	public static void main(String[] args) throws IOException {
		// 案例演示
		// 爬虫演示，爬出文件中的邮箱
		File file = new File("tempfile\\mail.html");
		String reges = "[a-zA-Z_0-9]+@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,3}){1,3}";
		ArrayList<String> liStrings = test_3(file, reges);
		for (String liString : liStrings) {
			System.out.println(liString);
		}

	}

	/*
	 * 练习一：
	 * 我我.....我我.我....我.要.要要.....要.要学....学...学学....学.学编..编....编..编.编.程程.程.....程.
	 * 程程
	 * 
	 * 还原成：我要学编程。
	 * 
	 * 思路： 可以使用正则表达式的替换功能。 发现其中有叠词，还有一些 .
	 * 
	 * 
	 */
	public static void test_1() {
		String str = "我我.....我我.我....我.要.要要.....要.要学....学...学学....学.学编..编....编..编.编.程程.程.....程.程程";
		// 1,先将 . 去掉。
		str = str.replaceAll("\\.+", "");
		System.out.println(str);

		// 2,用叠词中的一个替换叠词。
		str = str.replaceAll("(.)\\1+", "$1");
		System.out.println(str);
	}

	/*
	 * 练习二： 127.0.0.1 3.3.3.3 192.168.104.23 10.10.10.10 要求按照ip地址的分类进行从小到大的排序。
	 * 
	 * 
	 */
	public static void test_2() {
		String str_ips = "127.0.0.1  3.3.3.3     192.168.104.23  10.10.10.10";

		/*
		 * 应该先让这些ip地址的每一段的位数都是3位，这样才可以通过字符串自然排序。 不足3位用0补，每一段要补的0的个数也不一致。咋补呢？
		 * 
		 * 干脆，按照每一段最大的的补零数去补，保证每一个段至少有三位， 然后每一段只取最后三位。
		 * 
		 * 替换。
		 */
		// 1,先每一段都补两个0.
		str_ips = str_ips.replaceAll("(\\d+)", "00$1");
		System.out.println(str_ips);

		// 2,只保留三位。
		str_ips = str_ips.replaceAll("0*(\\d{3})", "$1");
		System.out.println(str_ips);

		String[] ips = str_ips.split(" +");

		Arrays.sort(ips);// 按照字符串的自然顺序。排序的结果不是对的，因为ip的每一段位数是不一致的。

		for (String ip : ips) {
			System.out.println(ip.replaceAll("0*(\\d+)", "$1"));
		}

	}

	/*
	 * 网络爬虫，到网络中通过指定的规则获取数据的程序
	 * 
	 * 爬指定的文件中的数据
	 * 
	 * 思路：
	 * 
	 * 1.读取文件
	 * 
	 * 2.对读读到的字符串匹配，只要符合规则就获取
	 */
	public static ArrayList<String> test_3(File file, String regex) throws IOException {
		// 创建存储数据的集合
		ArrayList<String> list = new ArrayList<String>();

		// 实例化正则表达式对象
		Pattern pattern = Pattern.compile(regex);

		// 实例化文件
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		String line = "";
		while ((line = bufferedReader.readLine()) != null) {
			Matcher matcher = pattern.matcher(line);
			while (matcher.find()) {
				list.add(matcher.group());
			}
		}
		bufferedReader.close();

		return list;

	}

	// 爬出网络中的邮箱地址
	public static ArrayList<String> test_4(String url, String reges) throws IOException {
		ArrayList<String> list = new ArrayList<>();

		// 将url封装成对象
		URL url2 = new URL(url);

		// 打开连接
		URLConnection connection = url2.openConnection();

		// 获取流
		InputStream inputStream = connection.getInputStream();

		// 读取操作
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

		//
		String line = "";

		// 获取正则表达式对象
		Pattern pattern = Pattern.compile(reges);

		while ((line = bufferedReader.readLine()) != null) {
			Matcher matcher = pattern.matcher(line);
			while (matcher.find()) {
				list.add(matcher.group());
			}

		}
		bufferedReader.close();

		return list;
	}

}
