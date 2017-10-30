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
		System.out.println("�������ڣ�yyyy-MM-dd����");
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
			System.out.println("��������ڸ�ʽ����");
		}
		System.out.println(date);
		scanner.close();
		
	}

	@Test
	public void baseScanner() {
		String str = "hello app";
		System.setIn(new ByteArrayInputStream(str.getBytes()));
		Scanner scan = new Scanner(System.in);
		scan.useDelimiter("\n"); //���ö�ȡ�ָ���
		String content = scan.next();
		System.out.println("���������Ϊ:"+content);
		scan.close();
	}

}
