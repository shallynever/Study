package io;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

class Student implements Externalizable{
	private String name;
	private int age;
	public Student(){};
	public Student(String name,int age){
		this.name = name;
		this.age = age;		
	}
	public String toString(){
		return "–’√˚£∫"+this.name+";ƒÍ¡‰£∫"+this.age;
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(this.age);
		out.writeObject(this.name);
	}
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		this.name = in.readObject().toString();
		this.age = in.readInt();
	
	}		
}


public class ExternalizableDemo {

	public static void main(String[] args) throws Exception {
		ser();
		dser();
	}
	public static void dser() throws Exception {
		File f = new File("f:"+File.separator+"test.txt");
		ObjectInputStream ois = null;
		InputStream input = new FileInputStream(f);
		ois = new ObjectInputStream(input);
		Object obj = ois.readObject();
		ois.close();
		System.out.println(obj);
	}
	public static void ser() throws Exception {
		File f = new File("f:"+File.separator+"test.txt");		
		ObjectOutputStream oos = null;
		OutputStream out = new FileOutputStream(f);
		oos = new ObjectOutputStream(out);
		oos.writeObject(new Student("zhoujing",30));		
		oos.close();
	}

}
