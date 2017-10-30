package interview;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapOutput {

	public static void main(String[] args) 
	{
		Map<String, Integer> map = null;
		mapOutput_1(map);
		mapOutput_2(map);
	}
	public static void mapOutput_2(Map<String, Integer> map) 
	{
		for (Map.Entry<String, Integer> me : map.entrySet()) 
		{
			System.out.println(me.getKey()+"==>"+me.getValue());
		}
	}
	
	public static void mapOutput_1(Map<String, Integer> map) 
	{
		Set<Map.Entry<String, Integer>> allset = map.entrySet();
		Iterator<Map.Entry<String, Integer>> it = allset.iterator();
			while(it.hasNext())
			{
				Map.Entry<String, Integer> me = it.next();
				System.out.println(me.getKey()+"==>"+me.getValue());
			}
	}
}
