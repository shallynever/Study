package TestDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CastTime{
	
	
	
	public static int avg;  
	public static int n;
	public static int r;
	public static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	
	
	public static void main(String[] args) throws Exception, IOException
	{
		BufferedReader buf = null;			
		String str = null;
		System.out.println("请输入相关数据(n,r,avg):");
		buf = new BufferedReader(new InputStreamReader(System.in));
		str = buf.readLine();
		String[] info = str.split(" ");
		n = Integer.parseInt(info[0]);
		r = Integer.parseInt(info[1]);
		avg = Integer.parseInt(info[2]);
		
		int TotalScore = n*avg;
		int getTotalScore = 0;
		@SuppressWarnings("unused")
		int needScore = 0;
		
		int[] a = new int[n];
		int[] b = new int[n];
		
		
		for (int i = 0; i < a.length; i++) {
			System.out.println("请输入相关数据(a["+i+"],b["+i+"]):");
			buf = new BufferedReader(new InputStreamReader(System.in));
			str = buf.readLine();
			String[] score = str.split(" ");
			a[i] = Integer.parseInt(score[0]);
			getTotalScore = getTotalScore+a[i];
			b[i] = Integer.parseInt(score[1]);
		}
		needScore = TotalScore - getTotalScore;
		
		
		
		
		
		
		
		
	}
	
	
}