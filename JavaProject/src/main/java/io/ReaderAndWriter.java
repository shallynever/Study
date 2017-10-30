package io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/*字符流使用了缓存区，在程序的最后必须进行流的关闭或者缓存强制刷新操作,这样才可以将内容读取或写入到指定的存储结构中*/

public class ReaderAndWriter {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WriterDemo();
		ReaderDemo();
	}
	/*从文件中读取内容*/
	public static void ReaderDemo() throws IOException {
		// TODO Auto-generated method stub
		/*1.使用File类找到要写入数据的文件*/
		File file = new File("F:"+File.separator+"test.txt");
		/*2.通过子类实例化父类对象，获得输入流对象*/
		Reader in = new FileReader(file);
		/*3.进行读取操作*/
		int len = 0;
		char[] c = new char[1024];
		int temp = 0;
		while((temp = in.read()) != -1){
			c[len] = (char) temp;
			len++;
		}
		in.close();
		System.out.println(new String(c,0,len));
	}
	
	/*向文件中写入数据*/
	public static void WriterDemo() throws IOException {
		// TODO Auto-generated method stub
		/*1.使用File类找到要写入数据的文件*/
		File file = new File("F:"+File.separator+"test.txt");
		/*2.通过子类实例化父类对象，获得输出流对象*/
		Writer out = new FileWriter(file, true);   //用这个构造函数，可以向文件中追加新内容，true表示可以，false表示不可以
		/*3.进行写入操作*/
		String str = "\r\nMy Name is Hello World !!";
		out.write(str);
		out.close();	
	}

}
