package Scoket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPSend {

	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(30000);

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String message;
		boolean flag = true;
		while(flag){
			System.out.print("请输入消息内容：");
			message = input.readLine();
			byte[] buf = message.getBytes();
			if("bye".equals(message)){
				flag = false;
			}
			DatagramPacket dp =
					new DatagramPacket(buf, buf.length, InetAddress.getByName("localhost"), 10000);
			ds.send(dp);


		}
		ds.close();
	}

}
