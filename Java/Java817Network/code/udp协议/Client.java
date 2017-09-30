package WORK.Java.Java817Network.code.udp协议;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class Client {
	public static void main(String[] args) {
		try {
			//创建一个数据包socket
			DatagramSocket ds = new DatagramSocket(9999);
			byte[] buf = new byte[1024];
			//设置发送数据的socket地址
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			//设置从哪里接收数据
			dp.setSocketAddress(new InetSocketAddress("192.168.2.20", 8888));
			//阻塞式 用来接收数据
			ds.receive(dp);
			
			String str = new String(buf).trim();
			System.out.println("接收到数据："+str);
			
			
			
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
