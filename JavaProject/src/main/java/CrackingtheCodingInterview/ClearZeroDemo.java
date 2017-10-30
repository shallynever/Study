package CrackingtheCodingInterview;


public class ClearZeroDemo {
	
	public static int[][] clearZero(int[][] mat, int n) {
		int[][] temp = new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				temp[i][j]=mat[i][j];
			}
		}
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){	
				temp[i][j]=mat[i][j];
				if(mat[i][j] == 0){
					for(int k=0;k<n;k++){
						temp[i][k] = 0;
						temp[k][j] = 0;
					}
				}
			}
		}	
		
		return temp;
        
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = {{0,1,2},{4,5,6},{3,4,5}};
		int[][] result = clearZero(mat, 3);
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				System.out.println(result[i][j]);
			}
		}

	}

}
