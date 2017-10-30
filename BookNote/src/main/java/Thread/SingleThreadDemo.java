package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyTaskSingle implements Runnable{
	private String name;
	public MyTaskSingle(String name){
		this.name = name;
	}
	public void run(){
		System.out.println("\n============任务"+name+"开始执行=======");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n============任务"+name+"执行结束=======");
	}
}

public class SingleThreadDemo {
	public static void main(String[] args){
		ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
		
		MyTaskSingle mts1 = new MyTaskSingle("mst1");
		MyTaskSingle mts2 = new MyTaskSingle("mst2");
		MyTaskSingle mts3 = new MyTaskSingle("mst3");
		
		
		singleThreadPool.execute(mts1);
		singleThreadPool.execute(mts2);
		singleThreadPool.execute(mts3);
		
		singleThreadPool.shutdown();
	}
}
