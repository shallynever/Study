package TestDemo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

	public static void main(String[] args) {

        String regexUrl1 = "("
        		+ "(http://|ftp://|https://)"
        		+ "([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})"
        		+ "|"
        		+ "([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})"
        		+ "){0,1}[^\\u4e00-\\u9fa5\\\\s]*?\\\\.(com|net|cn|me|tw|fr)[^\\u4e00-\\u9fa5\\\\s]*";
        
        
        
        
		
		String regexUrl = "((http|ftp|https)://)"+"(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})"+"|"+"([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))"+"(:[0-9]{1,4})*";
	}
}
