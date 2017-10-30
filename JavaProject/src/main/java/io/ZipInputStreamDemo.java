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
		/*1.获得压缩文件*/
		File file = new File("F:"+File.separator+"features.zip");  
		/*2.实例化ZpFile对象，这个对象主要有两个作用，一个是用来实例化压缩文件的输入流，
		第二就是通过getInputStream()方法获得每个压缩实体的输入流.可以这样理解：首先
		你要获得一个集装箱，然后再获得集装箱里面的每一个实体东西*/
		ZipFile zipFile = new ZipFile(file);
		ZipInputStream zipInput = new ZipInputStream(new FileInputStream(file));
		
		/*3.声明一些要用到的对象引用*/
		File outFile = null;    //这个是解压之后文件的输出目录
		ZipEntry entry = null;   //这个是压缩实体，就压缩文件中每一个压缩文件或压缩文件夹
		InputStream input =null;  //这是输入流，通过它的read()方法就可以读取每个压缩实体的数据
		OutputStream out = null;  //这是输出流，通过它的write()方法将读取的数据写入到指定的文件
			
		while((entry = zipInput.getNextEntry())!= null){   //获取压缩文件夹中的每一个文件实体
			System.out.println("解压文件名称为："+entry.getName());
			String outPathStr = "F:"+File.separator+entry.getName();  //构造每一个文件实体的路径
			outFile = new File(outPathStr);	 //实例化解压文件
			if(!outFile.getParentFile().exists()){
				outFile.getParentFile().mkdirs();
			}
			if(!outFile.exists()){
				outFile.createNewFile();
			}
			
			input = zipFile.getInputStream(entry);   //实例化输入流
			out = new FileOutputStream(outFile);	//实例化输出流
			
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
