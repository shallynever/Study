package Network_Program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPDemo_Client {

	public static void main(String[] args) throws IOException {
		Socket client = new Socket("localhost",2222);
		BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
		String str = buf.readLine();
		System.out.println("服务器发送的内容："+str);
		client.close();
		buf.close();
		

	}

}
