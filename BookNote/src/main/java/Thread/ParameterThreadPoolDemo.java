package Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class MyTaskParameter implements Runnable{
	
	private String name;
	public MyTaskParameter(String name){
		this.name = name;
	}
	@Override
	public void run() {
		System.out.println("\n============任务"+name+"开始执行=======");
		for (int i = 0; i < 10; i++) {
			System.out.println("["+name+"_"+i+"]");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("\n============任务"+name+"执行结束=======");	
	}	
}
public class ParameterThreadPoolDemo {
	public static void main(String[] args){
		
		/* 当运行着的线程的数量小于等于线程池的标准尺寸大小时，线程池的实际大小为标准尺寸大小。
		 * 当运行着的线程的数量大于线程池的标准尺寸大小时，线程池的实际大小为当前运行的线程数量减去队列的长度
		 * */
		BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(2);
		
		ThreadPoolExecutor myThreadPool = new ThreadPoolExecutor(2, 4, 100, TimeUnit.MILLISECONDS, workQueue);
		
		MyTaskParameter mtp1 = new MyTaskParameter("mtp1");
		MyTaskParameter mtp2 = new MyTaskParameter("mtp2");
		MyTaskParameter mtp3 = new MyTaskParameter("mtp3");
		MyTaskParameter mtp4 = new MyTaskParameter("mtp4");
		MyTaskParameter mtp5 = new MyTaskParameter("mtp5");
		MyTaskParameter mtp6 = new MyTaskParameter("mtp6");
	//	MyTaskParameter mtp7 = new MyTaskParameter("mtp7");
		
		myThreadPool.execute(mtp1);
		myThreadPool.execute(mtp2);
		myThreadPool.execute(mtp3);
		myThreadPool.execute(mtp4);
		myThreadPool.execute(mtp5);
		myThreadPool.execute(mtp6);
	//	myThreadPool.execute(mtp7);
		
		System.out.println("线程池的实际大小为："+myThreadPool.getPoolSize());
		myThreadPool.shutdown();
		
	}
}
