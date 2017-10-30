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
		System.out.println(name+"��ʼִ��");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name+"ִ�н���");
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.out.println(name+"��Ϊ������������");
	}
}
public class ThreadRubbishDemo {
	public static void main(String[] args){
		RubbishThread rt1 = new RubbishThread("�µ��е�rt1�߳�");
		RubbishThread rt2 = new RubbishThread("�µ��е�rt2�߳�");
		RubbishThread rt3 = new RubbishThread("�µ��е�rt3�߳�");
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
