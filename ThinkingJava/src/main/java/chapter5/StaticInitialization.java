package chapter5;

import static tools.Print.print;


/*静态初始化是在类的加载时才会进行的，初始化的顺序是先静态对象，而后是“非静态”对象

对象的创建过程，假设有一个名为Dog的类：
	1. 即使没有显示的使用static关键字，构造器实际上也是静态方法。因此，当首次创建类型为Dog的对象时
	（构造器可以看成静态方法），或者Dog类的静态方法、静态域首次被访问时，Java解释器必须查找类路径，
	  以定位Dog.class文件。
	2. 然后载入Dog.class，有关静态初始化的所有动作都会执行。因此，静态初始化只在Class对象首次加
	  载的时候进行一次。
	3. 当用new Dog()创建对象的时候，首先将在堆内存上为Dog对象分配足够的存储空间。
	4. 这块储存空间会被清零，这就自动的将Dog对象中的所有成员赋予初值。
	5. 执行所有出现于字段定义处的初始化动作
	6. 执行构造器。
*/


class Bowl
{
	public Bowl(int marker) {
		print("Bowl("+marker+")");
	}
	void f1(int marker){
		print("f1("+marker+")");
	}
}

class Table
{
	static Bowl b1 = new Bowl(1);
	public Table() {
		print("Table()");
		b2.f1(1);
	}
	void f2(int marker){
		print("f2("+marker+")");
	}
	static Bowl b2 = new Bowl(2);
}

class Cupboard
{
	Bowl b3 = new Bowl(3);
	static Bowl b4 = new Bowl(4);
	public Cupboard() {
		print("Cupboard");
		b4.f1(2);
	}
	void f3(int marker){
		print("f3("+marker+")");
	}
	static Bowl b5 = new Bowl(5);
}


public class StaticInitialization {

	public static void main(String[] args) {
		print("Creating new Cupboard in main");
		new Cupboard();		
		print("Creating new Cupboard in main");
		new Cupboard();
//		t.f2(1);
		cp.f3(1);
		
	}
//	static Table t = new Table();
	static Cupboard cp = new Cupboard();
}
