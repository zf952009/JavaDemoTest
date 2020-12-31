package my.demo.api.system;

public class SystemoTool {
	// 系统工具类
	private SystemoTool() {
		super();
	}
	public static final String LINE_SEPARATOR = System
			.getProperty("line.separator");// 系统换行符
	public static final String PATH_SEPARATOR = System
			.getProperty("path.separator");
	public static final String FILE_SEPARATOR = System
			.getProperty("file.separator");

}
