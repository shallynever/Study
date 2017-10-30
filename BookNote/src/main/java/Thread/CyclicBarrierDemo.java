package Thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PartTask implements Runnable{
	CyclicBarrier cb;
	String ptname;
	int duringTime;
	public PartTask(CyclicBarrier cb, String ptname, int duringTime){
		this.cb = cb;
		this.ptname = ptname;
		this.duringTime = duringTime;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(ptname+"子程序开始执行！！！");
		try {
			Thread.sleep(duringTime);
			System.out.println(ptname+"子程序执行结束！！！");
			cb.await();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class FinalTask implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("最终任务被执行！！！");
	}
}
public class CyclicBarrierDemo {
	public static void main(String[] args){
		CyclicBarrier cb = new CyclicBarrier(5,new FinalTask());
		
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		
		for (int i = 0; i < 5; i++) {
			threadPool.execute(new PartTask(cb, "partTask"+i, 2000));
		}
		threadPool.shutdown();	
	}
}
