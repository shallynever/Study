package designpattern;

/* 顾名思义，装饰模式就是给一个对象增加一些新的功能，而且是动态的，
 * 要求装饰对象和被装饰对象实现同一个接口或继承同一个父类，装饰对象持有被装饰对象
 * 的实例
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
	
	System.out.println("before decorator");//添加的功能
	sourceone.method();
	System.out.println("after decorator");//添加的功能
	
	}
	
}
public class DecoratorTest {

	public static void main(String[] args) {
		SourceableOne sourceone = new SourceOne();
		SourceableOne obj = new Decorator(sourceone);
		obj.method();
	}

}

/*装饰器模式的应用场景：

1、需要扩展一个类的功能。

2、动态的为一个对象增加功能，而且还能动态撤销。（继承不能做到这一点，继承的功能是静态的，不能动态增删。）

缺点：产生过多相似的对象，不易排错！*/
