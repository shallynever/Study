package interview;

/*
 * ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳�����������һ������������������һ����ά�����һ���������ж��������Ƿ��и������� 
��������:
array�� �����ҵĶ�ά����
target�����ҵ�����


�������:
���ҵ�����true�����Ҳ�������false
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
