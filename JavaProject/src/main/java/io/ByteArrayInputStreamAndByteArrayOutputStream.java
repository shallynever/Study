package io;

/* 
 * 作用：
 * 		ByteArrayInputStream是将数据写入到内存输入流中，通过构造函数实现的，而用read()方法来读取内存输入流的数据
 * 		ByteArrayOutputStream是将数据写入到内存输出流，通过write()方法实现的
 * 		
 * 		我们可以这样理解上面的过程，将程序和内存分为两层。
 * 		ByteArrayInputStream就是把程序这一层的数据保存进内存，而通过read()将数据读取出来
 * 		而ByteArrayOutputStream就是把它当做是内存的中的一个缓冲区，向其中写入数据，缓冲区自动增长，
 * 		当写入完成时可以从中提取数据。通过toByteArray()和toString()实现。
 * 
 * 
 * */



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayInputStreamAndByteArrayOutputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "周敬zhejianggongshang wangyi";
		
		//ByteArrayInputStream内存输入流，将数据写入到内存中
		ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes());
		
		//ByteArrayOutputStream内存输出流，个人觉得它就是一个缓存器，从内存读取到的数据写入到在它的内部缓存区中
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		int temp = 0;
		
		while((temp=in.read())!= -1){	//将内存中的数据读取出来，保存在临时变量temp中					
			out.write(temp);  //将获得到的数据写入到内存输出流对象out中
		}
		
		try {
			in.close();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(out.toString());
		
	}

}
