package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyTask implements Runnable{
	private String tname;
	public MyTask(String name) {
		this.tname = name;
	}
	@Override
	public void run() {
		System.out.println("\n============任务"+tname+"开始执行=======");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n============任务"+tname+"执行结束=======");
	}
}
public class FixedThreadPoolDemo {
	public static void main(String[] args){
		ExecutorService threadPool = Executors.newFixedThreadPool(2);

		MyTask mytask1 = new MyTask("task1");
		MyTask mytask2 = new MyTask("task2");
		MyTask mytask3 = new MyTask("task3");
		
		threadPool.execute(mytask1);
		threadPool.execute(mytask2);
		threadPool.execute(mytask3);
		
		threadPool.shutdown();
	}
}
