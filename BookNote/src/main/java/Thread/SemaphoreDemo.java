package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

class MyResourcePool{
	public Semaphore sp;
	public MyResourcePool(int count){
		sp = new Semaphore(count);  //创建数量为count的信号量资源池
		System.out.println("创建信号量为"+count+"的资源池");
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
			System.out.println(name+"任务成功申请了"+count+"个资源执行完毕！！！，剩余"+mrp.sp.availablePermits()+"个资源");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			mrp.sp.release(count);
			System.out.println("释放"+count+"资源，现在可用资源为："+mrp.sp.availablePermits());
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
