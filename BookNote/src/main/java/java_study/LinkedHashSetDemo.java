package java_study;
import java.util.HashSet;
import java.util.Iterator;

public class LinkedHashSetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		HashSet<String> hs = new HashSet<String>();
		
		hs.add("hahah");
		hs.add("hehe");
		hs.add("heihei");
		hs.add("xixii");

		
		Iterator<String> it = hs.iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}