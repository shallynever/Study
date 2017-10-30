package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo1 {

	public static void main(String[] args) {
		String str = "2015-11-20";
		String regex = "\\d{4}-\\d{2}-\\d{2}";  //定义验证规则
		Pattern p = Pattern.compile(regex);		//实例化Pattern类
		Matcher m = p.matcher(str);				//验证字符串类容是否合法
		if(m.matches()){						//使用正则验证
			System.out.println("日期格式合法");
		}else{
			System.out.println("日期格式不合法");
		}

	}
}