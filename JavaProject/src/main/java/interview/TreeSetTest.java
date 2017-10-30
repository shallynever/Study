/*TreeSet对元素进行排序实现的两种方式*/

package interview;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;



/*
TreeSet对元素进行排序的方式一：
让元素自身具备比较功能，元素就需要实现Comparable接口。覆盖compareTo方法。

如果不要按照对象中具备的自然顺序进行排序。如果对象中不具备自然顺序。怎么办？
可以使用TreeSet集合第二种排序方式二：
让集合自身具备比较功能，定义一个类实现Comparator接口，覆盖compare方法。
将该类对象作为参数传递给TreeSet集合的构造函数。
*/

public class TreeSetTest {

	public static void main(String[] args) {
	
		/*在这里指定使用的比较器ComparatorByName，先按姓名排序，
		     如果姓名相同就按年龄进行排序，如果姓名和年纪都相同则视为同一个元素*/
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
			
		/*在Person这个类中覆盖了CompareTo方法，先按年龄排序，如果年龄相同就按姓名排序，
		    如果姓名和年纪都相同则视为同一个元素*/
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
