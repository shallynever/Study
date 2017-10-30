package networkProgram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;


public class SocketPrograme_Client {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Socket client = new Socket("10.20.216.57", 10000);
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		PrintStream out = new PrintStream(client.getOutputStream());
		
		BufferedReader bufEcho = new BufferedReader(new InputStreamReader(client.getInputStream()));

		boolean flag = true;
		
		while(flag){
			
			System.out.println("请输入消息内容：");
			String temp = input.readLine();
			System.out.println("输入的消息为："+temp);
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
