package interview;

public class Search {

	public static void main(String[] args) {
		
		int arr[] = {1,2,3,4,5,6,7,8,9,10};
		
		int index1 = 0;
		int index2 = 0;
		index1 = sequentialSearch(arr,2);
		index2 = binarySearch(arr,6);
		
		System.out.println("index1:"+index1);
		System.out.println("index2:"+index2);
	}

	public static int binarySearch(int arr[], int key) {		
		int max,min,mid;
		min = 0;
		max = arr.length-1;
		mid = (max+min)/2;

		while(arr[mid] != key)
		{
			if(key>arr[mid])
				min = mid + 1;
			else if(key < arr[mid])
				max = mid - 1;
			if(max < min)
				return -1;
			
			mid  = (max + min)/2;			
		}	
		return mid;
	}

	public static int sequentialSearch(int[] arr, int key) {
		
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == key)
			{
				index = i;
				break;
			}			
			if(i == arr.length-1)
				index = -1;
		}
		return index;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
