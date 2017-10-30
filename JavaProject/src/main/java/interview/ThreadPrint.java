package interview; 

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jing
 * �ڱ������м�������������ÿ��ֻ����һֻ��Ѽ���������������꣬�ٽ��������ڶ�ֻ.....
 *
 */
class Print
{
	private int count = 1;
	private char[] cha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private boolean flag = false;
	//	����һ��������
	Lock lock = new ReentrantLock();
	//	ͨ�����е�����ȡ�����������һ����������ߣ�һ����������ߡ�
	Condition producer_con = lock.newCondition();
	Condition consumer_con = lock.newCondition();
	
	
	public void set()
	{
		lock.lock(); //��ȡ�����󣬵���һ�������������������������߾��޷�����
		try
		{
			while(count <= 52){
				/*ʹ��while��Ϊ��ʹ�߳�ÿ�α�����֮��Ҫ�жϱ��flag*/
				while(flag)
				{
					try {
						producer_con.await();  //�������ߵȴ�
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}				
				System.out.println(count);							
				if(count%2 == 0){
					flag = true; //������������󣬽������Ϊtrue�����������������߳̽���֮���жϱ�Ǿͽ���ȴ�
					consumer_con.signal();  //����һ���������߳�
				}
				count++;
			}
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
			System.out.println(cha[(count/2)-1]);
			flag = false;
			producer_con.signal();		//����һ��������
		}
		finally
		{
			lock.unlock();
		}
		
	}
}

class Print1 implements Runnable
{
	private Print p;
	public Print1(Print p) {
		this.p = p;
	}
	@Override
	public void run() {
		while(true)
		{
			p.set();
		}
	}
	
}

class Print2 implements Runnable
{
	private Print p;
	public Print2(Print p) {
		this.p = p;
	}
	@Override
	public void run() {
		while(true)
		{
			p.out();
		}
	}
	
}

public class ThreadPrint {

	public static void main(String[] args) {
		Print p = new Print();
		Print1 pro = new Print1(p);
		Print2 con = new Print2(p);
		
		Thread t0 = new Thread(pro); 
		
		Thread t4 = new Thread(con);
		
		t0.start(); 
		
		t4.start();
	}
}
