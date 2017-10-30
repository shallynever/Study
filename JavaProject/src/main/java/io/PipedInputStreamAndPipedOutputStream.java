package io;

/*����
 * �ܵ�������Ҫ���þ��ǿ��Խ��������̼߳��ͨ�š�һ���߳���Ϊ�ܵ����������һ���߳���Ϊ�ܵ���������
 * �������߳�ǰ��ֻ��Ҫ���������̵߳Ĺܵ������ӵ�һ��Ϳ��ԡ�
 * ��Ҫ�ͺܷ����ʵ���������̼߳��ͨ�š�
 * 
 * 
 * */

import java.io.PipedInputStream;
import java.io.PipedOutputStream;


class Send implements Runnable{
	private PipedOutputStream pos = null;    
	
	public Send(){
		this.pos = new PipedOutputStream();     //ʵ�����ܵ������
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
	public PipedOutputStream getPos(){   //ͨ���߳����ùܵ������
		return pos;
	}
}
class Receive implements Runnable{

	private PipedInputStream pis = null;
	public Receive(){
		this.pis = new PipedInputStream();   //ʵ�����ܵ�������
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
		System.out.println("�������ݣ�"+new String(b,0,len));
	}
	public PipedInputStream getPis(){         //ͨ���߳����ùܵ�������
		return pis;
	}
	
}
public class PipedInputStreamAndPipedOutputStream {
	public static void main(String[] args) {
		Send s = new Send();   
		Receive r = new Receive();
		
		try {
			s.getPos().connect(r.getPis());   //���������̵߳Ĺܵ���
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		new Thread(s).start();
		new Thread(r).start();
	}

}
