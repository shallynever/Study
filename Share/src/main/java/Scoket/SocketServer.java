package Scoket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

	public static void main(String[] args) throws IOException {
		ServerSocket server = null;
		Socket client = null;
		PrintStream out = null;
		BufferedReader buf = null;
		server = new ServerSocket(9999);
		
		boolean f = true;
		
		while(f){
			System.out.println("���������У��ȴ��ͻ�������");
			client = server.accept();
			System.out.println("�ͻ������ӳɹ�");
			
			buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			out = new PrintStream(client.getOutputStream());
					
			boolean flag = true;
			
			while(flag){
				System.out.println("��ʼ��ȡ�ͻ��˷��͵���Ϣ");
				String str = buf.readLine();
				System.out.println("�ͻ��˷��͵���ϢΪ��"+str);
				if("bye".equals(str)){
					flag = false;
				}else{
					out.println("Echo"+str);
				}
			}			
			out.close();
			client.close();		
		}
		server.close();
	}
}