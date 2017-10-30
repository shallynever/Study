package networkProgram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceive {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DatagramSocket ds = new DatagramSocket(10000);
		
		byte[] buf = new byte[1024];
		
		DatagramPacket dp = new DatagramPacket(buf, 1024);
		
		System.out.println("等待接收数据");
		boolean flag = true;
		while(flag){
			ds.receive(dp);
			String meassage = new String(dp.getData(),0,dp.getLength());

			if("bye".equals(meassage)){
				flag = false;
			}
			
			
			System.out.println("接收到的消息为："+meassage);
			
		}
		
		
		ds.close();
		
		
	}

}
