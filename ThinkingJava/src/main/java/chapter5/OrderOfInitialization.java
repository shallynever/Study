package chapter5;

import static tools.Print.print;

/*在类的内部，变量定义的先后顺序决定了初始化的顺序。
 * 即使变量定义分散在方法定义之间，它们仍然会在任
 * 何方法（包括构造函数）被调用之前得到初始化。*/


class Window
{
	Window(int marker){
		print("window("+marker+")");
	}
}

class House
{
	Window w1 = new Window(1);
	House(){
		print("House");
		w3 = new Window(33);
	}
	Window w2 = new Window(2);
	void f(){
		print("f()");
	}
	Window w3 = new Window(3);
}


public class OrderOfInitialization {

	public static void main(String[] args) {
		House house = new House();
		house.f();
	}

}
