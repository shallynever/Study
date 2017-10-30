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
		System.out.println("输入日期（yyyy-MM-dd）:");
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
			System.out.println("输入的日期格式有误！");
		}
		System.out.println(date);
		scan.close();		
	}

	public static void DataInputByScannerDemo() {
		
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
//		scan.useDelimiter("\n");     //将此扫描器的分隔模式设置为"\n",但是在输入数字类型的数据时就不能用这个
		System.out.print("请输入内容：");
		if(scan.hasNextInt()){
			System.out.println("输入的整数："+scan.nextInt());
		}
		String str = scan.next();
		System.out.print("输入的内容为："+str);
		scan.close();	
	}

}
