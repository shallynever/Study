package io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class ZipInputStreamDemo {

	String filePath = "F:"+ File.separator+ "io" +File.separator+"Zip";


	@Test
	public void zipInputStream02() throws Exception {
		/*1.获得压缩文件*/
		File file = new File("F:"+File.separator+"features.zip");
		/*2.实例化ZpFile对象*/
		ZipFile zipFile = new ZipFile(file);
		ZipInputStream zipInput = new ZipInputStream(new FileInputStream(file));

		/*3.声明一些要用到的对象引用*/
		File outFile;    //这个是解压之后文件的输出目录
		ZipEntry entry;   //这个是压缩实体，就压缩文件中每一个压缩文件或压缩文件夹
		InputStream input;  //这是输入流，通过它的read()方法就可以读取每个压缩实体的数据
		OutputStream out;  //这是输出流，通过它的write()方法将读取的数据写入到指定的文件

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

	@Test
	public void zipInputStream01() throws Exception {
		File zipFile = new File(filePath+File.separator+"test.zip");
		ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFile));
		ZipEntry entry = zipInputStream.getNextEntry();
		System.out.println("压缩文件名称："+entry.getName());
		zipInputStream.close();
	}
}
