package io.done;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;


/**
 * @author 天启 zhouj@dtdream.com
 * @since
 */

public class RandomAccessFileTest {

	static String filePath = "F:"+File.separator+ "io" +File.separator+"File"+File.separator+"test.txt";

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
		File tempFile = File.createTempFile("temp",null);
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

	public static void main(String[] args) throws IOException {
		RandomAccessFile randomAccessFile = new RandomAccessFile(filePath,"rw");
		System.out.println("0-getFilePointer:"+randomAccessFile.getFilePointer());

		// todo skipByte seek
		/*
		* 1)seek 是直接跳到文件的指定位置,与当前位置无关; 调到第几个字节
		* 2)skipByte 是在当前位置的基础上再跳过指定字节数; 再跳几个字节
		* */

		// write something in the file
		randomAccessFile.write("Hello World".getBytes());
		System.out.println("1-getFilePointer:"+randomAccessFile.getFilePointer());

		// set the file pointer at 0 position
		randomAccessFile.seek(0);
		System.out.println("2-getFilePointer:"+randomAccessFile.getFilePointer());

		// print the string
		System.out.println("" + randomAccessFile.readLine());
		System.out.println("3-getFilePointer:"+randomAccessFile.getFilePointer());

		// set the file pointer at 0 position
		randomAccessFile.seek(0);
		System.out.println("4-getFilePointer:"+randomAccessFile.getFilePointer());

		// attempt to skip 10 bytes and print the number of bytes skipped
		System.out.println("" + randomAccessFile.skipBytes(10));
		System.out.println("5-getFilePointer:"+randomAccessFile.getFilePointer());

		// print what is left after skipping
		System.out.println("" + randomAccessFile.readLine());
		System.out.println("6-getFilePointer:"+randomAccessFile.getFilePointer());

		// set the file pointer to position 8
		randomAccessFile.seek(8);
		System.out.println("7-getFilePointer:"+randomAccessFile.getFilePointer());

		// attempt to skip 10 more bytes and print the number of bytes skipped
		System.out.println("" + randomAccessFile.skipBytes(10));
		System.out.println("8-getFilePointer:"+randomAccessFile.getFilePointer());

	}
}
