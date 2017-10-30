package TestDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class OutPut {
	public static void main(String[] args) throws IOException{
		String str = null;
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		str = buf.readLine();	
		FindTheChar(str);
		

	}

	public static void FindTheChar(String str) {
		
		
		List<String> listStr = new ArrayList<String>();
		List<Integer> list = new ArrayList<Integer>();
		char[] chStr = str.toCharArray();
		for (int i = 0; i < chStr.length; i++) {
			if(chStr[i]=='9' || chStr[i] == 'g'){
				list.add(i);
			}
		}
		for(int j = 0; j< list.size();j++){
			listStr.add(new String());
		}	
		
		
		
	}

}
