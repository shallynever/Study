package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyTaskChange implements Runnable{
	private String name;
	protected String user;
	public MyTaskChange(String name){
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

public class ChangeableThreadPoolDemo {
	public static void main(String[] args){
		ExecutorService changeableThreadPool = Executors.newCachedThreadPool();
		
		MyTaskChange mtc1 = new MyTaskChange("mtc1");
		MyTaskChange mtc2 = new MyTaskChange("mtc2");
		MyTaskChange mtc3 = new MyTaskChange("mtc3");
		MyTaskChange mtc4 = new MyTaskChange("mtc4");
		MyTaskChange mtc5 = new MyTaskChange("mtc5");
		
		changeableThreadPool.execute(mtc1);
		changeableThreadPool.execute(mtc2);
		changeableThreadPool.execute(mtc3);
		changeableThreadPool.execute(mtc4);
		changeableThreadPool.execute(mtc5);
		
		changeableThreadPool.shutdown();
	}

}
