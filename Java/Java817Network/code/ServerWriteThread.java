package WORK.Java.Java817Network.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashSet;

import javax.xml.ws.handler.MessageContext.Scope;

public class ServerWriteThread extends Thread{
	
	private HashSet<Socket> clients;//所有的客户端socket
	private Socket socket;//当前线程处理的客户端socket
	public ServerWriteThread(HashSet<Socket> clients, Socket socket) {
		super();
		this.clients = clients;
		this.socket = socket;
	}
	
	@Override
	public void run() {
		String  ip = socket.getInetAddress().getHostAddress();
		try {
			InputStream is = socket.getInputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			while(true) {
				String str = br.readLine();
				//将消息发送给所有的客户端
				for(Socket s:clients) {
					if(s != socket) {
						OutputStream os = s.getOutputStream();
						PrintWriter pw = new PrintWriter(os);
						pw.println(ip+"说："+str);
						pw.flush();
					}
				}
			}
		} catch (IOException e) {
			System.out.println(ip+"离开了聊天室");
			clients.remove(socket);
		}
	}
	
	

}
