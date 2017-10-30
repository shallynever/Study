package memoryManagement;

class Rubbish{
	Rubbish brother;
	String name;
	public Rubbish(){}
	public Rubbish(String name){
		this.name = name;
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.out.println(this.name+"对象称为垃圾，并被收集！！！");
	}
}

public class IsLandDemo {
	public static void main(String[] args){
		Rubbish r1 = new Rubbish("孤岛中的r1");
		Rubbish r2 = new Rubbish("孤岛中的r2");
		Rubbish r3 = new Rubbish("孤岛中的r3");
		r1.brother = r2;
		r2.brother = r3;
		r3.brother = r1;
		//切断与外界的联系，形成孤岛
		r1 = null;
		r2 = null;
		r3 = null;
		System.gc();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
