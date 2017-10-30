package io;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ScannerDemo {

	public static void main(String[] args) {
//		ScannerDemo01();
//		ScannerDemo02();
		ScannerDemo03();

	}

	public static void ScannerDemo03() {
		File f = new File("f:"+File.separator+"demo.txt");
		
		Scanner scan = null;
		try {
			scan = new Scanner(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
		StringBuffer str = new StringBuffer();
		while(scan.hasNext()){
			str.append(scan.next()).append("\n");
		}
		System.out.println(str);
	}

	public static void ScannerDemo02() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�������ڣ�yyyy-MM-dd����");
		String str = null;
		Date date = null;
		if(scan.hasNext("^\\d{4}-\\d{2}-\\d{2}")){
			str = scan.next("^\\d{4}-\\d{2}-\\d{2}");
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("��������ڸ�ʽ����");
		}
		System.out.println(date);
		scan.close();
		
	}

	public static void ScannerDemo01() {
		Scanner scan = new Scanner(System.in);
		scan.useDelimiter("\n");//���ö�ȡ�ָ���
		System.out.print("��������:");
		String str = scan.next();
		System.out.println("���������Ϊ:"+str);
		scan.close();
	}

}
