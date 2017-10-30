package io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/*������io���У���ӡ���������Ϣ�����࣬��Ҫ�����ֽڴ�ӡ����PrintStream�����ַ���ӡ����PrintWriter����*/


public class PrintStreamAndPrintWriter {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PrintStream out = new PrintStream(new FileOutputStream(new File("F:"+File.separator+"test.txt"),true));	
		/*�������ֱ�Ӱ�file������ΪPrintStream�Ĺ��캯���Ĳ�������ôÿ�����ļ���д������ʱ���Ὣ֮ǰ�����ݸ��ǵ���
		 * ���������ȰѴ����ļ��ֽ���������ڴ����ļ��ֽ������ʱ���Խ���������Ϊ���ļ���׷�����ݡ�
		 * */
		out.print("nihao");
		out.print("wo shi zhoujing");
		out.print("zhejiang");
		out.print("hangzhou");
		
		/*ʹ�ô�ӡ�����и�ʽ��*/
		String name = "�ܾ�";
		int age = 25;
		char sex = 'M';
		float height= 170.00f;
		out.printf("������%s;���䣺%d;��ߣ�%f;�Ա�%c", name,age,height,sex);
				
		out.close();
	}

}
