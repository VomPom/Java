package WORK.Java.Java817Network.code.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9000);
			
			while(true) {
				Socket socket = server.accept();
				String ip = socket.getInetAddress().getHostAddress();
				System.out.println(ip+"连接成功！");
				
				//开启读取内容的线程
				new ReadThread(socket).start();
				
				//开启写内容的线程
				new WriteThread(socket).start();
				
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
