package designpattern;

/* ����˼�壬װ��ģʽ���Ǹ�һ����������һЩ�µĹ��ܣ������Ƕ�̬�ģ�
 * Ҫ��װ�ζ���ͱ�װ�ζ���ʵ��ͬһ���ӿڻ�̳�ͬһ�����࣬װ�ζ�����б�װ�ζ���
 * ��ʵ��
 * 
 */


interface SourceableOne{
	public void method();
}

class SourceOne implements SourceableOne{

	@Override
	public void method() {
		System.out.println("this is the original method");
	}
	
}

class Decorator implements SourceableOne{

	
	private SourceableOne sourceone;
	
	public Decorator(SourceableOne sourceone) {
		super();
		this.sourceone = sourceone;
	}
	
	@Override
	public void method() {
	
	System.out.println("before decorator");//��ӵĹ���
	sourceone.method();
	System.out.println("after decorator");//��ӵĹ���
	
	}
	
}
public class DecoratorTest {

	public static void main(String[] args) {
		SourceableOne sourceone = new SourceOne();
		SourceableOne obj = new Decorator(sourceone);
		obj.method();
	}

}

/*װ����ģʽ��Ӧ�ó�����

1����Ҫ��չһ����Ĺ��ܡ�

2����̬��Ϊһ���������ӹ��ܣ����һ��ܶ�̬���������̳в���������һ�㣬�̳еĹ����Ǿ�̬�ģ����ܶ�̬��ɾ����

ȱ�㣺�����������ƵĶ��󣬲����Ŵ�*/
