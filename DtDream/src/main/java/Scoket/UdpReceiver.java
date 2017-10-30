package Scoket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceiver {
	public static void main(String[] args) throws IOException{
		
		DatagramPacket dp = null;
		DatagramSocket ds = null;
		byte[] buf = new byte[1024];
		
		
		ds = new DatagramSocket(8888);
		dp = new DatagramPacket(buf, 1024);
		
		while(true){
			String str = null;
			ds.receive(dp);
			
			str = new String(dp.getData(),0,dp.getLength());
			
			System.out.println(str);
			
			if(str.equals("over")){
				ds.close();
				break;
				
			}
				
				
			
			
			
		}
		
		
		
		
		
	
		
		
		
		
		
		
	}
}
