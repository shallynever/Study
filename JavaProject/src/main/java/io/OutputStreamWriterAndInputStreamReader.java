package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

/*
 * ���ã�
 * InputStreamReader �������ǽ����ֽ���������ת���ɡ��ַ��������������̳���Reader�� 
 * OutputStreamWriter �������ǽ����ֽ��������ת���ɡ��ַ�������������̳���Writer��
 * 
 * 	��ʵ�Ƚ����׶��ķ���ȥ������������Ǿ���ȥ����������Ĺ��캯��
 *  InputStreamReader���캯���Ĳ���Ϊ InputStream�����Ժܺ���� �������þ��ǽ����ֽ���������ת���ɡ��ַ�����������
 *  ͬ�����֪��OutputStreamWriter�������ǽ����ֽ��������ת���ɡ��ַ����������
 * 
 * 
 * Ϊʲô����OutputStreamWriter��InputStreamReader����ת����ĳ��֣�
 * 	1.����Ҫ˵һ���ֽ������ַ���������	
 * 		1����д��λ��ͬ���ֽ������ֽڣ�8bit��Ϊ��λ���ַ������ַ�Ϊ��λ���������ӳ���ַ���һ�ο��ܶ�����ֽڡ�
 * 		2���������ͬ���ֽ����ܴ����������͵����ݣ���ͼƬ��avi�ȣ������ַ���ֻ�ܴ����ַ����͵����ݡ�
 * 	���ۣ�ֻҪ�Ǵ����ı����ݣ������ȿ���ʹ���ַ����� ����֮�ⶼʹ���ֽ�����
 *  
 *  2.����˵һ�¼�����Ĵ洢���ƣ�
 *  	��������κ����ݶ��Ƕ����ƴ���ģ��������ı���ͼƬ������Ƶ���������ǿ��Բ����ֽ������������ݵĲ�����
 *  	������ʱ�������������ַ�����ݲ��������ʱ�����Ǿ�Ҫ�õ�ת�����ˡ�
 *  ����ٸ�����˵��һ�£�
 *  �ȷ�˵����������Ҫ��ȡһ����Ƭ�����ݣ����ʱ������Ӧ��ѡ�����ֽ����������������ǻ�õ����ݾ����ֽڵ���ʽ
 *  �����ڳ��������ǲ��������ֽڵ���ʽ���棬�������ʱ�����Ǿ���Ҫ����ת�����ַ������Ӷ��������ַ��������С�
 *  ������õ�InputStreamReader�࣬���������ֽ�����ת���ɡ��ַ�����������
 *  ͬ��������OutputStreamWriter������á�
 *  
 * */
	


public class OutputStreamWriterAndInputStreamReader {
	
	public static void main(String[] args) throws IOException{	
		OutputStreamWriterDemo();
		InputStreamReaderDemo();	
	}
	/*����������У����Ǿ��������ַ�������ʽ������д���ı��У����Ծ�Ҫ�����ֽ��������ת���ɡ��ַ��������*/
	public static void OutputStreamWriterDemo() throws IOException {
		// TODO Auto-generated method stub
		File file = new File("F:"+File.separator+"test.txt");
		
		Writer out = new OutputStreamWriter(new FileOutputStream(file,true));
		
		out.write("\r\n20160229zhoujing");
		out.close();
	}
	/*����������У������뽫��ȡ�����ı����ݱ������ַ������У����Ծ�Ҫ�����ֽ���������ת���ɡ��ַ���������*/
	public static void InputStreamReaderDemo() throws IOException {
		// TODO Auto-generated method stub
		File file = new File("F:"+File.separator+"test.txt");
		
		Reader in = new InputStreamReader(new FileInputStream(file));
		
		char[] c = new char[1024];
		
		int len = in.read(c);
		
		in.close();
		
		System.out.println(new String(c,0,len));	
	}
}
