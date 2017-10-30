package io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;


/**
 * @author ���� zhouj@dtdream.com
 */
public class RandomAccessFileDemo {
	/*
	* Mode
	* "r" ��ֻ����ʽ�򿪡����ý��������κ� write �������������׳� IOException��
	* "rw" ���Ա��ȡ��д�롣������ļ��в����ڣ����Դ������ļ���
	* "rws" ���Ա��ȡ��д�룬���� "rw"����Ҫ����ļ������ݻ�Ԫ���ݵ�ÿ�����¶�ͬ��д�뵽�ײ�洢�豸��
	* "rwd" ���Ա��ȡ��д�룬���� "rw"����Ҫ����ļ����ݵ�ÿ�����¶�ͬ��д�뵽�ײ�洢�豸��
	*
	* RandomAccessFile��������
	* 1����JAVA I/O����ϵ�й�����ḻ���ļ����ݷ����࣬���ṩ���ڶ෽���������ļ����ݡ�
	* 2�����ڿ������ɷ����ļ�������λ�ã����������Ҫ�����ļ��Ĳ������ݣ�RandomAccessFile���Ǹ��õ�ѡ��
	* 3�������������ʱ������ݼ�¼���ļ����ļ��ļ�¼�Ĵ�С������ͬ���������С��λ�ñ����ǿ�֪�ġ�
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
		String content = "�й�";
		int pos = 5;
		//������ʱ���ļ�
		File tempFile = File.createTempFile("temp",null);
		//���������ֹʱ������ɾ���˳���·������ʾ���ļ���Ŀ¼
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
