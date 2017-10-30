package io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderDemo {

	@Test
	public void bufferedReader() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer stringBuffer = new StringBuffer();
		System.out.println("请输入内容：");
//		stringBuffer.append(bufferedReader.readLine());
		String tempStr;
		while((tempStr = bufferedReader.readLine())!= null){
			stringBuffer.append(tempStr+"\r\n");
		}
		System.out.println("输入的内容为："+stringBuffer);
	}

}
