package io;

import org.junit.Test;

import java.io.File;
import java.io.PrintStream;
import java.io.PrintWriter;
/**
 * @author 天启 zhouj@dtdream.com
 * @since
 */
public class PrintStreamTest {

	/*
	* 在整个IO包中,打印流是输出信息最方便的类,主要包含字节打印流(PrintStream)和字符打印流(PrintWriter)
	* 打印流提供了非常方便的打印功能,可以打印任何数据类型。
	* 方便的打印各种数据的表示形式。它的打印方法可以保证数值的表现形式不变。写的是什么样子，目的地就是什么样子
	* */

	String filePath = "F:"+ File.separator+ "io" +File.separator+"PrintStream"+File.separator+"test.txt";
	File file = new File(filePath);

	@Test
	public void printStream() throws Exception {
		PrintStream ps = new PrintStream(file);
		String name = "周敬";
		int age = 25;
		float score = 78.05f;
		char sex = 'M';
		ps.printf("姓名：%s;年龄：%d;成绩：%f;性别：%c",name,age,score,sex);
		ps.close();
	}

	@Test
	public void printWriter() throws Exception {
		PrintWriter ps = new PrintWriter(file);
		ps.print("zhejianggongshangdaxue");
		ps.close();

	}

}
