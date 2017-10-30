package Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Person{
	private String name;
	public Person(String name){
		this.name = name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "����Ϊ"+name;
	}
}
public class BlockingQueueDemo {
	public static void main(String[] args) throws InterruptedException{
		BlockingQueue<Person> bq = new ArrayBlockingQueue<Person>(10);
		for (int i = 0; i < 10; i++) {
			bq.put(new Person("��"+i+"��"));
		}
		System.out.println("�ɹ����10��Ԫ��");
		for (Person p : bq) {
			System.out.println(p);
		}
		for (int i = 0; i < 10; i++) {
			bq.put(new Person("��"+(i+10)+"��"));
		}
		System.out.println("�ٴγɹ����10��Ԫ��");

		
	}
}
