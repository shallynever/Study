package io;

import io.thread.Receive;
import io.thread.Send;
import org.junit.Test;

import java.io.IOException;


public class PipedStreamDemo {

	/*
	* PipedInputStream与PipedOutputStream介绍：
	* 	PipedInputStream类与PipedOutputStream类用于在应用程序中创建管道通信.
	* 	一个PipedInputStream实例对象必须和一个PipedOutputStream实例对象进行连接而产生一个通信管道.
	* 	PipedOutputStream可以向管道中写入数据,PipedInputStream可以读取PipedOutputStream向管道中写入的数据.
	* 	这两个类主要用来完成线程之间的通信.
	* 	一个线程的PipedInputStream对象能够从另外一个线程的PipedOutputStream对象中读取数据.
	*
	*
	* 两个类的实现原理：
	* 	PipedInputStream和PipedOutputStream的实现原理类似于"生产者-消费者"原理,
	* 	PipedOutputStream是生产者,PipedInputStream是消费者,
	* 	在PipedInputStream中有一个buffer字节数组,默认大小为1024,作为缓冲区,存放"生产者"生产出来的东西.
	* 	还有两个变量,in,out,in是用来记录"生产者"生产了多少,out是用来记录"消费者"消费了多少,
	* 	in为-1表示消费完了,in==out表示生产满了.
	* 	当消费者没东西可消费的时候,也就是当in为-1的时候,消费者会一直等待,直到有东西可消费.
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






