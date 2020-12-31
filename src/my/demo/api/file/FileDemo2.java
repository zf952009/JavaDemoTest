package my.demo.api.file;

public class FileDemo2 {
	// StackOverflowError:内存溢出异常

	public static void main(String[] args) {
		show();

	}

	public static void show() {
		show();

	}

}
