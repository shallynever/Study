package java_study;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo {

	public static void main(String[] args) {
		Collection<String> c1 =new ArrayList<String>();
		Collection<String> c2 =new ArrayList<String>();
		show(c1,c2);
	}

	public static void show(Collection<String> c1, Collection<String> c2) {
		
		c1.add("abcd1");
		c1.add("abcd2");
		c1.add("abcd3");
		c1.add("abcd4");
		System.out.println(c1);		
		
		c2.add("abcd5");
		c2.add("abcd6");
		c2.add("abcd7");
		c2.add("abcd4");
		System.out.println(c2);
		
		/*
		boolean b2 = c1.containsAll(c2);
		System.out.println("containsAll:"+b2);		
		boolean b3 = c1.retainAll(c2);
		System.out.println("retainAll:"+b3+"-"+c1);		
		c1.addAll(c2);
		System.out.println("addAll:"+c1);
		System.out.println(c2);
		boolean b1 = c1.removeAll(c2);
		System.out.println(c1);
		System.out.println(b1);
		*/
		
		
		
		
		
		
	}

	/*public static void show(Collection coll) {	
		coll.add("advcc");
		System.out.println(coll);
		coll.remove("advcc");//
		System.out.println(coll);
		System.out.println(coll.hashCode());
		
	}*/
	
}
