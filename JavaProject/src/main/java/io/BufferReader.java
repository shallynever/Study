package io;

/*��Ҫ�����һ�£����̱�׼�����ʵ�ּ���� */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BufferReader {

	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));  //��׼��������
		BufferedReader buftxt = new BufferedReader(
				new FileReader(new File("F:"+File.separator+"test.txt")));		
		String str = null;
		StringBuffer sb = new StringBuffer();
		System.out.print("���������ݣ�");
		
		str = buf.readLine();
		
		System.out.println("���������Ϊ��"+str);	
		while((str=buftxt.readLine())!= null){
			sb.append(str+"\r\n");
		}
		
		System.out.println(sb.toString());
		
		buftxt.close();
		buf.close();

	}

}
