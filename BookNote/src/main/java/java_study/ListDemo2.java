package java_study;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListDemo2 {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();

		
		
		list.add("abc2");
		list.add("abc3");
		list.add("abc1");
		
		System.out.println("list:"+list);
		
		ListIterator<String> it = list.listIterator();
		
		while(it.hasNext()){
			Object obj = it.next();
			if(obj.equals("abc2")){
				it.set("abc9");
			}
			System.out.println(obj);
		}
		
		System.out.println("list:"+list);




	}

}
