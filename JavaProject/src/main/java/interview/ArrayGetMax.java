package interview;

import java.util.concurrent.*;

public class ArrayGetMax {	
	
	/*从数组中获取最大（最小）值，两种思路：获取最大值、获取最大值的脚标*/
	
	public static int getMax(int[] arr) {	
		int maxElement = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(maxElement<arr[i])
			{
				maxElement = arr[i];
			}
		}
		return maxElement;
	}
	
	
	
	public static int getMax_2(int[] arr)
	{
		int maxIndex = 0;
		for(int x=1; x<arr.length; x++)
		{
			if(arr[x]>arr[maxIndex])
				maxIndex = x;
		}
		return arr[maxIndex];	
	}

}
