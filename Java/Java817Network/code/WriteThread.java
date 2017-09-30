package WORK.Java.Java817Network.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class WriteThread extends Thread{
	private Socket socket;
	
	public WriteThread(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			OutputStream os = socket.getOutputStream();
			//将控制台中输入的内容作为要发送的消息
			InputStream is = System.in;
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			while(true) {
				String str = br.readLine();//控制台输入的内容
				PrintWriter pw = new PrintWriter(os);
				pw.println(str);//写出内容
				pw.flush();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
