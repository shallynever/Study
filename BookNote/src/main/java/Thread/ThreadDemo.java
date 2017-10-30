package Thread;

//创建线程的第一种方式：继承Thread类
class MyThread1 extends Thread{
	public void run(){
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+"运行,i="+i);
		}
	}	
}

//创建线程的第二种方式：实现Runnable接口
class MyThread2 implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+"运行,i="+i);
		}
	}
}

public class ThreadDemo {

	public static void main(String[] args) {
		ThreadDemo01();
//		ThreadDemo02();
		
	}
	public static void ThreadDemo02() {
		MyThread2 mt = new MyThread2();
		
		Thread t1 = new Thread(mt,"A");
		Thread t2 = new Thread(mt,"B");
		
		
		
		t1.start();
		t2.start();
		mt.run();
	}

	public static void ThreadDemo01() {	
		MyThread1 mt1 = new MyThread1();
		MyThread1 mt2 = new MyThread1();
		System.out.println("线程开始之前-->"+mt1.isAlive());
		mt1.start();
		mt2.start();
		System.out.println("线程开始之前-->"+mt1.isAlive());
	}

}
