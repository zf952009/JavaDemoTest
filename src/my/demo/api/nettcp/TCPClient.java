package my.demo.api.nettcp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient {

	public static void main(String[] args) throws IOException {
		// ?????????????????????
		/*
		 * ?·?????socket
		 * 
		 */
		int i = 0;
		String host = InetAddress.getLocalHost().getHostAddress().toString();
		while (i <= 10) {
			Socket socket = new Socket(host, 10001);
			String string = null;
			string = i + "????????";

			socket.getOutputStream().write(string.getBytes());
			i++;

			socket.close();
		}

	}

}
