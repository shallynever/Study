package interview;

public class Sort {

	public static void printArray(int[] arr) {
		System.out.print("[");
		for (int x = 0; x < arr.length; x++) {
			if (x != arr.length - 1)
				System.out.print(arr[x] + ", ");
			else
				System.out.println(arr[x] + "]");
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int arr[] = {31,65,82,76,13,27,10 };
		BubbleSort(arr);

	}
	
	/*希尔排序*/
	public static int[] ShellSort(int[] arr) {
		double d1 = arr.length;
		int temp = 0;
		while(true)
		{
			d1 = Math.ceil(d1/2);
			int d = (int)d1;
			for(int x=0;x<d;x++)
			{
				for(int i=x+d;i<arr.length;i+=d)
				{
					int j = i-d;
					temp = arr[i];
					for(;j>=0 && temp<arr[j];j-=d)
					{
						arr[j+d] = arr[j];
					}
					arr[j+d] = temp;
				}
			}
			if(d == 1)
				break;		
		}
		return arr;
	}

	/*插入排序*/
	public static int[] InsertSort(int[] arr) {
		int temp = 0;
		for (int i = 1; i < arr.length; i++) 
		{
			int j=i-1;
			temp = arr[i];
			for(;j>=0 && temp<arr[j]; j--)
			{
				arr[j+1] = arr[j];
			}
			arr[j+1] = temp;
		}
		return arr;
	}

	/* 归并排序 */
	public static int[] MergeSort(int[] arr) {
		if (arr.length > 0) {
			MergeSorting(arr, 0, arr.length - 1);
		}
		return arr;
	}
	public static void MergeSorting(int[] arr, int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
			MergeSorting(arr, low, mid);
			MergeSorting(arr, mid + 1, high);
			Merge(arr, low, mid, high);
		}
	}
	public static void Merge(int[] arr, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int i = low;// 左指针
		int j = mid + 1;// 右指针
		int k = 0;
		// 把较小的数先移到新数组中
		while (i <= mid && j <= high) {
			if (arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}
		// 把左边剩余的数移入数组
		while (i <= mid) {
			temp[k++] = arr[i++];
		}
		// 把右边边剩余的数移入数组
		while (j <= high) {
			temp[k++] = arr[j++];
		}
		// 把新数组中的数覆盖nums数组
		for (int k2 = 0; k2 < temp.length; k2++) {
			arr[k2 + low] = temp[k2];
		}
	}

	/* 快速排序 */
	public static int[] QuickSort(int[] arr) {
		if (arr.length > 0) {
			QuickSorting(arr, 0, arr.length - 1);
		}
		return arr;
	}

	public static void QuickSorting(int[] arr, int low, int high) {
		if (low < high) {
			int pos = getPos(arr, low, high);
			QuickSorting(arr, low, pos - 1);
			QuickSorting(arr, pos + 1, high);
		}
	}

	public static int getPos(int[] arr, int low, int high) {
		int temp = arr[low];
		while (low < high) {
			while (low < high && arr[high] > temp) {
				high--;
			}
			arr[low] = arr[high];
			while (low < high && arr[low] < temp) {
				low++;
			}
			arr[low] = arr[low];
		}
		arr[low] = temp;
		return low;
	}

	/* 选择排序 */
	public static int[] SelectSort(int[] arr) {
		for (int x = 0; x < arr.length - 1; x++) {
			for (int y = x + 1; y < arr.length; y++) {
				if (arr[x] > arr[y]) {
					swap(arr, x, y);
				}
			}
		}
		return arr;
	}

	/* 选择排序2 */
	public static int[] SelectSort_2(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int num = arr[i];
			int index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (num > arr[j]) {
					num = arr[j];
					index = j;
				}
			}
			if (index != i) {
				swap(arr, i, index);
			}
		}
		return arr;
	}

	/* 冒泡排序 */
	public static int[] BubbleSort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					/*
					 * int temp = arr[j]; arr[j] = arr[j+1]; arr[j+1] = temp;
					 */
					swap(arr, j, j + 1);
				}
			}
		}
		return arr;
	}
}
