package chapter5;

import static tools.Print.print;


/*��̬��ʼ��������ļ���ʱ�Ż���еģ���ʼ����˳�����Ⱦ�̬���󣬶����ǡ��Ǿ�̬������

����Ĵ������̣�������һ����ΪDog���ࣺ
	1. ��ʹû����ʾ��ʹ��static�ؼ��֣�������ʵ����Ҳ�Ǿ�̬��������ˣ����״δ�������ΪDog�Ķ���ʱ
	�����������Կ��ɾ�̬������������Dog��ľ�̬��������̬���״α�����ʱ��Java���������������·����
	  �Զ�λDog.class�ļ���
	2. Ȼ������Dog.class���йؾ�̬��ʼ�������ж�������ִ�С���ˣ���̬��ʼ��ֻ��Class�����״μ�
	  �ص�ʱ�����һ�Ρ�
	3. ����new Dog()���������ʱ�����Ƚ��ڶ��ڴ���ΪDog��������㹻�Ĵ洢�ռ䡣
	4. ��鴢��ռ�ᱻ���㣬����Զ��Ľ�Dog�����е����г�Ա�����ֵ��
	5. ִ�����г������ֶζ��崦�ĳ�ʼ������
	6. ִ�й�������
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
