package regex;

import java.util.regex.Pattern;

public class RegexDemo {
	public static void main(String[] args){
		String str = "0123456789";
		String regex = "[0-9]+";
		if(Pattern.compile(regex).matcher(str).matches()){
			System.out.println("�����������");			
		}else{
			System.out.println("�������������");			
		}
	}
}
