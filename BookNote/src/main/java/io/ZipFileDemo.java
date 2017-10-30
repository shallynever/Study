package io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

public class ZipFileDemo {

	public static void main(String[] args) throws Exception, IOException {
		ZipFileDemo01();
		ZipFileDemo02();

	}
	/*//��ѹһ���ļ�*/	
	public static void ZipFileDemo02() throws Exception, IOException {
		File file = new File("f:"+File.separator+"demo.zip");
		
		File outputFile = new  File("f:"+File.separator+"demo_unzip.txt");
		
		ZipFile zipfile = new ZipFile(file);
		ZipEntry entry = zipfile.getEntry("demo.txt");
		InputStream input = zipfile.getInputStream(entry);
		
		OutputStream out = new FileOutputStream(outputFile);
		
		int temp = 0;
		while((temp = input.read())!= -1){
			out.write(temp);
		}
		input.close();
		out.close();
		zipfile.close();
		
		
	}

	public static void ZipFileDemo01() throws ZipException, IOException {
		File file = new File("f:"+File.separator+"upload.zip");
		ZipFile zipfile = new ZipFile(file);
		System.out.println("ѹ���ļ�������Ϊ��"+zipfile.getName());
		
		zipfile.close();
	}

}
