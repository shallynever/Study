package Scoket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpSender {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		DatagramPacket dp = null;
		BufferedReader buf = null;
		DatagramSocket ds = null;
		ds = new DatagramSocket();	
		String str = null;
		
		while(true){
			
			System.out.println("input:");
			buf = new BufferedReader(new InputStreamReader(System.in));
			str = buf.readLine();	
			dp = new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName("10.20.215.48"), 8888);
						
			ds.send(dp);
			
			
			
		
		}
		
		
		
		
		
	}

}
