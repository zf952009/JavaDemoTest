package my.demo.api.netudp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSendDemo2 {

	public static void main(String[] args) throws IOException {
		System.out.println("udp ---发送端---运行");

		// udp发送端演示。发送键盘输入的字符
		/*
		 * 通过查阅API文档发现用于udp传输协议的对象是DatagramSocket、
		 * 
		 * 演示使用DatagramSoket发送一段信息
		 * 
		 * 思路：
		 * 
		 * 1.需要先建立udp的socket。它具备发送和接收的功能
		 * 
		 * 2.将数据封装到数据包中。数据包对象是DatagramPacket
		 * 
		 * 3.使用socket对象的send方法将数据包发送出去
		 * 
		 * 4.关闭资源
		 */
		// 建立udp的socket对象，
		DatagramSocket dSocket = new DatagramSocket();
		// 标准键盘输入流
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			byte[] buff = new byte[1024];
			buff = line.getBytes();
			DatagramPacket dPacket = new DatagramPacket(buff, buff.length, InetAddress.getLocalHost(), 10001);
			dSocket.send(dPacket);
			if ("走了".equals(line)) {
				break;
			}

		}

		// 关闭资源
		dSocket.close();

	}

}
