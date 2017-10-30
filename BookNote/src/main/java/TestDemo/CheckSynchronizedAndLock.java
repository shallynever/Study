package TestDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CheckSynchronizedAndLock {
	/**
	 * @paramargs
	 */
	private int j;
	private Lock lock = new ReentrantLock();
	String[] str;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckSynchronizedAndLock tt = new CheckSynchronizedAndLock();
		for (int i = 0; i < 2; i++) {
			new Thread(tt.new Adder()).start();
			new Thread(tt.new Subtractor()).start();
		}
	}

	private class Subtractor implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated methodstub
			while (true) {
				/*
				 * synchronized (Test.this) { System.out.println("j--="+
				 * j--); //这里抛异常了，锁能释放吗？ }
				 */
				lock.lock();
				try {
					System.out.println("j--=" + j--);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} finally {
					lock.unlock();
				}
			}
		}
	}

	private class Adder implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated methodstub
			while (true) {
				/*
				 * synchronized (Test.this) { System.out.println("j++="+
				 * j++); }
				 */
				lock.lock();
				try {
					System.out.println("j++=" + j+++str[0]);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} finally {
					lock.unlock();
				}
			}
		}
	}
}
