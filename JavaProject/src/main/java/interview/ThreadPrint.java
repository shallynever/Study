package interview; 

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jing
 * 在本程序中假设生产者生产每次只生产一只烤鸭，等消费者消费完，再接着生产第二只.....
 *
 */
class Print
{
	private int count = 1;
	private char[] cha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private boolean flag = false;
	//	创建一个锁对象。
	Lock lock = new ReentrantLock();
	//	通过已有的锁获取两组监视器，一组监视生产者，一组监视消费者。
	Condition producer_con = lock.newCondition();
	Condition consumer_con = lock.newCondition();
	
	
	public void set()
	{
		lock.lock(); //获取锁对象，当有一个生产者在生产，其他生产者就无法进入
		try
		{
			while(count <= 52){
				/*使用while是为了使线程每次被唤醒之后都要判断标记flag*/
				while(flag)
				{
					try {
						producer_con.await();  //将生产者等待
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}				
				System.out.println(count);							
				if(count%2 == 0){
					flag = true; //生产者生产完后，将标记置为true，这样其他生产者线程进来之后，判断标记就进入等待
					consumer_con.signal();  //唤醒一个消费者线程
				}
				count++;
			}
		}
		finally
		{
			lock.unlock();  //释放锁，让其他生产者进入，这个必须执行，所以放在finally代码块中
		}
		
	}
	public void out()
	{
		lock.lock();  //获取锁对象，当有一个消费者在消费时，其他消费者就无法进入
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
			producer_con.signal();		//唤醒一个生产者
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
