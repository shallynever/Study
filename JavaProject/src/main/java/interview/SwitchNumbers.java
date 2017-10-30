package interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SwitchNumbers {
	
	public static void main(String[] args) throws Exception, IOException
	{
		int num = 0;
		int base = 0;
		BufferedReader buf  = null;
		System.out.print("��������Ҫת����ʮ��������:");
		buf = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(buf.readLine());		//Ҫת��������
		System.out.print("��������Ҫת���Ľ���:");
		buf = new BufferedReader(new InputStreamReader(System.in));
		base = Integer.parseInt(buf.readLine());	//��ת��Ϊ�Ľ���
		System.out.println(Switch(num,base));
	}

	public static String Switch(int num,int base) {
		StringBuffer sb = new StringBuffer();
		String all = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";		
		String digths = all.substring(0, base);		//��Ҫת���Ľ�����ĸ��Ӧ��	
		Stack<Character> s = new Stack<Character>();
		while(num != 0)
		{
			s.push(digths.charAt(num%base));
			num/=base;
		}
		while(! s.isEmpty())
		{
			sb.append(s.pop());
		}
		return sb.toString();	
	}
	
	

}
