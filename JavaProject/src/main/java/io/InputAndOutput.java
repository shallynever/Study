package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*字节流不使用缓存区，在程序的最后可以不进行流的关闭操作,也能将内容读取或写入到指定的存储结构中*/

public class InputAndOutput {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		inputDemo1();
		inputDemo2();
		outputDemo();

	}
	/*OutputStream操作：向文件中写入数据*/
	public static void outputDemo() throws IOException {
		// TODO Auto-generated method stub
		/*1. 通过File类获得要写入数据的文件*/
		File file = new File("F:"+File.separator+"test.txt");
		/*2.通过子类实例化父类对象，得到输出流对象*/
		OutputStream out = new FileOutputStream(file,true);  //用这个构造函数，可以向文件中追加新内容，true表示可以，false表示不可以
		/*3.进行写入操作*/
		String str = "\r\n Hello World!!";    //准备一个被写入的字符串,其中\r\n是进行换行操作的
		byte[] b = str.getBytes();    //将字符串转换成字节数组，因为OutputStream的write方法只能对字节操作
		
		/*写入操作一：直接将整个数组写入*/
		out.write(b);   
		/*写入操作二：一个字节一个字节的写入*/
		for (int i = 0; i < b.length; i++) {
			out.write(b[i]);
		}		
		out.close();	
	}

	/*InputStream操作：读取文件中的数据*/
	/*操作一、知道读取内容大小的情况下*/
	public static void inputDemo1() throws IOException {
		// TODO Auto-generated method stub
		/*1.通过File类找到要读取的文件*/
		File file = new File("F:"+File.separator+"test.txt");
		/*2.获取读取文件的大小*/
		long fileSize = file.length();
		/*3.通过子类实例化父类对象，得到输入流对象*/
		InputStream in = new FileInputStream(file);
		/*4.初始化存储数据的字节数组*/
		byte[] b = new byte[(int) fileSize];  //这里根据读取文件的大小来开辟存储数据的数组，这样可以减少空间的浪费
		/*5.将数据读取到指定数组*/
		in.read(b);
		/*6.将读取到的字节数据转换成字符串*/
		String str = new String(b);
		System.out.println(str);
		in.close();
	}
	
	/*操作二、在不知道读取内容大小的情况下*/
	public static void inputDemo2() throws IOException {
		// TODO Auto-generated method stub
		/*1.通过File类找到要读取的文件*/
		File file = new File("F:"+File.separator+"test.txt");
		/*2.通过子类实例化父类对象，得到输入流对象*/
		InputStream in = new FileInputStream(file);
		/*3.初始化存储数据的相关变量*/
		int len = 0;        //记录读取的数据个数
		byte[] b = new byte[1024];  //读取到数据存储在这个数组中
		int temp = 0;     //临时存储读取的每一个数据
		/*4.一个一个的读取文件数据，在这里我们不知道读取内容的大小，
		 * 故只能通过判断是否读取到文件尾部，即 read()方法的返
		 * 回值是否为-1*/
		while((temp=in.read()) !=-1){
			b[len] = (byte) temp;
			len++;
		}
		in.close();		
		/*5.将读取到的字节数据转换成字符串*/
		String str = new String(b,0,len);
		System.out.println(str);
		
		
		
		
		
	}

}
