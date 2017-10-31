package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import bean.Person;


/**
 * @author 天启 zhouj@dtdream.com
 * @since
 */
public class SetDemo {

	/**
	 * Set：元素不能重复,无序（也不需要角标）
	 *	Set接口中的方法和Collection一致。
	 *		|--HashSet: 内部数据结构是哈希表 ，是不同步的。是无序的，且元素不能重复.
	 *		所以就不需要在添加元素的类中实现Comparable和Comparator接口，即使实现了也没有用
	 *	如何保证该集合的元素唯一性呢？
	 *		是通过对象的hashCode和equals方法来完成对象唯一性的。
	 *		如果对象的hashCode值不同，那么不用判断equals方法，就直接存储到哈希表中。
	 *		如果对象的hashCode值相同，那么要再次判断对象的equals方法是否为true。
	 *		如果为true，视为相同元素，不存。如果为false，那么视为不同元素，就进行存储。
	 *	注意：如果元素要存储到HashSet集合中，必须覆盖hashCode方法和equals方法。
	 *
	 *  一般情况下，如果定义的类会产生很多对象，比如人，学生，书，通常都需要覆盖equals，hashCode方法。
	 *  建立对象判断是否相同的依据。
	 *  	|--TreeSet:可以对Set集合中的元素进行排序。是不同步的。
	 *  	判断元素唯一性的方式：就是根据比较方法的返回结果是否是0，是0，就是相同元素，不存。
	 *
	 *  	TreeSet对元素进行排序的方式一：
	 *  	让元素自身具备比较功能，元素就需要实现Comparable接口。覆盖compareTo方法。
	 *  	this.compareTo(T o)比较此对象与指定对象的顺序。如果该对象小于、等于或大于指定对象，
	 *  	则分别返回负整数、零或正整数,分别返回 -1、0 或 1 中的一个值。
	 *
	 *   	如果不要按照对象中具备的自然顺序进行排序。如果对象中不具备自然顺序。怎么办？
	 *   	可以使用TreeSet集合第二种排序方式二：
	 *   	让集合自身具备比较功能，定义一个类实现Comparator接口，覆盖compare方法。
	 *   	当你指定这种方法之后，就不会调用元素本身的compareTo方法
	 *   	将该类对象作为参数传递给TreeSet集合的构造函数。
	 *
	 *   	if(this.hashCode()== obj.hashCode() && this.equals(obj))
	 *   	哈希表确定元素是否相同的依据
	 *   	1，判断的是两个元素的哈希值是否相同。
	 *   	如果相同，在判断两个对象的内容是否相同。
	 *   	2，判断哈希值相同，其实判断的是对象的hashCode的方法。判断内容相同，用的是equals方法。
	 *   	注意：如果哈希值不同，是不需要判断equals。
	 *
 	 * */
	
	public static final String str = null;

	public static void main(String[] args) {
//		HashSetDemo();
		TreeSetDemo();
		

	}

	public static void TreeSetDemo() {
		TreeSet<Person> TSet = new TreeSet<Person>();
		TSet.add(new Person("zhoujing",26));
		TSet.add(new Person("zhoujin",26));
		System.out.println(TSet);
	}

	public static void HashSetDemo() {
		Set<Person> hashSet = new HashSet<Person>();
		/*将姓名和年龄相同的人视为同一个对象*/
		hashSet.add(new Person("zhoujing", 25));
		hashSet.add(new Person("zhoujing", 25));
		hashSet.add(new Person("zhoujie", 24));
		hashSet.add(new Person("zhoumin", 27));
		hashSet.add(new Person("zhouhui", 28));
		hashSet.add(new Person("zhoupei", 25));
		Iterator<Person> it =hashSet.iterator();
		while(it.hasNext()){
			Person p = it.next();
			if("zhoujie".equals(p.getName())){
				System.out.println(p.getName());
//				hashSet.remove(p);  //报错
			}
		}
		System.out.println(hashSet);
	}
}
