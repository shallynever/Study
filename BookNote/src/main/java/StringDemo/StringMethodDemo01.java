package StringDemo;

public class StringMethodDemo01 {
//	private int s;

	public static void main(String[] args) {
		 StringMethodDemo();
		// StringMethodDemo2();
		// String s1 = new String("abc");
		String s1 = "ababab";
		String s2 = s1.intern();// 从常量池中获取数据

		System.out.println(s2);
		System.out.println(s1 == s2);
	}

	
	private static void StringMethodDemo() {
		String s = "asdjakdjak";
		System.out.println("num:" + s.length());
		System.out.println(s.indexOf('d'));
		System.out.println(s.charAt(2));
		System.out.println(s.indexOf("ja", 4));
		System.out.println(s.lastIndexOf("ja"));
		System.out.println(s.substring(2));
		System.out.println(s.substring(2, 4));// String substring(int
												// beginIndex, int
												// endIndex)//包含begin 不包含end 。

	}

}
