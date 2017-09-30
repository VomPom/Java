package WORK.Java.Java817Network.code.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) {
		
		try {
			//创建客户端socket对象 去连接服务端应用程序
			Socket client = new Socket("10.239.190.85", 9000);
			//获取网络输出流对象
			OutputStream os = client.getOutputStream();
			//打印流
			PrintWriter writer = new PrintWriter(os);
			writer.println("你好啊，我是一个客户端程序！");
			writer.flush();
			
			
			//接收服务端发送的消息
			InputStream in = client.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			System.out.println("服务端发送："+br.readLine());
			
			br.close();
			writer.close();
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (ConnectException e) {
			System.err.println("服务器连接失败！");
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
