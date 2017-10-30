package reflection;

class X{
	public void print(){
		System.out.println("nihao");
	}
}

public class GetClassDemo1 {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> c1 = null;
		Class<?> c2 = null;
		Class<?> c3 = null;
		
		
		c1 = Class.forName("reflection.X");//���õľ�̬����
		c2 = new X().getClass();
		c3 = X.class;
		
		X x = (X) c1.newInstance();//ʹ�����ַ���ʵ��������ʵ�����������б�������޲ι��췽��
		x.print();
		
		
		System.out.println(c1.getName());
		System.out.println(c2.getName());
		System.out.println(c3.getName());
		
		
		
	}
	

}
