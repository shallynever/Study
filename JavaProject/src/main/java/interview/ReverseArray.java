package interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseArray {
	
	public static void main(String[] args)
	{
		int arr[] = null;
		arr = creatArray(); 
		printArray(arr);
		reverseArray(arr);
		printArray(arr);
	}

	public static int[] creatArray() {
		// TODO Auto-generated method stub
		BufferedReader buf = null;
		int len =0;
		System.out.println("请输入数组长度:");
		buf = new BufferedReader(new InputStreamReader(System.in));
		try {
			len = Integer.parseInt(buf.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int arr[] = new int[len];
		System.out.println("数组长度为:"+arr.length);
		for(int i = 0; i<arr.length;i++)
		{
			buf = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("请给数组第"+(i+1)+"个元素赋值:");			
			try {
				arr[i] = Integer.parseInt(buf.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return arr;
	}

	public static void printArray(int[] arr) {
		// TODO Auto-generated method stub
		System.out.print("[");
		for(int x = 0; x<arr.length;x++)
		{
			if(x != arr.length-1)
				System.out.print(arr[x]+",");
			else
				System.out.println(arr[x]+"]");
		}
	}

	public static void reverseArray(int[] arr) {
		// TODO Auto-generated method stub
		for(int start=0,end=arr.length-1;start<end;end--,start++)
		{
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
		}
	}
	
	
	
}
