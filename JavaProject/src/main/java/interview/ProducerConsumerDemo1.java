package interview; 

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jing
 * �ڱ������м�������������ÿ��ֻ����һֻ��Ѽ���������������꣬�ٽ��������ڶ�ֻ.....
 *
 */
class Resource1
{
	private String name;
	private int count = 1;
	private boolean flag = false;
	//	����һ��������
	Lock lock = new ReentrantLock();
	//	ͨ�����е�����ȡ�����������һ����������ߣ�һ����������ߡ�
	Condition producer_con = lock.newCondition();
	Condition consumer_con = lock.newCondition();
	
	
	public void set(String name)
	{
		lock.lock(); //��ȡ�����󣬵���һ�������������������������߾��޷�����
		try
		{
			/*ʹ��while��Ϊ��ʹ�߳�ÿ�α�����֮��Ҫ�жϱ��flag*/
			while(flag)
			{
				try {
					producer_con.await();  //�������ߵȴ�
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.name = name + count;
			count++;
			System.out.println(Thread.currentThread().getName()+"...������..."+this.name);
			flag = true; //������������󣬽������Ϊtrue�����������������߳̽���֮���жϱ�Ǿͽ���ȴ�
			consumer_con.signal();  //����һ���������߳�
		}
		finally
		{
			lock.unlock();  //�ͷ����������������߽��룬�������ִ�У����Է���finally�������
		}
		
	}
	public void out()
	{
		lock.lock();  //��ȡ�����󣬵���һ��������������ʱ�����������߾��޷�����
		try
		{
			while(!flag)
			{
				try {
					consumer_con.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+"������"+this.name);
			flag = false;
			producer_con.signal();		//����һ��������
		}
		finally
		{
			lock.unlock();
		}
		
	}
}

class Producer1 implements Runnable
{
	private Resource1 r;
	public Producer1(Resource1 r) {
		this.r = r;
	}
	@Override
	public void run() {
		while(true)
		{
			r.set("��Ѽ");
		}
	}
	
}

class Consumer1 implements Runnable
{
	private Resource1 r;
	public Consumer1(Resource1 r) {
		this.r = r;
	}
	@Override
	public void run() {
		while(true)
		{
			r.out();
		}
	}
	
}

public class ProducerConsumerDemo1 {

	public static void main(String[] args) {
		Resource1 r = new Resource1();
		Producer1 pro = new Producer1(r);
		Consumer1 con = new Consumer1(r);
		
		Thread t0 = new Thread(pro); //��������߳�
		Thread t1 = new Thread(pro);
		Thread t2 = new Thread(pro);
		Thread t3 = new Thread(con);
		Thread t4 = new Thread(con);
		
		t0.start(); //��������߳�
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
