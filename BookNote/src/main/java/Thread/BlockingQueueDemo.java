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
		return "姓名为"+name;
	}
}
public class BlockingQueueDemo {
	public static void main(String[] args) throws InterruptedException{
		BlockingQueue<Person> bq = new ArrayBlockingQueue<Person>(10);
		for (int i = 0; i < 10; i++) {
			bq.put(new Person("第"+i+"个"));
		}
		System.out.println("成功添加10个元素");
		for (Person p : bq) {
			System.out.println(p);
		}
		for (int i = 0; i < 10; i++) {
			bq.put(new Person("第"+(i+10)+"个"));
		}
		System.out.println("再次成功添加10个元素");

		
	}
}
