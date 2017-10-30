package interview;

/*
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。 
输入描述:
array： 待查找的二维数组
target：查找的数字


输出描述:
查找到返回true，查找不到返回false
*/
public class FindNumberInArray {

	public static void main(String[] args) {
		
	}
	
	 public boolean Find(int [][] array,int target) {
		 int len = array.length-1;
         int i = 0;
         while((len >= 0)&& (i < array[0].length)){
             if(array[i][len] > target){
                 len--;
             }else if(array[i][len] < target){
                 i++;
             }else{
                 return true;
             }
         }
         return false;
	 }
	 public boolean oneFind(int [][] array,int target) {
		 int colNum = array.length-1;
		 int rowNum = 0;
		 while((colNum >= 0)&& (rowNum < array[0].length)){
			 if(array[rowNum][colNum] > target){
				 colNum--;
			 }else if(array[rowNum][colNum] < target){
				 rowNum++;
			 }else{
				 return true;
			 }
		 }
		 return false;
	 }
	 
    public boolean twoFind(int [][] array,int target) {
         int len = array.length-1;
         int i = 0;
         while((len >= 0)&& (i < array[0].length)){
             if(array[i][len] > target){
                 len--;
             }else if(array[i][len] < target){
                 i++;
             }else{
                 return true;
             }
         }
         return false;
    }
		
	 
	 
	 
	 
	 
}
