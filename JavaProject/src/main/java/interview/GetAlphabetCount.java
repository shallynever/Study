package interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class GetAlphabetCount {

	public static void main(String[] args) {
		
		BufferedReader buf  = null;
		String str = null;
		System.out.print("请输入你要统计的字符串:");
		buf = new BufferedReader(new InputStreamReader(System.in));
		try {
			str = buf.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		getAlphabetCount(str);
	}

	public static Map<Character, Integer> getAlphabetCount(String str) {		
		Map<Character, Integer> map = new TreeMap<Character, Integer>();
		List<Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character,Integer>>();
		
		for(int i = 0; i < str.length(); i++) 
		{
			Character cha = str.charAt(i);
			
			if((cha >='a' && cha <='z' || cha >='A' && cha <='Z'))
			{
				if(map.containsKey(cha))
				{
					int count = map.get(cha);
					map.put(cha, count+1);
				}
				else
				{
					map.put(cha, 1);
				}	
			}		
		}	
		
		System.out.println(mapToString(map));
		
		list = sort(map);
		ListIterator<Entry<Character, Integer>> it = list.listIterator();
		while(it.hasNext())
		{
			Entry<Character, Integer> info = it.next();
			System.out.println(info.getKey()+":"+info.getValue());				
		}
		return map;
	}
	public static List<Entry<Character, Integer>> sort(Map<Character, Integer> map) {
		List<Map.Entry<Character, Integer>> info = new ArrayList<Map.Entry<Character,Integer>>(map.entrySet());
		Collections.sort(info, new Comparator<Map.Entry<Character, Integer>>() {
			@Override
			public int compare(Entry<Character, Integer> o1,Entry<Character, Integer> o2) {
				return (o2.getValue()-o1.getValue());
			}
		});	
		return info;
	}
	private static String mapToString(Map<Character, Integer> map) {
		
		StringBuilder sb = new StringBuilder();
		
		Iterator<Character> it = map.keySet().iterator();
		
		while(it.hasNext()){
			Character key = it.next();
			Integer value = map.get(key);
			
			sb.append(key+"("+value+")");
		}
		
		return sb.toString();
	}
}
