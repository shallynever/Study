package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo4 {

	public static void main(String[] args){
		String patternStr = "(0?[0-9]|1[0-2]):([0-5]\\d)([a|p]m)";
		String matcherStr = "现在时刻为 10:51pm, 营业时间为: 每天8:00am至5:30pm!!!";
		 
		Pattern p = Pattern.compile(patternStr);
		Matcher m = p.matcher(matcherStr);
		
		int groupnumber = m.groupCount();
		System.out.println(groupnumber);
			
		StringBuffer sb = new StringBuffer();
		int count = 0;
		System.out.println("初始化字符串为"+matcherStr);
		while(m.find()){
			System.out.println(m.group(0)); //组零始终代表整个表达式
			StringBuffer temp = new StringBuffer();
			if(m.group(3).equals("am")){
				temp.append(m.group(1));
				temp.append(":");
				temp.append(m.group(2));
			}
			else{
				int time = Integer.parseInt(m.group(1));
				time = time + 12;
				temp.append(time+":"+m.group(2));
			}
			m.appendReplacement(sb, temp.toString());
			System.out.println("["+(++count)+"]将"+m.group(0)+"替换为："+temp.toString());
		}
		m.appendTail(sb);
		System.out.println("最终结果为："+sb.toString());
	}
	
}
