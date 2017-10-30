package io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderDemo {


	public static void ExecDemo01() throws Exception {
		int i = 0;
		int j = 0;
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		System.out.println("�������һ�����֣�");
		str = bufr.readLine();//readLine()��������
		i = Integer.parseInt(str);
		
		System.out.println("������ڶ������֣�");
		str = bufr.readLine();
		j = Integer.parseInt(str);
		
		System.out.println(i+j);
	}

	@Test
	public void bufferedReader() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer stringBuffer = new StringBuffer();
		System.out.println("请输入内容：");
		stringBuffer.append(bufferedReader.readLine());
		String tempStr;
		while((tempStr = bufferedReader.readLine())!= null){
			stringBuffer.append(tempStr+"\r\n");
		}
		System.out.println("输入的内容为："+stringBuffer);
	}

}
