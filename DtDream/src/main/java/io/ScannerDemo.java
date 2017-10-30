package io;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ScannerDemo {

	String filePath = "F:"+ File.separator+ "io" +File.separator+"SystemIO"+File.separator+"test.txt";
	File file = new File(filePath);

	@Test
	public void fileScanner() throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		StringBuffer stringBuffer = new StringBuffer();
		while(scanner.hasNext()){
			stringBuffer.append(scanner.next()).append("\n");
		}
		System.out.println(stringBuffer.toString());
	}

	@Test
	public void dateScanner() {
		String str = "2017-07-09";
		System.setIn(new ByteArrayInputStream(str.getBytes()));
		System.out.println("输入日期（yyyy-MM-dd）：");
		Scanner scanner = new Scanner(System.in);
		String dateStr;
		Date date = null;
		if(scanner.hasNext("^\\d{4}-\\d{2}-\\d{2}")){
			dateStr = scanner.next("^\\d{4}-\\d{2}-\\d{2}");
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("输入的日期格式有误！");
		}
		System.out.println(date);
		scanner.close();
		
	}

	@Test
	public void baseScanner() {
		String str = "hello app";
		System.setIn(new ByteArrayInputStream(str.getBytes()));
		Scanner scan = new Scanner(System.in);
		scan.useDelimiter("\n"); //设置读取分隔符
		String content = scan.next();
		System.out.println("输入的数据为:"+content);
		scan.close();
	}

}
