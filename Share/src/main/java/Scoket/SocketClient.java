package Scoket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;


public class SocketClient {

	public static void main(String[] args) throws IOException {
		Socket client = new Socket("localhost", 9999);
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		PrintStream out = new PrintStream(client.getOutputStream());
		
		BufferedReader bufEcho = new BufferedReader(new InputStreamReader(client.getInputStream()));

		boolean flag = true;
		
		while(flag){
			
			System.out.println("��������Ϣ���ݣ�");
			String temp = input.readLine();
			System.out.println("�������ϢΪ��"+temp);
			out.println(temp);
			if("bye".equals(temp)){
				flag = false;
			}else{
				String echo = bufEcho.readLine();
				System.out.println(echo);
						
			}
			
		}			
		client.close();
		bufEcho.close();
	}
}
