package interview;

public class SolutionFibonacci {
	
	
	public static int Fibonacci(int n) {
		 int target=0;
		 if(n==0)
		 return 0;
		 if(n==1)
		 return 1;
		 int one=0;
		 int two=1;
		 for(int i=2;i<=n;i++){
			 target=one+two;
			 one=two;
			 two=target;
		 }
		 	return target;		 
	}
	private static int oneFibonacci(int n) {	
		if(n<=1){
		    return n;
		}
		int[] record = new int[n+1];
		record[0] = 0;
		record[1] = 1;
		for(int i=2;i<=n;i++){
		    record[i] = record[i-1] + record[i-2];
		}
		return record[n];
	}
	
	private static int twoFibonacci(int n) {	
		if(n<=1)
			return n;				
		else 
			return twoFibonacci(n-1)+twoFibonacci(n-2);			
	}
	
	public static int threeFibonacci(int n) {
		int f = 0, g = 1;
        while(!(n-- == 0)) {
            g += f;
            f = g - f;
        }
        return f;    
	}
}
