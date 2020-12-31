package my.demo.api.nettcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) throws IOException {
		// �������ˣ����ܿͻ��˷��͵�����

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

		// �رշ�������Դ����������·�������Դ���ùر�
		// serverSocket.close();

	}

}
