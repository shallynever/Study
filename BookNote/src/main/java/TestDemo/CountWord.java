package TestDemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;

public class CountWord{
	
	public static void main(String[] args) {
		File file = new File("F:"+File.separator+"test.txt");
		countWord(file);
	}
	
	public static void countWord(File file){
		try {
			Map<String, Integer> map = new TreeMap<String, Integer>();
			BufferedReader buf  = new BufferedReader(new FileReader(file));
			String temp = null;
			while((temp = buf.readLine())!= null){
				char[] cha = temp.trim().toCharArray();
				StringBuffer word = new StringBuffer();
				for (int i = 0; i < cha.length; i++) {
					String str = String.valueOf(cha[i]);	
					//判断如果读到的字符是空格、逗号、句号就把buffer里面的单词保存到map中，并将buffer清空。
					if(str.equals(" ")||str.equals(",")||str.equals(".")){ 
						word.toString().trim();
						if(map.containsKey(word.toString())){
							map.put(word.toString().trim(), map.get(word.toString())+1);
						}else{
							map.put(word.toString().trim(), 1);
						}
						word.delete(0, word.length());		//一定记得清空StringBuffer	 									
					}else{
						
						word.append(cha[i]);						
					}
				}
			}
			buf.close();	
			System.out.println(map);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 
	
}