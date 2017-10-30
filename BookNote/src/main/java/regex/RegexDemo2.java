package regex;

import java.util.regex.Pattern;

public class RegexDemo2 {

	public static void main(String[] args) {
		String str = "A21SADA121321WRUIPA9897FAHQWOPWQIA232";
		String regex = "\\d+";
		Pattern p = Pattern.compile(regex);
		String s[] = p.split(str);
		for (String st : s) {
			System.out.println(st+"\t");
		}
	}

}
