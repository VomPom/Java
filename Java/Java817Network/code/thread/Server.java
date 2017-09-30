package WORK.Java.Java817Network.code.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * 流式Socket
 * TCP协议传输数据 比较可靠
 * 
 * Socket对象 用来建立服务端和客户端之间的连接
 * 并且负责发送和接收数据
 * 
 * @author Administrator
 *
 */
public class Server {
	public static void main(String[] args) {
		
		try {
			//1.创建服务端 ServerSocket对象 需要指定服务端的端口号 1024-25535
			ServerSocket server = new ServerSocket(9000);
			System.out.println("服务端开启，端口号："+server.getLocalPort());
			while(true) {
				try {
					
					//等待接收客户端发送的socket 阻塞式的 
					Socket socket = server.accept();
					
					//获取客户端的ip对象
					InetAddress address = socket.getInetAddress();
					String ip = address.getHostAddress();
					System.out.println(ip+"连接成功");
					
					
					//获得网络传输过来的输入流对象
					InputStream in = socket.getInputStream();
					BufferedReader br = new BufferedReader(new InputStreamReader(in));
					
					String str = br.readLine();//阻塞式的
					System.out.println(ip+"-->客户端发送："+str);
					
					//输出内容到客户端
					OutputStream os = socket.getOutputStream();
					os.write("ok\n".getBytes());
					os.flush();
					
					os.close();
					br.close();
				}catch (SocketException e) {
					System.err.println("连接异常");
				}
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
