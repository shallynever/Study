package designpattern;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* ԭ��ģʽ��Ȼ�Ǵ����͵�ģʽ�������빤��ģʽû�й�ϵ�������ּ��ɿ�����
 * ��ģʽ��˼����ǽ�һ��������Ϊԭ�ͣ�������и��ơ���¡������һ����
 * ԭ�������Ƶ��¶��󡣱�С���ͨ������ĸ��ƣ����н��⡣��Java�У�
 * ���ƶ�����ͨ��clone()ʵ�ֵģ��ȴ���һ��ԭ���ࣺ
 */


class Prototype implements Cloneable{
	public Object clone() throws CloneNotSupportedException{
		
		Prototype proto = (Prototype) super.clone();
		
		return proto;		
	}

}

/*
 * �ܼ򵥣�һ��ԭ���ֻ࣬��Ҫʵ��Cloneable�ӿڣ���дclone�������˴�clone�������Ըĳ���������ƣ�
 * ��ΪCloneable�ӿ��Ǹ��սӿڣ���������ⶨ��ʵ����ķ���������cloneA����cloneB����Ϊ�˴�����
 * ����super.clone()��仰��super.clone()���õ���Object��clone()����������Object��
 * �У�clone()��native�ģ�������ôʵ�֣��һ�����һƪ�����У����ڽ��Java�б��ط����ĵ��ã��˴���
 * �������������ҽ���϶����ǳ���ƺ������˵һ�£�������Ҫ�˽�����ǳ���Ƶĸ��

	ǳ���ƣ���һ�������ƺ󣬻����������͵ı����������´��������������ͣ�ָ��Ļ���ԭ������ָ��ġ�
	��ƣ���һ�������ƺ󣬲����ǻ����������ͻ����������ͣ��������´����ġ�����˵��������ƽ�
		    ������ȫ���׵ĸ��ƣ���ǳ���Ʋ����ס�
	�˴���дһ����ǳ���Ƶ����ӣ�
 */

class PrototypeOne implements Cloneable,Serializable{

	private static final long serialVersionUID = 1L;
	private String str;
	private SerializableObject obj;
	
	/*ǳ����*/
	public Object clone() throws CloneNotSupportedException{
		
		Prototype proto = (Prototype) super.clone();
		return proto;
	}
	
	/*�ֵ*/
	public Object deepclone() throws IOException, ClassNotFoundException{
	
		/* д�뵱ǰ����Ķ������� */  
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);
		
		/* �������������������¶��� */ 
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		
		
		return ois.readObject();
		
	}
	public String getString(){
		return str;
	}
	public void setString(String str){
		this.str = str;
	}
	public SerializableObject getObj() {  
        return obj;  
    }  
  
    public void setObj(SerializableObject obj) {  
        this.obj = obj;  
    }  

}

class SerializableObject implements Serializable{

	private static final long serialVersionUID = 1L;
	
}

/*Ҫʵ����ƣ���Ҫ����������ʽ���뵱ǰ����Ķ��������룬��д�����������ݶ�Ӧ�Ķ���*/
