package io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
/**
 * @author 天启 zhouj@dtdream.com
 * @since
 */
public class SystemIOTest {

	/*
	* System.in是一个典型的连接控制台程序和键盘输入的InputStream流。
	* 通常当数据通过命令行参数或者配置文件传递给命令行Java程序的时候，System.in并不是很常用。
	* 图形界面程序通过界面传递参数给程序，这是一块单独的Java IO输入机制。
	*
	* System.out是一个PrintStream流。
	* System.out一般会把你写到其中的数据输出到控制台上。
	* System.out通常仅用在类似命令行工具的控制台程序上。
	* System.out也经常用于打印程序的调试信息(尽管它可能并不是获取程序调试信息的最佳方式)。
	*
	* System.err是一个PrintStream流。
	* System.err与System.out的运行方式类似，但它更多的是用于打印错误文本。
	* 一些类似Eclipse的程序，为了让错误信息更加显眼，会将错误信息以红色文本的形式通过System.err输出到控制台上。
	*
	* System.out 和System.err 的区别：
	* System.out和System.err都是PrintStream的实例化对象，而且通过代码可以发现，两者都可以输出错误信息，
	* 但是一般来讲System.out是将信息显示给用户看，是正常的信息显示，而System.err的正好相反是不希望用户看到的，
	* 会直接在后台打印，是专门显示错误的。
	* 一般来讲，如果要输出错误信息的时候最好不要使用System.out而是直接使用System.err 这一点只能从其概念上划分。
	* 以上的代码也可以使用System.out输出，只能从概念上划分。
	* 切记：System.out是希望用户看到的，而System.err是不希望用户看到的。
	*
	* */


	String filePath = "F:"+ File.separator+ "io" +File.separator+"test.txt";
	File file = new File(filePath);

	@Test
	public void systemIn() {
		//System.in的输入重定向
		try {
			System.setIn(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
		}
		InputStream input = System.in;
		StringBuffer buf = new StringBuffer();
		byte[] b = new  byte[1024];
		System.out.println("请输入类容：");

		int len = 0;
		try {
			len = input.read(b);
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		* 以上的操作存在如下问题
		* 问题一：指定了输入数据的长度，如果现在输入的数据超过了长度范围，只能输入部分的数据。
		* 问题二：如果byte数组是奇数的话，则还可能出现中文乱码的情况，因为一个字符是两个字节。
		* */

		int temp;
		try {
			while((temp = input.read())!=-1){
                char c = (char)temp;
                if(c=='\n'){
                    break;
                }
                buf.append(c);
            }
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		* 以上的操作存在如下问题
		* 输入中文就会乱码,因为每读取一个字节就将其转为字符,
		* 字母和数字都是占1个字节 可以正常显示。
		* 但是如果是中文的话，就相当于每读取到一个字节就是半个字符就进行转化，所以导致乱码的错误。
		*
		* 键盘输入的标准方式：
		* 最好的输出方式是将全部输入的数据暂时存放在一块内存之上，
		* 之后一次性的从内存中读取数据，这样所有数据就整体只读了一次，则不会造成乱码，而且也不会受到长度的限制。
		* 如果要想实现以上的功能，则只能通过IO中的下一个类 BufferedReader类完成。
		* */
		System.out.println("输入类容为："+new String(b,0,len));
		try {
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void systemOut() {
		try {
			// System.out重定向
			System.setOut(new PrintStream(new FileOutputStream(file,true)));
			OutputStream out  = System.out;
			out.write("中国共产党第十九次全国代表大会".getBytes());
			out.close();
		} catch (IOException e) {
			System.err.println(e);
		}

	}

	@Test
	public void systemErr() throws FileNotFoundException {
		//System.err输出重定向
		System.setErr(new PrintStream(new FileOutputStream(file,true)));
		String str  = "hello";
		System.err.println(str);





	}

	public static void main(String[] args) throws IOException {
		InputStream inputStream = System.in;
		byte[] bytes = new byte[1024];
		int temp;
		int count = 0;
		while (-1 != (temp = inputStream.read())){
			bytes[count] = (byte) temp;
			char c = (char) temp;
			if (c == '\n')
				break;
			count++;
		}
//		System.out.println(new String(bytes));

		System.err.print("jjjj");



	}

}
