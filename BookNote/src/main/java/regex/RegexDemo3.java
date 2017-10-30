package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo3 {

	public static void main(String[] args) {
		String str = "A21SADA121321WRUIPA9897FAHQWOPWQIA232";
		String regex = "\\d+";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		String newString = m.replaceAll("_");
		System.out.println(newString);
	}

}
