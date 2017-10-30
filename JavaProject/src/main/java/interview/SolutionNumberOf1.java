package interview;

/*输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。*/

public class SolutionNumberOf1 {

	public static void main(String[] args) {
		
//		System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
//		System.out.println(Integer.toBinaryString(Integer.MAX_VALUE).length());
		System.out.println(NumberOf1(-9));
//		1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
	}
	public static int NumberOf1(int n) {
		
		String str = Integer.toBinaryString(n);
		System.out.println(str);
		int count = 0;
		char[] ch = str.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if(ch[i] == '1')
				count++;
		}
		
		return count;	
	}
			
	

}
