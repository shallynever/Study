package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo1 {

	public static void main(String[] args) {
		String str = "2015-11-20";
		String regex = "\\d{4}-\\d{2}-\\d{2}";  //������֤����
		Pattern p = Pattern.compile(regex);		//ʵ����Pattern��
		Matcher m = p.matcher(str);				//��֤�ַ��������Ƿ�Ϸ�
		if(m.matches()){						//ʹ��������֤
			System.out.println("���ڸ�ʽ�Ϸ�");
		}else{
			System.out.println("���ڸ�ʽ���Ϸ�");
		}

	}
}