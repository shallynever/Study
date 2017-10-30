package io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.TreeSet;


/**
 * @author 天启 zhouj@dtdream.com
 */
public class FileDemo {
	/*
    * File类的一些常用方法和重要的概念
	* 1、一个File类的对象，表示磁盘上的文件或目录。
	* 2、File提供了与平台无关的方法来对磁盘上的文件或目录进行操作。
	* 3、File类直接处理文件和文件系统。
	* 4、File类没有指定信息怎样从文件读取或向文件存储。
	* */
	private TreeSet<String> filePathSet = new TreeSet<>();
	private static final String filePath = "F:"+File.separator+ "io";

	@Test
	public void fileGeneralOperation() throws IOException {

		File file;
		file = new File(filePath+File.separator+"File"+File.separator+"Test");
		// 创建此抽象路径名指定的目录,只创建该层级目录,如果父目录不存在,则创建失败
		file.mkdir();
		// 创建此抽象路径名指定的目录,包括所有必需但不存在的父目录
		file.mkdirs();

		file = new File(filePath+File.separator+"test.txt");

		// 判断文件是否存在
		if(file.exists()){
			// 删除文件
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			file.delete();
		} else {
			// 创建文件
			file.createNewFile();
		}

		// 路径分隔符
		System.out.println(File.separator);
		System.out.println(File.pathSeparator);

	}

	@Test
	public void listAllFile() {
		File myFile = new File(filePath);
		Iterator<String> iterator = getFilePath(myFile).iterator();
		while(iterator.hasNext()){
			System.out.println("filePath:"+iterator.next());
		}
	}

	@Test
	public  void listCurrentFile() throws UnsupportedEncodingException {
		File file = new File(filePath);
		String str[] = file.list();
		File[] files = file.listFiles();
		if(file.exists()){
			for(int i= 0;i<str.length;i++){
				System.out.println(str[i]);		
			}
			for(int i=0;i<files.length;i++){
				System.out.println(files[i]);			
			}
		} else {
			System.out.println("File not Exist！");
		}
	}

	private TreeSet<String> getFilePath(File file) {
		if(file != null){
			if(file.isDirectory()){
				File f[] = file.listFiles();
				if(f != null){
					for (int i = 0; i < f.length; i++) {
						getFilePath(f[i]);
					}
				}
			}
			else{
				filePathSet.add(file.getPath());
			}
		}
		return filePathSet;
	}

}
