package DynamicProxy;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class Test {
	
	public static void main(String[] args) {
		StringBuffer a = new StringBuffer("A");
		StringBuffer b = new StringBuffer("B");
		operate(a, b);
		System.out.println(a+","+b);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.hashCode();
		Set<Integer> set = new TreeSet<Integer>();
		set.add(1);
		
	}
	static void operate(StringBuffer x,StringBuffer y){
		x.append(y);
		y = x;
	}
}
