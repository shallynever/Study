package TestDemo;

public class StringDemo {
	public static final String MESSAGE = "taobao";
	public static int d;
	public void testStatic(){
		System.out.println(d);
	} 
	public static void main(String[] args){
		String a = "tao"+"bao";
		String b = "tao";
		String c = "bao";
		System.out.println(a==MESSAGE);
		System.out.println((b+c)==MESSAGE);
		Boolean flag = false;
		if (flag = true)
		{
		    System.out.println("true");
		}
		else
		{
		    System.out.println("false");
		}
		
		int x = 5;
		int y =10;
		System.out.println(x+(~y));
		System.out.println(~y);
		char foo='жа';
		System.out.println(foo);
	}
}
