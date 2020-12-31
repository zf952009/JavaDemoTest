package my.demo.api.netudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSendDemo01 {

	public static void main(String[] args) throws IOException {
		System.out.println("udp ---发送端---运行");

		// udp发送端演示
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

		// 将数据封装到数据包中。数据包对象是datagrampacket
		String string = "我是数据包对象发送的数据";
		byte[] buff = new byte[1024];
		buff = string.getBytes();
		DatagramPacket dPacket = new DatagramPacket(buff, buff.length, InetAddress.getLocalHost(), 10001);

		// 使用socket对象的send方法将数据包发送出去
		dSocket.send(dPacket);

		// 关闭资源
		dSocket.close();

	}

}
