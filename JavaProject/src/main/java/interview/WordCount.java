package interview;

/*��һ���ַ��������а��������ַ���Ӣ���ַ��������ַ�����ͳ�ƺʹ�ӡ��
�����ַ��ĸ���*/


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class WordCount {

	public static void main(String[] args) {
		String str = "ni �� hao zai zai zuo sm s";	
		wordCount(str);
		
	}

	public static List<Entry<String,Integer>> wordCount(String str) {
		int wordcount = 0;
		List<Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		StringTokenizer token = new StringTokenizer(str);
		while(token.hasMoreTokens())
		{
			wordcount++;
			String word = token.nextToken();
			if(map.containsKey(word))
			{
				int count = map.get(word);
				map.put(word, count+1);
			}
			else
			{
				map.put(word, 1);
			}			
		}
		System.out.println("��������:"+wordcount);
		list = sort(map);
		ListIterator<Entry<String, Integer>> liter = list.listIterator();
		while(liter.hasNext())
		{
			Entry<String, Integer> id = liter.next();
			System.out.println(id.getKey()+":"+id.getValue());		
		}
		
		return list;
	}

	public static List<Entry<String,Integer>> sort(Map<String, Integer> map) {
		List<Map.Entry<String, Integer>> infoId = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
		Collections.sort(infoId, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> arg0,Entry<String, Integer> arg1) {				
				return (arg1.getValue() - arg0.getValue());
			}
		});	
		return infoId;
	}
	
	
	

}
