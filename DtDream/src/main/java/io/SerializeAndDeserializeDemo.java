package io;

import io.bean.Person;
import io.bean.Student;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class SerializeAndDeserializeDemo{

	/*
	* 对象序列化就是把一个对象变为二进制的数据流的一种方式，通过对象序列化	可以方便地实现
	* 对象的传输和存储。而如果要完成对象的输入和输出，还必须依靠对象输出流(ObjectOutputStream)
	* 和对象输入流(ObjectInputStream)
	*
	* 注意：对象序列化和对象反序列化操作时的版本兼容问题。serialVersionUID
	*
	* 在对象进行序列化或反序列化操作时，要考虑JDK版本问题。如果序列化的JDK版本和反序列化的JDK版本
	* 不统一则就有可能造成异常，所以在序列化操作中引入了一个serialVersionUID常量，可以通过此常量
	* 来验证版本的一致性。
	*
	* 只序列化属性
	*
	* */

	@Test
	public void deserialize() throws Exception {
		File file = new File("f:"+File.separator+"test.txt");
		InputStream inputStream = new FileInputStream(file);
		ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
		Person person = (Person) objectInputStream.readObject();
		inputStream.close();
		objectInputStream.close();
		person.sayHello();
		System.out.println(person);
	}

	@Test
	public void serialize() throws Exception {
		File file = new File("f:"+File.separator+"test.txt");
		OutputStream outputStream = new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		objectOutputStream.writeObject(new Person("apocalypse",30));
		objectOutputStream.close();
		outputStream.close();
	}
	
}


