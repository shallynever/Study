package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CollectionTools {
	
	public static void main(String[] args){
		/*返回空的集合*/
		List<String> list = Collections.EMPTY_LIST;
		Set<String> set = Collections.EMPTY_SET;
		Map<Integer, String> map = Collections.EMPTY_MAP;
		/*对List的操作*/
		List<String> alist = new ArrayList<String>();
		Collections.addAll(alist, "zhoujing","zhejiang","gongshang");
		System.out.println("原集合内容：");
		for (String str : alist) {
			System.out.print(str+"、");
		}
		System.out.println("");
		Collections.reverse(alist);
		System.out.println("反转之后集合内容：");
		for (String str : alist) {
			System.out.print(str+"、");
		}
		
	}

}
