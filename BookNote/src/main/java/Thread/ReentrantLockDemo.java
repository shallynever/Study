package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyCount{
	private int count;
	public MyCount(int count){
		this.count = count;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
class MyUser implements Runnable{
	private String userName;
	private Lock countLock;
	private MyCount mc;
	private int taskSum;
	public MyUser(String name, Lock countLock, MyCount mc, int taskSum){
		this.userName = name;
		this.countLock = countLock;
		this.mc = mc;
		this.taskSum = taskSum;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		boolean okFlag = false;
		while(!okFlag){
			try{
				countLock.lock();
				if(taskSum < 0){
					if((mc.getCount()+taskSum) >= 0){
						mc.setCount(taskSum+mc.getCount());
						System.out.println(userName+"成功取款"+(-taskSum)+"元"+"账户余额为："+mc.getCount());
						okFlag = true;
					}					
				}
				else{
					mc.setCount(taskSum+mc.getCount());
					System.out.println(userName+"成功存款"+taskSum+"元，账户余额为："+mc.getCount());
					okFlag = true;
				}
			}
			finally{
				countLock.unlock();
			}
			if(okFlag == true){break;}
			try {
				System.out.println(userName+"账户余额不足，请等待一段时间");
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}		
		}
	}
}

public class ReentrantLockDemo {
	public static void main(String[] args){
		MyCount mc = new MyCount(100);
		
		Lock countLock = new ReentrantLock();
		
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		
		threadPool.execute(new MyUser("zj", countLock, mc, -150));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		threadPool.execute(new MyUser("zhoujing", countLock, mc, 200));
		
		
		threadPool.shutdown();
		
		
		
		
	}
}
