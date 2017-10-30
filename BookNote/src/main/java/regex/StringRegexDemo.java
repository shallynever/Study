package regex;

public class StringRegexDemo {
	public static void main(String[] args){
		String patternStr = "\\d{4}-\\d{2}-\\d{2}";
		String str = "1234-45-67";
		if(str.matches(patternStr)){
			System.out.println("·ûºÏ¹æÔò");
		}
	}
}
