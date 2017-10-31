package io;

import org.junit.Test;

import java.io.File;
import java.io.PrintStream;
import java.io.PrintWriter;
/**
 * @author ���� zhouj@dtdream.com
 * @since
 */
public class PrintStreamTest {

	/*
	* ������IO����,��ӡ���������Ϣ������,��Ҫ�����ֽڴ�ӡ��(PrintStream)���ַ���ӡ��(PrintWriter)
	* ��ӡ���ṩ�˷ǳ�����Ĵ�ӡ����,���Դ�ӡ�κ��������͡�
	* ����Ĵ�ӡ�������ݵı�ʾ��ʽ�����Ĵ�ӡ�������Ա�֤��ֵ�ı�����ʽ���䡣д����ʲô���ӣ�Ŀ�ĵؾ���ʲô����
	* */

	String filePath = "F:"+ File.separator+ "io" +File.separator+"PrintStream"+File.separator+"test.txt";
	File file = new File(filePath);

	@Test
	public void printStream() throws Exception {
		PrintStream ps = new PrintStream(file);
		String name = "�ܾ�";
		int age = 25;
		float score = 78.05f;
		char sex = 'M';
		ps.printf("������%s;���䣺%d;�ɼ���%f;�Ա�%c",name,age,score,sex);
		ps.close();
	}

	@Test
	public void printWriter() throws Exception {
		PrintWriter ps = new PrintWriter(file);
		ps.print("zhejianggongshangdaxue");
		ps.close();

	}

}
