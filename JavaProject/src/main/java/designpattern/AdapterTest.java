package designpattern;


/*
 * ������ģʽ��ĳ����Ľӿ�ת���ɿͻ�����������һ���ӿڱ�ʾ��Ŀ�����������ڽӿڲ�ƥ������ɵ���ļ��������⡣
 * ��Ҫ��Ϊ���ࣺ���������ģʽ�������������ģʽ���ӿڵ�������ģʽ��
 */

/* ���ȣ��������������������ģʽ,����˼����ǣ���һ��Source�࣬ӵ��һ��������������
 * Ŀ��ӿ�ʱTargetable��ͨ��Adapter�࣬��Source�Ĺ�����չ��Targetable
 * ������룺*/
class Source{
	public void method1(){
		System.out.println("this is orignal method");
	}
}
interface Targetable{
	public void method1();
	
	public void method2();
}

class Adapter extends Source implements Targetable{

	@Override
	public void method2() {
		System.out.println("this is the targetable method");
	}
	
}
/*Adapter��̳�Source�࣬ʵ��Targetable�ӿڣ�����Targetable�ӿڵ�ʵ����;�����Source��Ĺ��ܡ�*/

/*
 * �����������ģʽ
 * ����˼·�����������ģʽ��ͬ��ֻ�ǽ�Adapter�����޸ģ���β��̳�Source�࣬
 * ���ǳ���Source���ʵ�����Դﵽ��������Ե����⡣
 * ������һ��һ����ֻ������ķ�����ͬ���ѡ�
 */

class Wrapper implements Targetable{

	
	private Source source;
	
	public Wrapper(Source source) {
		super();
		this.source = source;
	}
	
	@Override
	public void method1() {
		System.out.println("this is the targetable method");
		
	}

	@Override
	public void method2() {
		source.method1();
	}
	
}


/* ������������ģʽ�ǽӿڵ�������ģʽ��
 * �ӿڵ��������������ģ���ʱ����д��һ���ӿ����ж�����󷽷���
 * ������д�ýӿڵ�ʵ����ʱ������ʵ�ָýӿڵ����з�������������ʱ�Ƚ��˷ѣ���Ϊ���������еķ�����
 * ��������Ҫ�ģ���ʱֻ��ҪĳһЩ���˴�Ϊ�˽��������⣬���������˽ӿڵ�������ģʽ��������һ����
 * ���࣬�ó�����ʵ���˸ýӿڣ�ʵ�������еķ����������ǲ���ԭʼ�Ľӿڴ򽻵���ֻ�͸ó�����ȡ����ϵ��
 * ��������дһ���࣬�̳иó����࣬��д������Ҫ�ķ������С�
 * 
 */

interface Sourceable{
	public void method1();
	public void method2();
}

abstract class Wrapper1 implements Sourceable{
	public void method1(){}
	public void method2(){}
}

class SourceSub1 extends Wrapper1{
	public void method1(){
		System.out.println("this sourceable interface first Sub1");
	}
}
class SourceSub2 extends Wrapper1{
	public void method2(){
		System.out.println("this sourceable interface second Sub2");
	}
}

public class AdapterTest {

	public static void main(String[] args) {
		Sourceable source1 = new SourceSub1();
		Sourceable source2 = new SourceSub2();
		
		source1.method1();
		source1.method2();
		
		source2.method1();
		source2.method2();
		
	}

}


/*
 * �ܽ�һ������������ģʽ��Ӧ�ó�����

	���������ģʽ����ϣ����һ����ת����������һ���½ӿڵ���ʱ������ʹ�����������ģʽ��
			        ����һ�����࣬�̳�ԭ�е��࣬ʵ���µĽӿڼ��ɡ�

	�����������ģʽ����ϣ����һ������ת����������һ���½ӿڵĶ���ʱ�����Դ���һ��Wrapper�࣬
			            ����ԭ���һ��ʵ������Wrapper��ķ����У�����ʵ���ķ������С�

	�ӿڵ�������ģʽ������ϣ��ʵ��һ���ӿ������еķ���ʱ�����Դ���һ��������Wrapper��ʵ������
				����������д������ʱ�򣬼̳г����༴�ɡ�				
 */





