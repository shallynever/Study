package chapter5;

import static tools.Print.print;

/*
 * �ڶ���һ������ʱ��������������ָ�������С
 * ��Java�п��Խ�һ�����鸳ֵ����һ�����飬�����������ִ�к���������ֻ�Ǹ�����һ�����á�
 * 
 * 
 * */



public class ArrayOfPrimitives {

	public static void main(String[] args) {
		int[]  a1 = {1,2,3,4,5,6};
		int[] a2;
		a2 = a1;
		for (int i = 0; i < a2.length; i++) {
			a2[i] += 1;
		}
		for (int i = 0; i < a1.length; i++) {
			print("a1["+i+"]="+a1[i]);
		}
	}

}
