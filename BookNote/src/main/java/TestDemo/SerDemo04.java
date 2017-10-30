package TestDemo;

import java.io.File ;
import java.io.FileOutputStream ;
import java.io.OutputStream ;
import java.io.ObjectOutputStream ;
import java.io.FileInputStream ;
import java.io.InputStream ;
import java.io.ObjectInputStream ;
public class SerDemo04{
	public static void main(String args[]) throws Exception{
		ser() ;
		dser() ;
	}
	public static void ser() throws Exception {
		File f = new File("f:" + File.separator + "test.txt") ;	// ���屣��·��
		ObjectOutputStream oos = null ;	// �������������
		OutputStream out = new FileOutputStream(f) ;	// �ļ������
		oos = new ObjectOutputStream(out) ;
		oos.writeObject(new Person("zhoujing",30)) ;	// �������
		oos.close() ;	// �ر�
	}
	public static void dser() throws Exception {
		File f = new File("f:" + File.separator + "test.txt") ;	// ���屣��·��
		ObjectInputStream ois = null ;	// ��������������
		InputStream input = new FileInputStream(f) ;	// �ļ�������
		ois = new ObjectInputStream(input) ;	// ʵ��������������
		Object obj = ois.readObject() ;	// ��ȡ����
		ois.close() ;	// �ر�
		System.out.println(obj) ;
	}
};