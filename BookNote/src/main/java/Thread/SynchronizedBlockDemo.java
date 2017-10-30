package Thread;

class MyThreadR2 extends Thread{
	private Resource rs;
	public MyThreadR2(){
		
	}
	public MyThreadR2(String name,Resource rs){
		this.rs = rs;
		this.setName(name);
	}
	@Override
	public void run() {
		synchronized (rs) {
			System.out.println(Thread.currentThread().getName()+"访问了资源");
			System.out.println(Thread.currentThread().getName()+"带着资源锁睡觉去了");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"睡醒了，释放资源对象锁");
		}
	}
}
public class SynchronizedBlockDemo {
	public static void main(String[] args){
		Resource rs = new Resource();
		
		MyThreadR2 myr1 = new MyThreadR2("Thread1",rs);
		MyThreadR2 myr2 = new MyThreadR2("Thread2",rs);
		
		myr1.start();
		myr2.start();
	}
}
