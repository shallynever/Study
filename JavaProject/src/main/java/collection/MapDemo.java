package collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import bean.Person;

/**
 * @author 天启 zhouj@dtdream.com
 * @since
 */
public class MapDemo {

	/**
	 *  Map常用的子类：
	 * 		|--Hashtable :内部结构是哈希表，是同步的。不允许null作为键，null作为值。
	 * 		|--Properties：用来存储键值对型的配置文件的信息，可以和IO技术相结合。
	 * 		|--HashMap : 内部结构是哈希表，不是同步的。允许null作为键，null作为值。
	 * 		|--TreeMap : 内部结构是二叉树，不是同步的。可以对Map集合中的键进行排序,键不能为null,值可以为null
	 * 		TreeMap.put(2, null);
	 * 		HashMap.put(null, null);
	 * 		Hashtable.put(2, 1);
	 *
	 * 	Map：
	 * 		一次添加一对元素。Collection 一次添加一个元素。
	 * 		Map也称为双列集合，Collection集合称为单列集合。
	 * 		其实map集合中存储的就是键值对。
	 * 		map集合中必须保证键的唯一性。
	 * 	常用方法：
	 * 		1，添加。
	 * 		value put(key,value):返回前一个和key关联的值，如果没有返回null.
	 * 		2，删除。
	 * 		void  clear():清空map集合。
	 * 		value remove(key):根据指定的key移除这个键值对。
	 * 		3，判断。
	 * 		boolean containsKey(key): //如果此映射包含指定键的映射关系，则返回 true
	 * 		boolean containsValue(value):// 如果此映射将一个或多个键映射到指定值，则返回 true。
	 * 		boolean isEmpty();
	 * 		4，获取。
	 * 		value get(key):通过键获取值，如果没有该键返回null。
	 * 		当然可以通过返回null，来判断是否包含指定键。
	 * 		int size(): 获取键值对的个数。
	 * */

	public static void main(String[] args) {
		Map<Integer, String> map = new TreeMap<>();
		map.put(1, "流操作");
		map.put(2, "集合");
		map.put(3, "网络编程");
		map.put(4, "多线程");
		
//		MapOutputMethodOne(map);
//		MapOutputMethodTwo(map);
		
		
		Map<Person, String> mapPerson = new HashMap<>(10);
		/**
		 * 在这里如果用TreeMap,那么在Person类中就要实现Compareable或Comparator
		 * 用HashMap，就需要在Person类中覆盖hashCode和equals方法
		 * */
		mapPerson.put(new Person("周敬",26), "zhoujing");
		System.out.println(mapPerson.get(new Person("周敬",26)));

		Map treeMap = new TreeMap();
		Map hashMap = new HashMap(10);
		Map tableMap = new Hashtable();
		
		treeMap.put(2, null);
		hashMap.put(null, null);
		tableMap.put(2, 1);
	}

	public static void MapOutputMethodTwo(Map<Integer, String> map) {
		for (Map.Entry<Integer, String> me : map.entrySet()) {
			System.out.println(me.getKey()+":"+me.getValue());
		}
	}

	public static void MapOutputMethodOne(Map<Integer, String> map) {

		Set<Map.Entry<Integer, String>> mapSet = map.entrySet();
		Iterator<Map.Entry<Integer, String>> it = mapSet.iterator();
		
		while(it.hasNext()){
			Map.Entry<Integer, String> me = it.next();
			System.out.println(me.getKey()+":"+me.getValue());
		}	
	}

}
