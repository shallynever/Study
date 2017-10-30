package CrackingtheCodingInterview;

public class TransformImageDemo {

	public static int[][] transformImage(int[][] mat, int n) {
		
		int[][] temp = new int[n][n]; 
		
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				temp[i][j] = mat[n-j-1][i];
			}
		}
		
		return temp;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
		
		int[][] result = transformImage(a,3);
		
		for (int[] is : result) {
			for (int i : is) {
				System.out.println(i);
			}
		}
	}

}
