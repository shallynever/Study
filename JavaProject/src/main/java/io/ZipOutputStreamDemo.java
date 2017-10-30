package io;

/*
 * �ڽ���ѹ��������ʱ����ʹ�ÿ�Դ�����org.apache.tools.zip.* 
 * */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;



public class ZipOutputStreamDemo {


	public static void main(String[] args) throws IOException {
	
		File sFolder = new File("F:"+File.separator+"test");		
		File zipFolder = new File("F:"+File.separator+"testdir.zip");
		ZipOneFileDemo();
//		ZipFloderDemo();
		
//		ZipFloderMethod(sFolder,zipFolder);
		
	}
	
	/*ѹ�������ļ���*/
	public static void ZipFloderMethod(File sFolder,File zipFolder) throws IOException {
		// TODO Auto-generated method stub
		
		InputStream in = null;
		ZipOutputStream zipoutFloder = new ZipOutputStream(new FileOutputStream(zipFolder), Charset.forName("GBK"));

		zipoutFloder.setComment("�ļ��е�ѹ��");
		
		if(sFolder.isDirectory()){
			File lists[] = sFolder.listFiles();			
			for (int i = 0; i < lists.length; i++) {
				if (lists[i].isDirectory()) {
					File innerLists[] = lists[i].listFiles();
					for (int j = 0; j < innerLists.length; j++) {
						in = new FileInputStream(lists[j]);
						ZipEntry zipentry = new ZipEntry(sFolder.getName()
								+ File.separator + lists[i].getName()
								+ File.separator + innerLists[j].getName());
						zipoutFloder.putNextEntry(zipentry);
						int temp = 0;
						while ((temp = in.read()) != -1) {
							zipoutFloder.write(temp);
						}
						in.close();
					}
				} else {
					in = new FileInputStream(lists[i]);
					zipoutFloder.putNextEntry(new ZipEntry(sFolder.getName()
							+ File.separator + lists[i].getName()));
					int temp = 0;
					while ((temp = in.read()) != -1) {
						zipoutFloder.write(temp);
					}
					in.close();
				}
			}
		}			
		zipoutFloder.close();			
	}

	public static void ZipFloderDemo() throws IOException {
		// TODO Auto-generated method stub
		File sFolder = new File("F:"+File.separator+"Camera");
		
		File zipFolder = new File("F:"+File.separator+"Camera.zip");
		
		InputStream in = null;
		
		ZipOutputStream zipoutFloder = new ZipOutputStream(new FileOutputStream(zipFolder), Charset.forName("GBK"));
		
		zipoutFloder.setComment("�ļ��е�ѹ��");
		
		if(sFolder.isDirectory()){
			File lists[] = sFolder.listFiles();			
			for (int i = 0; i < lists.length; i++) {
				in = new FileInputStream(lists[i]);
				
				zipoutFloder.putNextEntry(new ZipEntry(sFolder.getName()+File.separator+lists[i].getName()));
				
				int temp = 0;
				while((temp=in.read())!=-1){
					zipoutFloder.write(temp);
				}
				in.close();
				
				
			}
		}
		zipoutFloder.close();		
	}

	public static void ZipOneFileDemo() throws IOException {
		// TODO Auto-generated method stub
		File file = new File("F:"+File.separator+"test.txt");
		
		File zipFile = new File("F:"+File.separator+"test.zip");
		
		InputStream in = new FileInputStream(file);
		
		ZipOutputStream zipout = new ZipOutputStream(new FileOutputStream(zipFile),Charset.forName("GBK"));
		
		zipout.putNextEntry(new ZipEntry(file.getName()));

		zipout.setComment("����һ�����ӵ�����");
	//	zipout.setComment(new String("�ⲻ��һ�����ӵ�����".getBytes("gbk")));   //���ǲ���		
		int temp = 0;	
		while((temp = in.read())!= -1){
			zipout.write(temp);
		}
		in.close();
		zipout.close();	
	}
}
