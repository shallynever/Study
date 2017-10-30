package TestDemo;

class Demo implements Runnable{
	public void run()
	{
		show();
	}
	public void show()
	{
		for(int x=0; x<20; x++)
		{
			System.out.println(Thread.currentThread().getName()+"....."+x);
		}
	}
}
class  ThreadDemo
{
	public static void main(String[] args) 
	{	
		Demo d = new Demo();
		Thread t1 = new Thread(d);
		Thread t2 = new Thread(d);
		t1.start();
		t2.start();
		System.out.println(Byte.MAX_VALUE);
		
		/*Demo d1 = new Demo();
		Demo d2 = new Demo();
		d1.start();
		d2.start();*/
	}
}
