package Thread;

class MyThread implements Runnable{
	@Override
	public void run() {
		
		for (int i = 0; i < 10; i++) {
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"����-->"+i);	
		}
	}	
}

public class ThreadJoinDemo {

	public static void main(String[] args) {
		MyThread mt = new MyThread();
		
		Thread t1 = new Thread(mt,"�Զ����߳�");
		t1.start();
		
		/*for (int i = 0; i <10; i++) {
			if(i>5){
				try {
					t1.join();
				} catch (Exception e) {}
			}
			System.out.println("Main�߳�����-->"+i);
		}*/
		
		
	}

}
