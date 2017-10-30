package TestDemo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
public class Person implements Externalizable{
	private transient String name ;	// ����name���ԣ����Ǵ����Բ������л�
	private int age ;		// ����age����
	public Person(){}
	public Person(String name,int age){	// ͨ��������������
		this.name = name ;
		this.age = age ;
	}
	public String toString(){	// ��дtoString()����
		return "������" + this.name + "�����䣺" + this.age ;
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
