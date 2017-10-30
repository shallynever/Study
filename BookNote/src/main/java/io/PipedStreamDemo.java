package io;

import org.junit.Test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;


public class PipedStreamDemo {

	/*
	* PipedInputStream��PipedOutputStream���ܣ�
	* 	PipedInputStream����PipedOutputStream��������Ӧ�ó����д����ܵ�ͨ��.
	* 	һ��PipedInputStreamʵ����������һ��PipedOutputStreamʵ������������Ӷ�����һ��ͨ�Źܵ�.
	* 	PipedOutputStream������ܵ���д������,PipedInputStream���Զ�ȡPipedOutputStream��ܵ���д�������.
	* 	����������Ҫ��������߳�֮���ͨ��.
	* 	һ���̵߳�PipedInputStream�����ܹ�������һ���̵߳�PipedOutputStream�����ж�ȡ����.
	*
	*
	* �������ʵ��ԭ��
	* 	PipedInputStream��PipedOutputStream��ʵ��ԭ��������"������-������"ԭ��,
	* 	PipedOutputStream��������,PipedInputStream��������,
	* 	��PipedInputStream����һ��buffer�ֽ�����,Ĭ�ϴ�СΪ1024,��Ϊ������,���"������"���������Ķ���.
	* 	������������,in,out,in��������¼"������"�����˶���,out��������¼"������"�����˶���,
	* 	inΪ-1��ʾ��������,in==out��ʾ��������.
	* 	��������û���������ѵ�ʱ��,Ҳ���ǵ�inΪ-1��ʱ��,�����߻�һֱ�ȴ�,ֱ���ж���������.
	* */


	@Test
	public void pipedStream() throws IOException {
		Send send = new Send();
		Receive receive = new Receive();
		send.getPos().connect(receive.getPis());

		new Thread(receive).start();
		new Thread(send).start();
	}

}


class Send implements Runnable{
	private PipedOutputStream pos = null;
	public Send(){
		this.pos = new PipedOutputStream();
	}
	public PipedOutputStream getPos(){
		return pos;
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

}
class Receive implements Runnable{

	private PipedInputStream pis = null;
	public Receive(){
		this.pis = new PipedInputStream();
	}
	public PipedInputStream getPis(){
		return pis;
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

	
}

