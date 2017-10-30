package Thread;

class Resource{
	synchronized void function1(){
		System.out.println(Thread.currentThread().getName()+"执行了function1");
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName()+"睡醒了");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	synchronized void function2(){
		System.out.println(Thread.currentThread().getName()+"执行了function2");
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName()+"睡醒了");
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
			System.out.println("Thread2启动了，但是此时Thread1拥有Resource对象锁，故Thread2无法进入，等待进入function2方法");
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
