package my.demo.string;



public class StringTest {

	public static void main(String[] args) {
		/**
		 * Sting 操作练习
		 * */
		String str="javademo.java";
		/**
		 * replace()替换指定字符串
		 * */
		String string=str.replace("demo", "te");
		System.out.println(string);
		char st[]=str.toCharArray();
		byte stbyte[]=str.getBytes();
		System.out.println(st);
		System.out.println(stbyte);
		String result="a";
		System.out.println(result.compareTo("....a"));
	}
	
}
