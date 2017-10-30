package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class ZipInputStreamDemo {
	
	public static void main(String[] args) throws Exception{
		ZipInputStreamMethod();
	}
	public static void ZipInputStreamMethod() throws Exception {
		/*1.���ѹ���ļ�*/
		File file = new File("F:"+File.separator+"features.zip");  
		/*2.ʵ����ZpFile�������������Ҫ���������ã�һ��������ʵ����ѹ���ļ�����������
		�ڶ�����ͨ��getInputStream()�������ÿ��ѹ��ʵ���������.����������⣺����
		��Ҫ���һ����װ�䣬Ȼ���ٻ�ü�װ�������ÿһ��ʵ�嶫��*/
		ZipFile zipFile = new ZipFile(file);
		ZipInputStream zipInput = new ZipInputStream(new FileInputStream(file));
		
		/*3.����һЩҪ�õ��Ķ�������*/
		File outFile = null;    //����ǽ�ѹ֮���ļ������Ŀ¼
		ZipEntry entry = null;   //�����ѹ��ʵ�壬��ѹ���ļ���ÿһ��ѹ���ļ���ѹ���ļ���
		InputStream input =null;  //������������ͨ������read()�����Ϳ��Զ�ȡÿ��ѹ��ʵ�������
		OutputStream out = null;  //�����������ͨ������write()��������ȡ������д�뵽ָ�����ļ�
			
		while((entry = zipInput.getNextEntry())!= null){   //��ȡѹ���ļ����е�ÿһ���ļ�ʵ��
			System.out.println("��ѹ�ļ�����Ϊ��"+entry.getName());
			String outPathStr = "F:"+File.separator+entry.getName();  //����ÿһ���ļ�ʵ���·��
			outFile = new File(outPathStr);	 //ʵ������ѹ�ļ�
			if(!outFile.getParentFile().exists()){
				outFile.getParentFile().mkdirs();
			}
			if(!outFile.exists()){
				outFile.createNewFile();
			}
			
			input = zipFile.getInputStream(entry);   //ʵ����������
			out = new FileOutputStream(outFile);	//ʵ���������
			
			int temp = 0;
			while((temp = input.read())!= -1){   
				out.write(temp);
			}
			
			input.close();
			out.close();		
		}
		zipFile.close();
		zipInput.close();
	}
}
