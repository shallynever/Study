package memoryManagement;

class RubbishThread extends Thread{
	
	RubbishThread brother;
	String name;
	public RubbishThread(){}
	public RubbishThread(String name){
		this.name = name;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(name+"开始执行");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name+"执行结束");
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.out.println(name+"称为垃圾，并回收");
	}
}
public class ThreadRubbishDemo {
	public static void main(String[] args){
		RubbishThread rt1 = new RubbishThread("孤岛中的rt1线程");
		RubbishThread rt2 = new RubbishThread("孤岛中的rt2线程");
		RubbishThread rt3 = new RubbishThread("孤岛中的rt3线程");
		rt1.brother = rt2;
		rt2.brother = rt3;
		rt3.brother = rt1;
		
		rt1.start();
		
		rt1= null;
		rt2= null;
		rt3= null;
		
		System.out.println("===============================");
		System.gc();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("+++++++++++++++++++++++++++++++++++");
		System.gc();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
}
