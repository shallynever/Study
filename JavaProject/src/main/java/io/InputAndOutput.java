package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*�ֽ�����ʹ�û��������ڳ���������Բ��������Ĺرղ���,Ҳ�ܽ����ݶ�ȡ��д�뵽ָ���Ĵ洢�ṹ��*/

public class InputAndOutput {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		inputDemo1();
		inputDemo2();
		outputDemo();

	}
	/*OutputStream���������ļ���д������*/
	public static void outputDemo() throws IOException {
		// TODO Auto-generated method stub
		/*1. ͨ��File����Ҫд�����ݵ��ļ�*/
		File file = new File("F:"+File.separator+"test.txt");
		/*2.ͨ������ʵ����������󣬵õ����������*/
		OutputStream out = new FileOutputStream(file,true);  //��������캯�����������ļ���׷�������ݣ�true��ʾ���ԣ�false��ʾ������
		/*3.����д�����*/
		String str = "\r\n Hello World!!";    //׼��һ����д����ַ���,����\r\n�ǽ��л��в�����
		byte[] b = str.getBytes();    //���ַ���ת�����ֽ����飬��ΪOutputStream��write����ֻ�ܶ��ֽڲ���
		
		/*д�����һ��ֱ�ӽ���������д��*/
		out.write(b);   
		/*д���������һ���ֽ�һ���ֽڵ�д��*/
		for (int i = 0; i < b.length; i++) {
			out.write(b[i]);
		}		
		out.close();	
	}

	/*InputStream��������ȡ�ļ��е�����*/
	/*����һ��֪����ȡ���ݴ�С�������*/
	public static void inputDemo1() throws IOException {
		// TODO Auto-generated method stub
		/*1.ͨ��File���ҵ�Ҫ��ȡ���ļ�*/
		File file = new File("F:"+File.separator+"test.txt");
		/*2.��ȡ��ȡ�ļ��Ĵ�С*/
		long fileSize = file.length();
		/*3.ͨ������ʵ����������󣬵õ�����������*/
		InputStream in = new FileInputStream(file);
		/*4.��ʼ���洢���ݵ��ֽ�����*/
		byte[] b = new byte[(int) fileSize];  //������ݶ�ȡ�ļ��Ĵ�С�����ٴ洢���ݵ����飬�������Լ��ٿռ���˷�
		/*5.�����ݶ�ȡ��ָ������*/
		in.read(b);
		/*6.����ȡ�����ֽ�����ת�����ַ���*/
		String str = new String(b);
		System.out.println(str);
		in.close();
	}
	
	/*���������ڲ�֪����ȡ���ݴ�С�������*/
	public static void inputDemo2() throws IOException {
		// TODO Auto-generated method stub
		/*1.ͨ��File���ҵ�Ҫ��ȡ���ļ�*/
		File file = new File("F:"+File.separator+"test.txt");
		/*2.ͨ������ʵ����������󣬵õ�����������*/
		InputStream in = new FileInputStream(file);
		/*3.��ʼ���洢���ݵ���ر���*/
		int len = 0;        //��¼��ȡ�����ݸ���
		byte[] b = new byte[1024];  //��ȡ�����ݴ洢�����������
		int temp = 0;     //��ʱ�洢��ȡ��ÿһ������
		/*4.һ��һ���Ķ�ȡ�ļ����ݣ����������ǲ�֪����ȡ���ݵĴ�С��
		 * ��ֻ��ͨ���ж��Ƿ��ȡ���ļ�β������ read()�����ķ�
		 * ��ֵ�Ƿ�Ϊ-1*/
		while((temp=in.read()) !=-1){
			b[len] = (byte) temp;
			len++;
		}
		in.close();		
		/*5.����ȡ�����ֽ�����ת�����ַ���*/
		String str = new String(b,0,len);
		System.out.println(str);
		
		
		
		
		
	}

}
