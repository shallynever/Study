package interview;

/*输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。 结果请按字母顺序输出。 
输入描述:
输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。*/

import java.util.ArrayList;
import java.util.Collections;

public class SolutionPermutation {
	
//	public static ArrayList allNew = new ArrayList();
	
	public static void main(String[] args) {
		System.out.println(Permutation("abcde"));
		
	}
	public static ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<String>();
        if (str == null || str.length() > 9 || str.length()==0) {
            return result;
        }
        str = str.trim();
        Permutation(str.toCharArray(), 0, result);
        Collections.sort(result);  //字典序排列  有些oj要求
        return result;
 
    }
 
    public static void Permutation(char[] data, int beginIdx,ArrayList<String> result) {
        if (beginIdx == data.length) {
            result.add(new String(data));
        } else {
            for (int i = beginIdx; i < data.length; ++i) {

                if(i!=beginIdx && data[i]==data[beginIdx]) continue;
                char temp = data[beginIdx];
                data[beginIdx] = data[i];
                data[i] = temp;
                 
                Permutation(data, beginIdx + 1, result);             
                temp = data[beginIdx];
                data[beginIdx] = data[i];
                data[i] = temp;                      
            }
        }
    }

	
	
	/*public static ArrayList<String> Permutation(String str) {
		ArrayList allResult = new ArrayList();	
		char[] ch = str.trim().toCharArray();
		ArrayList all = new ArrayList();		
		for (int i = 0; i < ch.length; i++) {
			if(!all.contains(ch[i])){
				all.add(ch[i]);
			}
		}
		int number = all.size();		
		allResult = sort(all,new ArrayList(),number);
	    return allResult;
	}	  
	private static ArrayList sort(List datas, List target,int number) {  
               
		if (target.size() == number) {
			StringBuffer sb = new StringBuffer();
            for (Object obj : target)
            {   
            	sb.append(obj);      	
            }           
            allNew.add(sb);
        }  
        for (int i = 0; i < datas.size(); i++) {  
            List newDatas = new ArrayList(datas);  
            List newTarget = new ArrayList(target);  
            newTarget.add(newDatas.get(i));  
            newDatas.remove(i);  
            sort(newDatas, newTarget,number);  
        }
		return allNew;       
    }  */

}
