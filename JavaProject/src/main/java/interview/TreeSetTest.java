/*TreeSet��Ԫ�ؽ�������ʵ�ֵ����ַ�ʽ*/

package interview;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;



/*
TreeSet��Ԫ�ؽ�������ķ�ʽһ��
��Ԫ������߱��ȽϹ��ܣ�Ԫ�ؾ���Ҫʵ��Comparable�ӿڡ�����compareTo������

�����Ҫ���ն����о߱�����Ȼ˳�����������������в��߱���Ȼ˳����ô�죿
����ʹ��TreeSet���ϵڶ�������ʽ����
�ü�������߱��ȽϹ��ܣ�����һ����ʵ��Comparator�ӿڣ�����compare������
�����������Ϊ�������ݸ�TreeSet���ϵĹ��캯����
*/

public class TreeSetTest {

	public static void main(String[] args) {
	
		/*������ָ��ʹ�õıȽ���ComparatorByName���Ȱ���������
		     ���������ͬ�Ͱ�����������������������Ͷ���ͬ����Ϊͬһ��Ԫ��*/
		TreeSet<Person> tsp = new TreeSet<Person>(new ComparatorByName<Person>());
		tsp.add(new Person("zhoud",26));
		tsp.add(new Person("zhoua",23));
		tsp.add(new Person("zhoub",23));
		tsp.add(new Person("zhouc",23));

		Iterator<Person> itp = tsp.iterator();		
		while(itp.hasNext())
		{
			System.out.println(itp.next());	
		}
			
		/*��Person������и�����CompareTo�������Ȱ������������������ͬ�Ͱ���������
		    �����������Ͷ���ͬ����Ϊͬһ��Ԫ��*/
		TreeSet<Person> ts = new TreeSet<Person>();
		ts.add(new Person("zhoua",26));
		ts.add(new Person("zhoua",23));
		ts.add(new Person("zhoua",24));
		ts.add(new Person("zhoua",25));
		ts.add(new Person("zhoua",27));
		
		Iterator<Person> it = ts.iterator();		
		while(it.hasNext())
		{
			System.out.println(it.next());	
		}	
	}
}

class Person implements Comparable<Person> {

	private String name;
	private int age;
	
	public Person() {
		super();		
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {	
		return "Person:"+getName()+":"+getAge();
	}
	@Override
	public int compareTo(Person p) {
		
		int temp = this.age - p.age;
		return temp==0?this.name.compareTo(p.name):temp;		
	}	
}

class ComparatorByName<T> implements Comparator<T> {

	@Override
	public int compare(T o1, T o2) {
		
		Person p1 = (Person)o1;
		Person p2 = (Person)o2;
		
		int temp = p1.getName().compareTo(p2.getName());
		return temp==0? p1.getAge()-p2.getAge(): temp;
	}
}
