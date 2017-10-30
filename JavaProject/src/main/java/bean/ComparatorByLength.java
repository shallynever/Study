package bean;

import java.util.Comparator;

public class ComparatorByLength<T> implements Comparator<T> {

	@Override
	public int compare(T o1, T o2) {	
		String s1 = (String)o1;
		String s2 = (String)o2;
			
		int temp = s1.length()-s2.length();
		return temp == 0?s1.compareTo(s2):temp;
	}

}
