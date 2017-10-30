package java_study;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		
		show(list);
		

	}

	public static void show(List<String> list) {
		
		list.add("cabcdefghij");
		list.add("cabcdef");
		System.out.println(list);
		
		
		list.add(1, "abcd");
		System.out.println(list);

		System.out.println("remove:"+list.remove(2));
	
		System.out.println("set:"+list.set(0, "ghret"));

		System.out.println("get:"+list.get(0));

		System.out.println("sublist:"+list.subList(1, 2));
		
		System.out.println(list);
		
		
		
		
		
	}

}
