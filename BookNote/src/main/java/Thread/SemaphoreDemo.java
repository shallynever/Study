package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

class MyResourcePool{
	public Semaphore sp;
	public MyResourcePool(int count){
		sp = new Semaphore(count);  //��������Ϊcount���ź�����Դ��
		System.out.println("�����ź���Ϊ"+count+"����Դ��");
	}
}
class MyTaskSemaphore implements Runnable{
	private String name;
	private MyResourcePool mrp;
	private int count;
	public MyTaskSemaphore(String name, MyResourcePool mrp, int count) {
		this.name = name;
		this.mrp = mrp;
		this.count = count;
	}	
	@Override
	public void run() {
	// TODO Auto-generated method stub
		try {
			mrp.sp.acquire(count);
			System.out.println(name+"����ɹ�������"+count+"����Դִ����ϣ�������ʣ��"+mrp.sp.availablePermits()+"����Դ");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			mrp.sp.release(count);
			System.out.println("�ͷ�"+count+"��Դ�����ڿ�����ԴΪ��"+mrp.sp.availablePermits());
		}
	}
}
public class SemaphoreDemo {
	public static void main(String[] args){
		MyResourcePool mrp = new MyResourcePool(10);
		
		ExecutorService threadPool = Executors.newFixedThreadPool(4);
		
		threadPool.execute(new MyTaskSemaphore("zhoujing", mrp, 6));
		threadPool.execute(new MyTaskSemaphore("never", mrp, 6));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		threadPool.execute(new MyTaskSemaphore("shallynever", mrp, 3));
		
		threadPool.shutdown();
	}
}
