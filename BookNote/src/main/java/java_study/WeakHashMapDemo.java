package java_study;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapDemo {

	public static void main(String[] args) {
		
		Map<String, String> map = new WeakHashMap<String, String>();
		map.put("zhaoni", "nihao");
		map.put("123", "nihao");
		map.put("123oni", "nihao");
		System.gc();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("34oni", "nihao");
		System.out.println(map);

	}

}
