package TestDemo;


public class ConstructorExtendDemo extends ClassA{

	/**
	 * 继承父类情况下
	 * 创建对象时相关代码执行顺序，静态代码块 > 构造代码块 > 成员变量 > 构造方法
	 * 同一部分代码块则按照位置先后顺序来执行
	 * @author hp
	 *
	 */
	private ClassA classTestA = new ClassA();
	
	{
		System.out.println("子类构造代码块1");
	}
	
	static 
	{
		System.out.println("子类静态代码块1");
	}
	private static ClassA classTestB = new ClassA("classTestB");
	
	{
		System.out.println("子类构造代码块2");
	}
	
	static 
	{
		System.out.println("子类静态代码块2");
	}
	
	public ConstructorExtendDemo(String str) {
		super(str);
		System.out.println(" 子类有参构造函数");
	}
	
	public static void main(String[] args)
	{
		ConstructorExtendDemo demo = new ConstructorExtendDemo("childClass");
	}
}
