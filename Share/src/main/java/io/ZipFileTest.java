package io;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * @author 天启 zhouj@dtdream.com
 * @since
 */
public class ZipFileTest {

	@Test
	public void zipFile02() throws Exception {
		File file = new File("F:"+File.separator+"demo.zip");
		File outputFile = new  File("F:"+File.separator+"demo_unzip.txt");
		
		ZipFile zipfile = new ZipFile(file);
		// 根据压缩实体的名称获得实体对象
		ZipEntry entry = zipfile.getEntry("demo.txt");
		InputStream input = zipfile.getInputStream(entry);
		OutputStream out = new FileOutputStream(outputFile);
		int temp;
		while((temp = input.read())!= -1){
			out.write(temp);
		}
		input.close();
		out.close();
		zipfile.close();
		
		
	}

	@Test
	public void zipFile01() throws IOException {
		File file = new File("F:"+File.separator+"upload.zip");
		ZipFile zipfile = new ZipFile(file);
		System.out.println("压缩文件名称："+zipfile.getName());
		zipfile.close();
	}

	public static void main(String[] args) throws IOException {
		File file = new File("F:"+File.separator+"privateKey.zip");
		ZipFile zipFile = new ZipFile(file);
		ZipEntry zipEntry = zipFile.entries().nextElement();
		ZipInputStream zipInputStream = new ZipInputStream(zipFile.getInputStream(zipEntry));
		InputStreamReader inputStreamReader = new InputStreamReader(zipInputStream);
		char[] chars = new char[1024];
		inputStreamReader.read(chars);
		System.out.println(String.valueOf(chars));

	}

}
