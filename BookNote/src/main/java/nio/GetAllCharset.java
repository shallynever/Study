package nio;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;

public class GetAllCharset {
	
	public static void main(String[] args){
		SortedMap<String, Charset> all = null;
		all = Charset.availableCharsets();
		Iterator<Map.Entry<String, Charset>> it = null;
		it = all.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, Charset> me = it.next();
			System.out.println(me.getKey()+":"+me.getValue());
		}
		
	}

}
