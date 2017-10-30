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
		
		
		c1 = Class.forName("reflection.X");//常用的静态方法
		c2 = new X().getClass();
		c3 = X.class;
		
		X x = (X) c1.newInstance();//使用这种方法实例化，被实例化对象类中必须存在无参构造方法
		x.print();
		
		
		System.out.println(c1.getName());
		System.out.println(c2.getName());
		System.out.println(c3.getName());
		
		
		
	}
	

}
