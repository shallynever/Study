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
		
		System.out.println("���������У��ȴ��ͻ�������");
		/*BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("���������ݣ�");
		String str = bufr.toString();*/
		client = server.accept();
		//�Ӽ��̻�ȡ����
		String str = "hello zhoujing";
		
		out = new PrintStream(client.getOutputStream());
		
		out.println(str);
		out.close();
		client.close();
		server.close();
		

	}

}
