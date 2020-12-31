package my.demo.api.netudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceDemo01 {

	public static void main(String[] args) throws IOException {
		System.out.println("udp ---接收端---运行");

		// 接收udp发送的数据，udp接收端演示
		/*
		 * 思路：
		 * 
		 * 1.先有udp socket服务。而且，必须明确接收的端口，否则接收不到数据
		 * 
		 * 2.接收数据之前，先把数据存储到数据包中，定义数据包
		 * 
		 * 3.通过数据包对象获取数据包中的内容，发送端的ip，发送端的端口，发送过来的数据
		 * 
		 * 4.关闭资源
		 */
		// 创建udp socket服务，并明确接收的端口

		DatagramSocket dSocket = new DatagramSocket(10001);

		// 定义接收数据的数据的数据包
		byte[] buff = new byte[1024];
		DatagramPacket dPacket = new DatagramPacket(buff, buff.length);

		// 通过数据包对象获取数据包中的内容
		dSocket.receive(dPacket);// 在接收到数据前处于阻塞状态
		String ip = dPacket.getAddress().getHostAddress();
		int port = dPacket.getPort();
		String text = new String(dPacket.getData(), 0, dPacket.getLength());
		// 打印接收到的数据
		System.out.println(ip + ":" + port + ":" + text);

		// 关闭资源
		dSocket.close();

	}

}
