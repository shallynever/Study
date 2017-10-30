package io;

/* 
 * ���ã�
 * 		ByteArrayInputStream�ǽ�����д�뵽�ڴ��������У�ͨ�����캯��ʵ�ֵģ�����read()��������ȡ�ڴ�������������
 * 		ByteArrayOutputStream�ǽ�����д�뵽�ڴ��������ͨ��write()����ʵ�ֵ�
 * 		
 * 		���ǿ��������������Ĺ��̣���������ڴ��Ϊ���㡣
 * 		ByteArrayInputStream���ǰѳ�����һ������ݱ�����ڴ棬��ͨ��read()�����ݶ�ȡ����
 * 		��ByteArrayOutputStream���ǰ����������ڴ���е�һ����������������д�����ݣ��������Զ�������
 * 		��д�����ʱ���Դ�����ȡ���ݡ�ͨ��toByteArray()��toString()ʵ�֡�
 * 
 * 
 * */



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayInputStreamAndByteArrayOutputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "�ܾ�zhejianggongshang wangyi";
		
		//ByteArrayInputStream�ڴ���������������д�뵽�ڴ���
		ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes());
		
		//ByteArrayOutputStream�ڴ�����������˾���������һ�������������ڴ��ȡ��������д�뵽�������ڲ���������
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		int temp = 0;
		
		while((temp=in.read())!= -1){	//���ڴ��е����ݶ�ȡ��������������ʱ����temp��					
			out.write(temp);  //����õ�������д�뵽�ڴ����������out��
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
