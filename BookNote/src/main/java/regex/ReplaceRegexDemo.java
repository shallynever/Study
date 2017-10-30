package regex;

public class ReplaceRegexDemo {
	public static void main(String[] args){
		String patternStr = "\\b\\d*\\.\\d{3,}\\b";
		String str = "123.4 123.45 123.456 123.4567 123.45678";
		System.out.println(str.replaceAll(patternStr, "ERROR"));
		System.out.println(str.replaceFirst(patternStr, "ERROR"));
	}
}
