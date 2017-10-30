package Thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class MySchedualTask implements Runnable{
	private String name;
	public MySchedualTask(String name){
		this.name = name;
	}
	public void run(){		
		System.out.println("\n============»ŒŒÒ"+name+"—”≥Ÿ2√Î÷¥––=======");
	}
}
public class DelayThreadPoolDemo {
	public static void main(String[] args){
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);
		
		ScheduledExecutorService singleScheduledThreadPool = Executors.newSingleThreadScheduledExecutor();
		
		MySchedualTask mst1 = new MySchedualTask("MST1");
		MySchedualTask mst2 = new MySchedualTask("MST2");
		
		scheduledThreadPool.schedule(mst1, 2, TimeUnit.SECONDS);
		singleScheduledThreadPool.schedule(mst2, 10, TimeUnit.SECONDS);
		
		scheduledThreadPool.shutdown();
		singleScheduledThreadPool.shutdown();
	}
}
