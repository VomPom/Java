package WORK.Java.Java817Network.code.tcp;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("10.239.190.85", 9000);
			
			new ReadThread(socket).start();
			new WriteThread(socket).start();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("服务端连接失败");
		}
		
		
	}

}
