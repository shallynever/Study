package chapter5;

import static tools.Print.print;

/*������ڲ�������������Ⱥ�˳������˳�ʼ����˳��
 * ��ʹ���������ɢ�ڷ�������֮�䣬������Ȼ������
 * �η������������캯����������֮ǰ�õ���ʼ����*/


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
