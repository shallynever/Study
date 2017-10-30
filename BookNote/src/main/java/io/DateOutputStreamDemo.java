package io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DateOutputStreamDemo {

	public static void main(String[] args) throws Exception{
		DateOutputStreamDemo01();		
		//DateInputSreamDemo01();
		
	}

	public static void DateInputSreamDemo01() throws IOException{
		DataInputStream dis = null;
		File f = new File("f:"+File.separator+"test.txt");
		dis = new DataInputStream(new FileInputStream(f));
		String name = null;
		float price = 0.0f;
		int num = 0;
		char temp[] = null;
		char c = 0;
		int len = 0;
		try {
			while(true){
				temp  = new char[200];
				len=0;
				while((c=dis.readChar())!='\n'){
					temp[len] = c;
					len++;
				}
				name = new String(temp,0,len);
				price = dis.readFloat();
				dis.readChar();
				num = dis.readInt();
				dis.readChar();
				System.out.println(name+price+num);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dis.close();
	}

	public static void DateOutputStreamDemo01() throws Exception {
		DataOutputStream dos = null;
		File f = new File("f:"+File.separator+"demo.txt");
		dos = new DataOutputStream(new FileOutputStream(f));
		
		String names[] = {"÷‹æ¥","–≈µÁ","SDN"};
		float prices[] = {98.1f,32.1f,50.5f};
		int  nums[]={3,2,1};
		for (int i = 0; i < nums.length; i++) {
			dos.writeChars(names[i]);
//			dos.writeChar('\t');
			dos.writeFloat(prices[i]);
//			dos.writeChar('\t');
			dos.writeInt(nums[i]);
//			dos.writeChar('\n');
			
		}
		dos.close();
	}

}
