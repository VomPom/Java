package WORK.Java.Java817Network.ChattingRoom;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(8888);
			//用来保存所有的客户端
			HashSet<Socket> clients = new HashSet<>();
			
			while(true) {
				Socket socket = server.accept();
				String ip = socket.getInetAddress().getHostAddress();
				System.out.println(ip+"进入了聊天室");
				clients.add(socket);
				
				new ServerWriteThread(clients,socket).start();
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
