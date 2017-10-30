package io;

import org.junit.Test;

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
		Scanner scanner = new Scanner(System.in);
		System.out.println("�������ڣ�yyyy-MM-dd����");
		String str;
		Date date = null;
		if(scanner.hasNext("^\\d{4}-\\d{2}-\\d{2}")){
			str = scanner.next("^\\d{4}-\\d{2}-\\d{2}");
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
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
		Scanner scan = new Scanner(System.in);
		scan.useDelimiter("\n"); //���ö�ȡ�ָ���
		System.out.print("��������:");
		String content = scan.next();
		System.out.println("���������Ϊ:"+content);
		scan.close();
	}

}
