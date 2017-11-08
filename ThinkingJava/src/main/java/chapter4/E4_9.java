package chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static tools.Print.print;
public class E4_9 {

	static int fib(int n){
		if(n <=2 )
			return 1;
		return fib(n-1)+fib(n-2);
	}
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		n = Integer.parseInt(buf.readLine());
		print(fib(n));
	}

}
