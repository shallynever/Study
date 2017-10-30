package TestDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class SubThreadAndMainThread {
	
	private Lock lock = new ReentrantLock();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SubThreadAndMainThread().init();
	}

	public void init() {
		final Business business = new Business();
		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 50; i++) {
					business.SubThread(i);
				}
			}
		}).start();
		for (int i = 0; i < 50; i++) {
			business.MainThread(i);
		}
	}

	private class Business {		
		public void MainThread(int i) {			
			lock.lock();			
			try {
				for (int j = 0; j < 100; j++) {
					System.out.println(Thread.currentThread().getName() + ":i=" + i
							+ ",j=" + j);
				}				
			}finally{
				lock.unlock();
			}			
		}

		public void SubThread(int i) {
			lock.lock();
			try{
				for (int j = 0; j < 10; j++) {
					System.out.println(Thread.currentThread().getName() + ":i=" + i
							+ ",j=" + j);
				}
			}finally{
				lock.unlock();
			}
		}
	}
}
