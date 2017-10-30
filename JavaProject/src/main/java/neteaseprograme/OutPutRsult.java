package neteaseprograme;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OutPutRsult {
	public static char[] baseChar = {'g','9'};  
	public static String[] strArray = {"9","g"};
	public static String[] resultStrArray = null;
	public static List<String> listTotal = new ArrayList<String>();
	public static int toalNumber = 1;
	public static void main(String[] args) {
		
		String str = "999d9g99d999";
		List<Integer> list = new ArrayList<Integer>();
		char[] chStr = str.toCharArray();		
		
		for (int i = 0; i < chStr.length; i++) {
			if(chStr[i] == '9' || chStr[i] == 'g'){
				list.add(i);
			}
		}
		
		for (int j = 0; j < list.size(); j++) {
			toalNumber = toalNumber*2;
		}
		System.out.println("总的情况数："+toalNumber);
		resultStrArray = new String[toalNumber];
		
		CreateString(strArray, baseChar);
		for (int i = 0; i < resultStrArray.length; i++) {
			char[] resultChar = resultStrArray[i].toCharArray();
			
			Iterator<Integer> it = list.iterator();
			int n = 0;
			char[] changeChar = str.toCharArray();
			while(it.hasNext()){				
				changeChar[it.next()] = resultChar[n];
				n++;
			}
			System.out.println(new String(changeChar));
		}
		
		/*Iterator<String> itTotal = listTotal.iterator();
		while(itTotal.hasNext()){
			System.out.println(itTotal.next());
		}*/
	}

	public static String[] CreateString(String[] strArray,char[] baseStr) {
		
		String temp = null; 
		List<String> listStr = new ArrayList<String>();
		for (int i = 0; i < strArray.length; i++) {
			for (int j = 0; j < baseStr.length; j++) {
				temp = strArray[i]+baseStr[j];
				listStr.add(temp);
				listTotal.add(temp);
			}
		}
		Iterator<String> it = listStr.iterator();
		String[] newStrArray = new String[listStr.size()];
		System.out.println("新建数组长度"+newStrArray.length);
		int k = 0;
		while(it.hasNext()){
			newStrArray[k] = it.next();
			k++;
		}
		if(newStrArray.length == toalNumber){			
			resultStrArray = newStrArray;	
			return resultStrArray;	
		}
		return CreateString(newStrArray, baseStr);	
		
	}
}
