package io;

/*作用
 * 管道流的主要作用就是可以进行两个线程间的通信。一个线程作为管道输出流，另一个线程作为管道输入流，
 * 在启动线程前，只需要将这两个线程的管道流连接到一起就可以。
 * 这要就很方便的实现了两个线程间的通信。
 * 
 * 
 * */

import java.io.PipedInputStream;
import java.io.PipedOutputStream;


class Send implements Runnable{
	private PipedOutputStream pos = null;    
	
	public Send(){
		this.pos = new PipedOutputStream();     //实例化管道输出流
	}
	@Override
	public void run() {
		String str = "zhejianggongshangdaxue";
		try {
			this.pos.write(str.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.pos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public PipedOutputStream getPos(){   //通过线程类获得管道输出流
		return pos;
	}
}
class Receive implements Runnable{

	private PipedInputStream pis = null;
	public Receive(){
		this.pis = new PipedInputStream();   //实例化管道输入流
	}	
	@Override
	public void run() {
		byte b[]=new byte[1024];
		int len= 0;
		try {
			len = this.pis.read(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			pis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("接收内容："+new String(b,0,len));
	}
	public PipedInputStream getPis(){         //通过线程类获得管道输入流
		return pis;
	}
	
}
public class PipedInputStreamAndPipedOutputStream {
	public static void main(String[] args) {
		Send s = new Send();   
		Receive r = new Receive();
		
		try {
			s.getPos().connect(r.getPis());   //连接两个线程的管道流
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		new Thread(s).start();
		new Thread(r).start();
	}

}
