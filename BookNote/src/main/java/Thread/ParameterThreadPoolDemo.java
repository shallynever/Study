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
		System.out.println("\n============����"+name+"��ʼִ��=======");
		for (int i = 0; i < 10; i++) {
			System.out.println("["+name+"_"+i+"]");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("\n============����"+name+"ִ�н���=======");	
	}	
}
public class ParameterThreadPoolDemo {
	public static void main(String[] args){
		
		/* �������ŵ��̵߳�����С�ڵ����̳߳صı�׼�ߴ��Сʱ���̳߳ص�ʵ�ʴ�СΪ��׼�ߴ��С��
		 * �������ŵ��̵߳����������̳߳صı�׼�ߴ��Сʱ���̳߳ص�ʵ�ʴ�СΪ��ǰ���е��߳�������ȥ���еĳ���
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
		
		System.out.println("�̳߳ص�ʵ�ʴ�СΪ��"+myThreadPool.getPoolSize());
		myThreadPool.shutdown();
		
	}
}
