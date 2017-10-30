package java_study;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MapDemo {

	public static void main(String[] args) {
		
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(1, null);
		
		System.out.println(map);
		
//		method_2(map);
	}
	
	public static void method_2(Map<Integer,String> map){
		
		System.out.println(map.put(8,"zhaoliu"));
		map.put(2,"zhaoliu");
		map.put(7,"xiaoqiang");
		System.out.println("****"+map.put(8,"wangcai"));
		
		
		Collection<String> values = map.values();
		
		Iterator<String> it2 = values.iterator();
		while(it2.hasNext()){
			System.out.println(it2.next());
		}
		
			
	}
}