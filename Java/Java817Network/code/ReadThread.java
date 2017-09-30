package WORK.Java.Java817Network.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 读取socket输入内容的线程
 * @author Administrator
 *
 */
public class ReadThread extends Thread{
	
	private Socket socket;

	public ReadThread(Socket socket) {
		super();
		this.socket = socket;
	}



	@Override
	public void run() {
		try {
			InputStream is = socket.getInputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			String ip = socket.getInetAddress().getHostAddress();
			
			while(true) {
				System.out.println(br.readLine());
			}
			
			
		} catch (IOException e) {
			System.err.println("读取内容异常！");
		}
	}

}
