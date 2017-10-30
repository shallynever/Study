package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOutputStreamDemo {

	public static void main(String[] args) throws Exception {
		ZipOutputStreamDemo01();
		ZipOutputStreamDemo02();
	}
	/*ѹ���ļ���*/
	public static void ZipOutputStreamDemo02() throws Exception {
		File file = new File("f:"+File.separator+"upload");
		File zipFile = new File("f:"+File.separator+"upload.zip");
		
		InputStream input = null;
		ZipOutputStream zipout = null;
		zipout = new ZipOutputStream(new FileOutputStream(zipFile));  
		
		zipout.setComment("zhejianggangshangdaxue");
		if(file.isDirectory()){
			File lists[] = file.listFiles();
			for (int i = 0; i < lists.length; i++) {
				input = new FileInputStream(lists[i]);
				
				zipout.putNextEntry(new ZipEntry(file.getName()+File.separator+lists[i].getName()));
				
				int temp = 0;
				while((temp = input.read())!= -1){
					zipout.write(temp);
				}
				input.close();
			}
			
		}
		zipout.close();
	}
	/*ѹ���ļ�*/
	public static void ZipOutputStreamDemo01() throws Exception {
		File file = new File("f:"+File.separator+"demo.txt");
		
		File zipFile = new File("f:"+File.separator+"demo.zip");
		
		InputStream input = new FileInputStream(file);  //������
		
		
		ZipOutputStream zipout = null;
		zipout = new ZipOutputStream(new FileOutputStream(zipFile)); // ѹ�������
		
		System.out.println(file.getName());
		zipout.putNextEntry(new ZipEntry(file.getName()));  //��ʼд���µ� ZIP �ļ���Ŀ��������λ����Ŀ���ݵĿ�ʼ����
		zipout.setComment("zhejianggangshangdaxue");
		
		
		int temp = 0;
		while((temp = input.read())!= -1){
			zipout.write(temp);
		}
		input.close();
		zipout.close();
		
	}

}
