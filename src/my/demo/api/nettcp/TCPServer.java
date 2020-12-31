package my.demo.api.nettcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) throws IOException {
		// 服务器端，接受客户端发送的数据

		@SuppressWarnings("resource")
		ServerSocket serverSocket = new ServerSocket(10001);
		while (true) {
			Socket socket = serverSocket.accept();
			InputStream inputStream = socket.getInputStream();
			byte[] buff = new byte[1024];
			int len;
			len = inputStream.read(buff);
			String text = new String(buff, 0, len);
			String ip = socket.getLocalAddress().getHostAddress();
			int port = socket.getLocalPort();
			System.out.println(ip + ":" + port + ":" + text);
		}

		// 关闭服务器资源，正常情况下服务器资源不用关闭
		// serverSocket.close();

	}

}
