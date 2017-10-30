package io;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ScannerApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataInputByScannerDemo();
	}

	public static void TxtInputByScannerDemo() {
		// TODO Auto-generated method stub
		File f = new File("f:"+File.separator+"test.txt");
		
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

	public static void DateInputByScannerDemo() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("�������ڣ�yyyy-MM-dd��:");
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

	public static void DataInputByScannerDemo() {
		
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
//		scan.useDelimiter("\n");     //����ɨ�����ķָ�ģʽ����Ϊ"\n",�����������������͵�����ʱ�Ͳ��������
		System.out.print("���������ݣ�");
		if(scan.hasNextInt()){
			System.out.println("�����������"+scan.nextInt());
		}
		String str = scan.next();
		System.out.print("���������Ϊ��"+str);
		scan.close();	
	}

}
