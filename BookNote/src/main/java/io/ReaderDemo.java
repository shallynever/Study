package io;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class ReaderDemo {

	public static void main(String[] args) throws Exception {
//		ReaderDemo01();
		ReaderDemo02();
	}

	public static void ReaderDemo02() throws Exception {
		File f = new File("F:"+File.separator+"demo.txt");
		Reader reader = new FileReader(f);
		
		int len=0;
		int temp =0;
		char c[] = new char[(int)f.length()];
		while ((temp=reader.read())!= -1) {
			
			c[len]=(char)temp;
			len++;
		}
		reader.close();
		System.out.println(new String(c,0,len));
		System.out.println(len);
		
		
	}

	public static void ReaderDemo01() throws Exception {
		File f = new File("F:"+File.separator+"demo.txt");

	}

}
