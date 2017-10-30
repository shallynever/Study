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

	public static void main(String[] args) throws Exception {
//		ZipInputStreamDemo01();//���ѹ���ļ���һ��ZipEntry
		ZipInputStreamDemo02();//��ѹһ���ļ���

	}
	
	public static void ZipInputStreamDemo02() throws Exception, Exception {
		File file = new File("F:"+File.separator+"test.zip");
		File outFile = null;
		@SuppressWarnings("resource")
		ZipFile zipFile = new ZipFile(file);
		@SuppressWarnings("resource")
		ZipInputStream zipInput = new ZipInputStream(new FileInputStream(file));
		
		ZipEntry entry = null;
		InputStream input =null;
		OutputStream out = null;
		while((entry = zipInput.getNextEntry())!= null){
			System.out.println("��ѹ�ļ�����Ϊ��"+entry.getName());
			
			outFile = new File("f:"+File.separator+entry.getName());
			
			if(!outFile.getParentFile().exists()){
				outFile.getParentFile().mkdir();
			}
			if(!outFile.exists()){
				outFile.createNewFile();
			}
			input = zipFile.getInputStream(entry);
			
			out = new FileOutputStream(outFile);
			
			int temp = 0;
			while((temp = input.read())!=-1){
				out.write(temp);
			}
			input.close();
			out.close();
			
//			zipFile.close();
//			zipInput.close();
	
		}
	
	
	
	}

	public static void ZipInputStreamDemo01() throws Exception {
		File zipfile = new File("f:"+File.separator+"test.zip");
		ZipInputStream input = null;
		input = new ZipInputStream(new FileInputStream(zipfile));
		
		ZipEntry entry = input.getNextEntry();
		System.out.println("ѹ���ļ�������Ϊ��"+entry.getName());
		input.close();
	
	}
	

}
