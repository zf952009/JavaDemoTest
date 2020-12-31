package my.demo.api.file;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import my.demo.api.system.SystemoTool;

public class FileTool {
	// 文件操作的工具类
	private FileTool() {
		super();
	}

	// 读取字符文件，按照指定的编码读取
	public static String getFile(File file, String charset) throws IOException {
		String string = "";
		if (file.exists() && file.isFile()) {
			// 创建一个文件输入流（读取文件），默认为空
			FileInputStream finp = null;
			// 创建一个字节流到字符流的桥梁，默认为空
			InputStreamReader inputCharset = null;
			try {
				char[] ch = new char[1024];
				int len;
				// 输入流赋值
				finp = new FileInputStream(file);
				// 指定桥梁
				inputCharset = new InputStreamReader(finp, charset);
				while ((len = inputCharset.read(ch)) != -1) {
					string += new String(ch, 0, len);
				}

			} finally {
				if (inputCharset != null) {
					try {
						inputCharset.close();
					} catch (Exception e) {
						throw new RuntimeException("...关闭失败");
					}

				}
			}
			return string;
		} else {
			throw new FileNotFoundException("...文件不存在");
		}

	}

	// 读取已知字符文件，按照默认编码读取
	public static String getFile(File file) throws IOException {
		String fileString = "";
		if (file.exists() && file.isFile()) {
			FileInputStream fileput = null;
			try {
				byte[] fileByte = new byte[10240];
				int length;
				fileput = new FileInputStream(file);
				while ((length = fileput.read(fileByte)) != -1) {
					fileString = new String(fileByte, 0, length);
				}
			} finally {
				if (fileput != null) {
					try {
						fileput.close();
					} catch (Exception e) {
						throw new RuntimeException("...关闭失败");
					}
				}
			}
			return fileString;
		} else {
			throw new FileNotFoundException("...文件不存在");
		}
	}

	// 输出指定的字符，按照指定的编码格式,
	public static void writer2Charset(File file, String string, String charset) throws IOException {
		if (!file.isDirectory()) {
			OutputStream fileoutput = null;
			OutputStreamWriter outputStreamWriter = null;
			try {
				fileoutput = new FileOutputStream(file);
				outputStreamWriter = new OutputStreamWriter(fileoutput, charset);
				outputStreamWriter.write(string);
			} finally {
				if (outputStreamWriter != null) {
					try {
						outputStreamWriter.close();
					} catch (Exception e) {
						throw new RuntimeException(file + "...关闭失败");
					}

				}
			}
		} else {
			throw new FileNotFoundException(file + "...文件无效");
		}
	}

	// 输出指定的字符，按照默认的平台编码
	public static void writer2Charset(File file, String string) throws IOException {
		// 需要输出的字符，输出的文件。需要一个输出流，使用BufferedWriter

		if (file.isDirectory()) {
			throw new FileNotFoundException(file + "...文件名无效");
		} else {
			Writer fileout = null;
			BufferedWriter bufferouut = null;
			try {
				fileout = new FileWriter(file);
				bufferouut = new BufferedWriter(fileout);
				bufferouut.write(string);

			} finally {
				if (bufferouut != null) {
					try {
						bufferouut.close();

					} catch (Exception e) {
						throw new RuntimeException("...关闭失败");
					}
				}
			}
		}

	}

	// 集合中的数据写入到文件中，按照默认编码，如果源文件存在会覆盖源文件
	public static void write2FileByTxT(List<File> list, File file) throws Exception {
		FileOutputStream fos = null;
		BufferedOutputStream buffos = null;
		// byte[] ch = new byte[1024];
		String info = "";
		try {
			fos = new FileOutputStream(file);
			buffos = new BufferedOutputStream(fos);
			for (File file2 : list) {
				info = file2.getAbsolutePath() + SystemoTool.LINE_SEPARATOR;
				buffos.write(info.getBytes());
				buffos.flush();// 文件写入一次就刷新一次
			}

		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception e) {
					throw new RuntimeException("...文件关闭失败");
				}
			}
		}

	}

	// 将指定目录按照指定的过滤方式存储到集合中
	public static void getFileByJavaList(File dir, FileFilter fileFilter, ArrayList<File> list) {
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				getFileByJavaList(file, fileFilter, list);
			} else {
				if (fileFilter.accept(file)) {
					list.add(file);
				}
			}
		}

	}

	// 将一个文件复制到另一个文件
	public static boolean CopyFileByBuffer(File srcFile, File destFile) throws IOException {
		// 创建一个输出流
		FileOutputStream fos = null;
		// 创建一个输入流
		FileInputStream fInput = null;
		try {
			if (srcFile.isFile()) {

				fos = new FileOutputStream(destFile);

				fInput = new FileInputStream(srcFile);

				// 读取输入流的文件并写入到输出流的文件
				int chtemp;
				byte[] buffer = new byte[1024];
				while ((chtemp = fInput.read(buffer)) != -1) {
					fos.write(buffer, 0, chtemp);
				}
			}
		} finally {
			if (fos != null || fInput != null) {
				try {
					fos.close();
					fInput.close();
				} catch (Exception e) {
					throw new RuntimeException("...关闭失败");
				}
			}
		}
		return true;
	}
}
