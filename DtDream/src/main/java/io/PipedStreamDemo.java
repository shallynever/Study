package io;

import io.thread.Receive;
import io.thread.Send;
import org.junit.Test;

import java.io.IOException;


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






