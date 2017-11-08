package chapter2;

import java.util.Date;

/**
 * @author jing
 * @serial 在java中打印一个类中的没有初始化的成员变量，只能通过构造函数实现
 */
public class E2_1 {
	int num;
	char ch;
	
	public E2_1() {
		System.out.println("num="+num);
		System.out.println("ch="+ch);
	}
	public static void main(String[] args){
		System.out.println("ni hao");
		System.out.println(new Date());

		//System.getProperties().list(System.out);
		//System.out.println(System.getProperty("user.name"));
		new E2_1();
		
		
		
	}
}
