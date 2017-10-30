package TestDemo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
public class Person implements Externalizable{
	private transient String name ;	// 声明name属性，但是此属性不被序列化
	private int age ;		// 声明age属性
	public Person(){}
	public Person(String name,int age){	// 通过构造设置内容
		this.name = name ;
		this.age = age ;
	}
	public String toString(){	// 覆写toString()方法
		return "姓名：" + this.name + "；年龄：" + this.age ;
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		this.name = (String)in.readObject();
		this.age = (Integer)in.readObject();
	
	}		
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(this.name);
		out.writeObject(this.age);
	}
	
}
