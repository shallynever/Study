package Scoket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private static final int SERVSER_PORT = 30000;
	public static CrazyitMap<String, PrintStream> clients 
	= new CrazyitMap<String, PrintStream>();	
	public void init(){
		try(ServerSocket  ss = new ServerSocket(SERVSER_PORT)) 
		{							
			while(true){
				System.out.println("服务器已经启动，等待连接");
				Socket socket = ss.accept();
				new ServerThread(socket).start();
				System.out.println("客户端:"+socket.getInetAddress().getHostAddress()+"已连接");
				
			}
			/*ss.close();*/
		
		} catch (IOException ex){
			System.out.print("服务器启动失败");
		}
		
	}
	public static void main(String[] args){
		Server server = new Server();
		server.init();
	}
	
}
