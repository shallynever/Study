package chapter2;

import java.util.Date;

/**
 * @author jing
 * @serial ��java�д�ӡһ�����е�û�г�ʼ���ĳ�Ա������ֻ��ͨ�����캯��ʵ��
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
