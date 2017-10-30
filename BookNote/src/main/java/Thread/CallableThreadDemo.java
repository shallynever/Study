package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyCallableTask implements Callable<Object>{
	private String name;
	public MyCallableTask(String name){
		this.name = name; 
	}
	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(name+"����ʼִ��");
		return "==========����ɹ�ִ��==========";
	}
}
public class CallableThreadDemo {
	public static void main(String[] args){
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		Future<?> future = threadPool.submit(new MyCallableTask("TaskA"));		
		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		threadPool.shutdown();
		
	}
}	
