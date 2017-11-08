package io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 * @author 天启 zhouj@dtdream.com
 * @since
 */
public class BufferedReaderTest {

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

	public static void main(String[] args) throws IOException {
		String path = "F:"+ File.separator+"1.jpg";
//		long before = System.currentTimeMillis();
//		InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(path));
//		char[] str = new char[500000];
//
//		inputStreamReader.read(str);
//		System.out.println(String.valueOf(str));
//		System.out.println(System.currentTimeMillis()-before);

		char[] str = new char[500000];
		long before = System.currentTimeMillis();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(path),500000);
		String temp;
		bufferedReader.read(str);
		System.out.println(String.valueOf(str));
		System.out.println(System.currentTimeMillis()-before);

		// todo BufferedReader和InputStreamReader性能比较

	}

}
