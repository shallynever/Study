package collection;

import java.util.ArrayList;
import java.util.ListIterator;

import bean.Person;


public class ListDemo {

	/**
	 * List：有序(存入和取出的顺序一致),元素都有索引(角标)，元素可以重复
	 * 	Vector:内部是数组数据结构，是同步的。增删，查询都很慢！
	 * 	ArrayList:内部是数组数据结构，是不同步的。替代了Vector。查询的速度快。
	 * 	LinkedList:内部是链表数据结构，是不同步的。增删元素的速度很快。
	 *
	 * List:特有的常见方法：有一个共性特点就是都可以操作角标。
	 *	1，添加
	 *		void add(index,element);// 在列表的指定位置插入指定元素
	 *		void addAll(index,collection);// 将指定 collection 中的所有元素都插入到列表中的指定位置
	 *	2，删除
	 *		Object remove(index):// 移除列表中指定位置的元素
	 *	3，修改
	 *		Object set(index,element);// 用指定元素替换列表中指定位置的元素
	 *	4，获取：
	 *		Object get(index);// 返回列表中指定位置的元素
	 *		int indexOf(object);// 返回此列表中第一次出现的指定元素的索引；如果此列表不包含该元素，则返回 -1。
	 *		int lastIndexOf(object);// 返回此列表中最后出现的指定元素的索引；如果列表不包含此元素，则返回 -1。
	 *		List subList(from,to);// 返回列表中指定的 fromIndex（包括 ）和 toIndex（不包括）之间的部分视图。
	 *
	 * */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Person> aList = new ArrayList<Person>();
		
		aList.add(new Person("zhoujing",23));
		aList.add(new Person("zhoujing",23));
		aList.add(new Person("zhoujing",23));
		aList.add(new Person("zhangsan",23));
		aList.add(new Person("zhangsan",2222));
		
		aList.add(new Person("lisi",23));
		
		
		
		ListIterator<Person> it = aList.listIterator();
		
		while(it.hasNext()){
			Person p = it.next();
			if("zhangsan".equals(p.getName())){
				System.out.println(p.getName());
				it.remove();
			}	
		}
		
		System.out.println(aList);
		
		
		
	}

}
