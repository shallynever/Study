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
		System.out.println(this.name+"�����Ϊ�����������ռ�������");
	}
}

public class IsLandDemo {
	public static void main(String[] args){
		Rubbish r1 = new Rubbish("�µ��е�r1");
		Rubbish r2 = new Rubbish("�µ��е�r2");
		Rubbish r3 = new Rubbish("�µ��е�r3");
		r1.brother = r2;
		r2.brother = r3;
		r3.brother = r1;
		//�ж���������ϵ���γɹµ�
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
