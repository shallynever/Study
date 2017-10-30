package Network_Program;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPDemo_Server {

	public static void main(String[] args) throws IOException {
		
		ServerSocket server = new ServerSocket(10006);		
		Socket client = null;
		PrintStream out = null;
		
		System.out.println("服务器运行，等待客户端连接");
		/*BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入内容：");
		String str = bufr.toString();*/
		client = server.accept();
		//从键盘获取数据
		String str = "hello zhoujing";
		
		out = new PrintStream(client.getOutputStream());
		
		out.println(str);
		out.close();
		client.close();
		server.close();
		

	}

}
