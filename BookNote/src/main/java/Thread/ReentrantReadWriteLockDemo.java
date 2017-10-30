package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyResource{
	public ReadWriteLock lock = new ReentrantReadWriteLock(false);
	private String msg = "zhoujing";
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}	
}
class MyUserTask implements Runnable{
	private String username;
	private int functionCode;
	private String msg;
	private MyResource mr;
	public MyUserTask(String username, int functionCode, String msg,MyResource mr) {
		this.username = username;
		this.functionCode = functionCode;
		this.msg = msg;
		this.mr = mr;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(functionCode==0){
			if(username == "zhoujing"){
				mr.lock.readLock().lock();
				System.out.println(username+"�ɹ����������������������Ϊ��"+mr.getMsg());
				try {
					System.out.println(username+"���Ŷ�������˯��ȥ��,˯20��");
					Thread.sleep(20000);
					System.out.println(username+"˯����");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					mr.lock.readLock().unlock();
					System.out.println(username+"���������ͷ�");
				}
			}else if(username == "never"){
				mr.lock.readLock().lock();
				System.out.println(username+"�ɹ����������������������Ϊ��"+mr.getMsg());
				try {
					System.out.println(username+"���Ŷ�������˯��ȥ��,˯10��");
					Thread.sleep(10000);
					System.out.println(username+"˯����");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					mr.lock.readLock().unlock();
					System.out.println(username+"���������ͷ�");
				}
			}else{
				mr.lock.readLock().lock();
				System.out.println(username+"�ɹ����������������������Ϊ��"+mr.getMsg());
				try {
					System.out.println(username+"���Ŷ�������˯��ȥ��,˯2��");
					Thread.sleep(1000);
					System.out.println(username+"˯����");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					mr.lock.readLock().unlock();
					System.out.println(username+"���������ͷ�");
				}
				
			}
		}else{
			mr.lock.writeLock().lock();
			mr.setMsg(msg);
			System.out.println(username+"�ɹ�����д������д�������Ϊ��"+mr.getMsg());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				mr.lock.writeLock().unlock();
			}
		}	
	}	
}
public class ReentrantReadWriteLockDemo {
	public static void main(String[] args){
		MyResource mr = new MyResource();
		
		ExecutorService threadPool = Executors.newFixedThreadPool(4);
		
		threadPool.execute(new MyUserTask("zhoujing", 0, null, mr));
		threadPool.execute(new MyUserTask("never", 0, null, mr));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		threadPool.execute(new MyUserTask("shallynever", 1, "Hello shallynever", mr));
		threadPool.execute(new MyUserTask("shally", 0, null, mr));

		threadPool.shutdown();
	}
}
