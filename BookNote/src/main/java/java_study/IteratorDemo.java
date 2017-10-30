package java_study;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorDemo {

	public static void main(String[] args) {
		
		Collection<String> coll = new ArrayList<String>();
		
		coll.add("abcd1");
		coll.add("abcd2");
		coll.add("abcd3");
		coll.add("abcd4");
		coll.add("abcd5");
		
		Iterator<String> it =coll.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}

	}

}
