package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;


final class Person implements Serializable {	
	private static final long serialVersionUID = 1804800014629419965L;
	private transient String name;
	private int age;
	public Person(String name,int age){
		this.name = name;
		this.age = age;
	}
	public String toString(){
		return "������"+this.name+";���䣺"+this.age;
	}	
}

public class SerDemo{
	public static void main(String[] args) throws Exception{
		SerDemo01();
		SerDemo02();
		
	}

	public static void SerDemo02() throws Exception {
		File f = new File("f:"+File.separator+"test.txt");
		ObjectInputStream ios = null;
		InputStream input = new FileInputStream(f);
		ios = new ObjectInputStream(input);
		Object obj = ios.readObject();
		ios.close();
		System.out.println(obj);
		
		
	}

	public static void SerDemo01() throws Exception {
		File f = new File("f:"+File.separator+"test.txt");
		
		ObjectOutputStream oos = null;
		OutputStream out = new FileOutputStream(f);
		
		oos = new ObjectOutputStream(out);
		oos.writeObject(new Person("zhoujing",30));
		
		oos.close();
//		System.out.println("chenggong");
	}
	
}


