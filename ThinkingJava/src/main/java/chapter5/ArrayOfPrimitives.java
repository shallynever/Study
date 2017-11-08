package chapter5;

import static tools.Print.print;

/*
 * 在定义一个数组时，编译器不允许指定数组大小
 * 在Java中可以将一个数组赋值给另一个数组，而在这个动作执行后真正做的只是复制了一个引用。
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
