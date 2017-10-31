package io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/**
 * @author 天启 zhouj@dtdream.com
 * @since
 */
public class ZipOutputStreamTest {

	String filePath = "F:"+ File.separator+ "io" +File.separator+"Zip";

	@Test
	public void zipOutputStream02() throws Exception {
		File file = new File(filePath+File.separator+"test");
		File zipFile = new File(filePath+File.separator+"test.zip");
		
		InputStream inputStream;
		ZipOutputStream zipOutputStream =  new ZipOutputStream(new FileOutputStream(zipFile));
		zipOutputStream.setComment("apocalypse");
		if(file.isDirectory()){
			File[] lists = file.listFiles();
			for (int i = 0; i < lists.length; i++) {
				inputStream = new FileInputStream(lists[i]);
				zipOutputStream.putNextEntry(new ZipEntry(file.getName()+File.separator+lists[i].getName()));
				int temp;
				while((temp = inputStream.read())!= -1){
					zipOutputStream.write(temp);
				}
				inputStream.close();
			}
		}
		zipOutputStream.close();
	}

	@Test
	public void zipOutputStream01() throws Exception {
		File file = new File(filePath+File.separator+"demo.txt");
		File zipFile = new File(filePath+File.separator+"demo.zip");
		InputStream inputStream = new FileInputStream(file);
		ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile));
		zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
		zipOutputStream.setComment("apocalypse");
		int temp;
		while((temp = inputStream.read())!= -1){
			zipOutputStream.write(temp);
		}
		inputStream.close();
		zipOutputStream.close();
	}

}
