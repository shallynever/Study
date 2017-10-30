package io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;


/**
 * @author 天启 zhouj@dtdream.com
 */
public class RandomAccessFileDemo {
	/*
	* Mode
	* "r" 以只读方式打开。调用结果对象的任何 write 方法都将导致抛出 IOException。
	* "rw" 打开以便读取和写入。如果该文件尚不存在，则尝试创建该文件。
	* "rws" 打开以便读取和写入，对于 "rw"，还要求对文件的内容或元数据的每个更新都同步写入到底层存储设备。
	* "rwd" 打开以便读取和写入，对于 "rw"，还要求对文件内容的每个更新都同步写入到底层存储设备。
	*
	* RandomAccessFile存在意义
	* 1、是JAVA I/O流体系中功能最丰富的文件内容访问类，它提供了众多方法来访问文件内容。
	* 2、由于可以自由访问文件的任意位置，所以如果需要访问文件的部分内容，RandomAccessFile将是更好的选择。
	* 3、可以用来访问保存数据记录的文件，文件的记录的大小不必相同，但是其大小和位置必须是可知的。
	*
	* */
	String filePath = "F:"+File.separator+ "io" +File.separator+"File"+File.separator+"test.txt";

	@Test
	public void randomAccessFileRead() throws Exception {
		File file = new File(filePath);
		if (file.exists()) {
			RandomAccessFile randomAccessFiler = new RandomAccessFile(file,"rw");
			byte[] bytes = new byte[1024];
			randomAccessFiler.read(bytes);
			String info = new String(bytes);
			char[] infoChar = info.toCharArray();
			for (int i = 0; i < infoChar.length; i++) {
				if(infoChar[i] == ','){
					System.out.println();
					continue;
				}
				System.out.print(infoChar[i]);
			}
			randomAccessFiler.close();
		} else {

		}
	}

	@Test
	public void randomAccessFileWrite() throws Exception {
		File file = new File(filePath);
		if(file.exists()){
			file.delete();
			file.createNewFile();
		} else {
			file.createNewFile();
		}
		RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
		randomAccessFile.seek(randomAccessFile.length());
		String[] name = {"zhangsan","zhoujing"};
		for (int i = 0; i < name.length; i++) {
			if(i == (name.length-1)){
				randomAccessFile.write(name[i].getBytes());
				continue;
			}
			randomAccessFile.write((name[i]+",").getBytes());
		}
		randomAccessFile.close();
	}

	@Test
	public void insert() throws IOException	{
		File file = new File(filePath);
		String content = "中国";
		int pos = 5;
		//创建临时空文件
		File tempFile = File.createTempFile("temp",null);
		//在虚拟机终止时，请求删除此抽象路径名表示的文件或目录
		tempFile.deleteOnExit();
		FileOutputStream fileOutputStream = new FileOutputStream(tempFile);

		RandomAccessFile randomAccessFile = new RandomAccessFile(file,"rw");
		randomAccessFile.seek(pos);
		byte[] buffer = new byte[4];
		int num;
		while((num = randomAccessFile.read(buffer)) != -1 ){
			fileOutputStream.write(buffer,0,num);
		}
		randomAccessFile.seek(pos);
		randomAccessFile.write(content.getBytes());
		FileInputStream fileInputStream = new FileInputStream(tempFile);
		while((num = fileInputStream.read(buffer)) != -1){
			randomAccessFile.write(buffer,0,num);
		}
	}
}
