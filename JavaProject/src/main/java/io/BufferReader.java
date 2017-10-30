package io;

/*主要想介绍一下，键盘标准输入的实现及理解 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BufferReader {

	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));  //标准键盘输入
		BufferedReader buftxt = new BufferedReader(
				new FileReader(new File("F:"+File.separator+"test.txt")));		
		String str = null;
		StringBuffer sb = new StringBuffer();
		System.out.print("请输入内容：");
		
		str = buf.readLine();
		
		System.out.println("输入的内容为："+str);	
		while((str=buftxt.readLine())!= null){
			sb.append(str+"\r\n");
		}
		
		System.out.println(sb.toString());
		
		buftxt.close();
		buf.close();

	}

}
