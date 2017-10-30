package io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/*�ַ���ʹ���˻��������ڳ����������������Ĺرջ��߻���ǿ��ˢ�²���,�����ſ��Խ����ݶ�ȡ��д�뵽ָ���Ĵ洢�ṹ��*/

public class ReaderAndWriter {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WriterDemo();
		ReaderDemo();
	}
	/*���ļ��ж�ȡ����*/
	public static void ReaderDemo() throws IOException {
		// TODO Auto-generated method stub
		/*1.ʹ��File���ҵ�Ҫд�����ݵ��ļ�*/
		File file = new File("F:"+File.separator+"test.txt");
		/*2.ͨ������ʵ����������󣬻������������*/
		Reader in = new FileReader(file);
		/*3.���ж�ȡ����*/
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
	
	/*���ļ���д������*/
	public static void WriterDemo() throws IOException {
		// TODO Auto-generated method stub
		/*1.ʹ��File���ҵ�Ҫд�����ݵ��ļ�*/
		File file = new File("F:"+File.separator+"test.txt");
		/*2.ͨ������ʵ����������󣬻�����������*/
		Writer out = new FileWriter(file, true);   //��������캯�����������ļ���׷�������ݣ�true��ʾ���ԣ�false��ʾ������
		/*3.����д�����*/
		String str = "\r\nMy Name is Hello World !!";
		out.write(str);
		out.close();	
	}

}
