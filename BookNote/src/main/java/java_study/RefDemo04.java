package java_study;
class Demo{						// ����Demo��
	private int temp  = 30 ;	// ����temp���Բ���װ
	public void fun(Demo d2){	// ���ձ��������
		d2.temp = 50 ;			// ֱ��ͨ��������ñ����˽������
	}
	public int getTemp(){		// getter
		return temp ;
	}
	public void setTemp(int t){	// setter
		temp = t ;
	}
};
public class RefDemo04{
	public static void main(String args[]){
		Demo d1 = new Demo() ;	// ʵ����Demo����
		d1.setTemp(2) ;		// ֻ��ͨ��setter�����޸�����
		d1.fun(d1) ;			// �˴���Demo�Ķ��󴫻ص��Լ�������
		System.out.println("temp = " + d1.getTemp()) ;
	}
};