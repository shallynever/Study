package CrackingtheCodingInterview;

public class ReverseStringDemo {
	public static String reverseString(String iniString) {
		
		
		int len = iniString.length();
		String result = "";
		
		for(int i=0;i<len;i++){
			String temp = iniString.substring(len-(i+1), len-i);
			result = result+temp;			
		}	
		return result;       
    }
	public static void main(String[] args){
		System.out.println(reverseString("zhoujing"));
	}
}
