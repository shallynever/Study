package TestDemo;


public class ClassA {
	
	{
		System.out.println("父类构造代码块1");
	}
	
	{
		System.out.println("父类构造代码块2");
	}

	static 
	{
		System.out.println("父类静态代码块1");
	}
	
	public ClassA() {
		System.out.println("父类无参构造函数");
	}
	
	public ClassA(String str)
	{
		System.out.println("父类有参构造函数" + str);
	}
	
}

