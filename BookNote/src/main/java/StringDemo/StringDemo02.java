package StringDemo;

public class StringDemo02 {

	public static void main(String[] args) {
		StringConstructorDemo();
		StringConstructorDemo2();
		

	}

	
	private static void StringConstructorDemo2() {
		char[] arr2 = {'a','b','c','d'};
		String s2 = new String(arr2,1,3);//String(char[] value, int offset, int count) 
		System.out.println(s2);
		
	}


	private static void StringConstructorDemo() {
		
		byte[] arr = {65,66,67,68};
		String s = new String(arr);
		System.out.println(s);
		
	}

}
