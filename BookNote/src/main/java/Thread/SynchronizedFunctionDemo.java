package Thread;

class Resource{
	synchronized void function1(){
		System.out.println(Thread.currentThread().getName()+"ִ����function1");
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName()+"˯����");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	synchronized void function2(){
		System.out.println(Thread.currentThread().getName()+"ִ����function2");
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName()+"˯����");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class MyThreadR extends Thread{
	Resource rs;
	public MyThreadR(String name,Resource rs){
		this.setName(name);
		this.rs = rs;		
	}
	@Override
	public void run() {
		if(this.getName().equals("Thread1")){
			rs.function1();
		}
		else{
			System.out.println("Thread2�����ˣ����Ǵ�ʱThread1ӵ��Resource����������Thread2�޷����룬�ȴ�����function2����");
			rs.function2();
		}
	}
	
}

public class SynchronizedFunctionDemo {
	public static void main(String[] args){
		Resource rs = new Resource();
		
		MyThreadR myr1 = new MyThreadR("Thread1", rs);
		MyThreadR myr2 = new MyThreadR("Thread2", rs);
		
		myr1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myr2.start();
		
	}
}
