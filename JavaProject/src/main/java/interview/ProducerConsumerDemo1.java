package interview; 

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jing
 * 在本程序中假设生产者生产每次只生产一只烤鸭，等消费者消费完，再接着生产第二只.....
 *
 */
class Resource1
{
	private String name;
	private int count = 1;
	private boolean flag = false;
	//	创建一个锁对象。
	Lock lock = new ReentrantLock();
	//	通过已有的锁获取两组监视器，一组监视生产者，一组监视消费者。
	Condition producer_con = lock.newCondition();
	Condition consumer_con = lock.newCondition();
	
	
	public void set(String name)
	{
		lock.lock(); //获取锁对象，当有一个生产者在生产，其他生产者就无法进入
		try
		{
			/*使用while是为了使线程每次被唤醒之后都要判断标记flag*/
			while(flag)
			{
				try {
					producer_con.await();  //将生产者等待
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.name = name + count;
			count++;
			System.out.println(Thread.currentThread().getName()+"...生产者..."+this.name);
			flag = true; //生产者生产完后，将标记置为true，这样其他生产者线程进来之后，判断标记就进入等待
			consumer_con.signal();  //唤醒一个消费者线程
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
			System.out.println(Thread.currentThread().getName()+"消费者"+this.name);
			flag = false;
			producer_con.signal();		//唤醒一个生产者
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
			r.set("烤鸭");
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
		
		Thread t0 = new Thread(pro); //创建五个线程
		Thread t1 = new Thread(pro);
		Thread t2 = new Thread(pro);
		Thread t3 = new Thread(con);
		Thread t4 = new Thread(con);
		
		t0.start(); //开启五个线程
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
