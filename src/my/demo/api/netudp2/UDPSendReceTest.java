package my.demo.api.netudp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UDPSendReceTest {

	public static void main(String[] args) throws IOException {
		// 案例：UDP接收和发送，实现群聊程序
		/*
		 * 思路： 1.需要两个线程,一个发送端，一个接收端，接收端不停的接收
		 * 
		 */
		// 发送端的socket和接收端的socket
		DatagramSocket sendSocket = new DatagramSocket();
		DatagramSocket receSocke = new DatagramSocket(10004);

		Send send = new Send(sendSocket);
		Rece rece = new Rece(receSocke);

		// 发送线程
		Thread t1 = new Thread(send);
		// 接收线程
		Thread t2 = new Thread(rece);

		t1.start();
		t2.start();
	}

}

// 接收端
class Rece implements Runnable {
	private DatagramSocket dSocket;

	public Rece(DatagramSocket dSocket) {
		this.dSocket = dSocket;
	}

	@Override
	public void run() {
		while (true) {
			try {
				byte[] buff = new byte[1024];
				DatagramPacket dPacket = new DatagramPacket(buff, buff.length);
				dSocket.receive(dPacket);// 在接收到数据前处于阻塞状态
				String ip = dPacket.getAddress().getHostAddress();
				int port = dPacket.getPort();
				String text = new String(dPacket.getData(), 0, dPacket.getLength());
				// 打印接收到的数据
				System.out.println("发送端ip:" + ip);
				System.out.println("发送端端口:" + port);
				System.out.println(text);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}

// 发送端
class Send implements Runnable {
	private DatagramSocket dSocket;

	public Send(DatagramSocket dSocket) {
		this.dSocket = dSocket;
	}

	@Override
	public void run() {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try {
			while ((line = bufferedReader.readLine()) != null) {
				byte[] buff = new byte[1024];
				buff = line.getBytes();
				DatagramPacket dPacket = new DatagramPacket(buff, buff.length, InetAddress.getLocalHost(), 10004);
				dSocket.send(dPacket);
				if ("走了".equals(line)) {
					break;
				}
			}
		} catch (UnknownHostException e) {
			// 异常必须处理
			e.printStackTrace();
		} catch (IOException e) {
			// 异常必须处理
			e.printStackTrace();
		}

	}

}
