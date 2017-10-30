package interview; 

class Resource
{
	private String name;
	private int count = 1;
	private boolean flag = false;
	public synchronized void set(String name)
	{
		/*使用while是为了使线程每次被唤醒之后都要判断标记flag*/
		while(flag)
		{
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.name = name + count;
		count++;
		System.out.println(Thread.currentThread().getName()+"...生产者..."+this.name);
		flag = true;
		notifyAll();/*使用notifyAll()是为了确保本线程一定能唤醒对方线程*/
	}
	public synchronized void out()
	{
		while(!flag)
		{
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+"消费者"+this.name);
		flag = false;
		notifyAll();
	}
}

class Producer implements Runnable
{
	private Resource r;
	public Producer(Resource r) {
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

class Consumer implements Runnable
{
	private Resource r;
	public Consumer(Resource r) {
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

public class ProducerConsumerDemo {

	public static void main(String[] args) {
		Resource r = new Resource();
		Producer pro = new Producer(r);
		Consumer con = new Consumer(r);
		
		Thread t0 = new Thread(pro);
		Thread t1 = new Thread(pro);
		Thread t2 = new Thread(pro);
		Thread t3 = new Thread(con);
		Thread t4 = new Thread(con);
		
		t0.start();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
