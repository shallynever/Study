package regex;

public class SplitRegexDemo {
	public static void main(String[] args){
		String patternStr = ";|,";
		String str = "zhejiang;gongshangdaxue,xindianxueyuan;zhoujing,14";
		System.out.println(str);
		for (String arrayStr : str.split(patternStr)) {
			System.out.println(arrayStr);
		}
		for (String arrayStr : str.split(patternStr,3)) {
			System.out.println(arrayStr);
		}
		for (String arrayStr : str.split(patternStr,-2)) {
			System.out.println(arrayStr);
		}
		for (String arrayStr : str.split(patternStr,0)) {
			System.out.println(arrayStr);
		}	
	}
}	
