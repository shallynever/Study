package TestDemo;


public class ConstructorExtendDemo extends ClassA{

	/**
	 * �̳и��������
	 * ��������ʱ��ش���ִ��˳�򣬾�̬����� > �������� > ��Ա���� > ���췽��
	 * ͬһ���ִ��������λ���Ⱥ�˳����ִ��
	 * @author hp
	 *
	 */
	private ClassA classTestA = new ClassA();
	
	{
		System.out.println("���๹������1");
	}
	
	static 
	{
		System.out.println("���ྲ̬�����1");
	}
	private static ClassA classTestB = new ClassA("classTestB");
	
	{
		System.out.println("���๹������2");
	}
	
	static 
	{
		System.out.println("���ྲ̬�����2");
	}
	
	public ConstructorExtendDemo(String str) {
		super(str);
		System.out.println(" �����вι��캯��");
	}
	
	public static void main(String[] args)
	{
		ConstructorExtendDemo demo = new ConstructorExtendDemo("childClass");
	}
}
