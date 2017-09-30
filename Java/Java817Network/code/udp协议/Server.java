package WORK.Java.Java817Network.code.udp协议;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class Server {
	
	public static void main(String[] args) {
		try {
			//数据报式socket
			DatagramSocket socket = new DatagramSocket(8888);
			String str = "hello world!!!";
			//创建一个数据包
			DatagramPacket dp = new DatagramPacket(str.getBytes(), str.getBytes().length);
			//设置发送的地址
			dp.setSocketAddress(new InetSocketAddress("192.168.2.20", 9999));
			//发送数据
			socket.send(dp);
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}

}
