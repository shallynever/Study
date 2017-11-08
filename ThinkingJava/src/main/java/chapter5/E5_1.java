package chapter5;
import static tools.Print.print;

import java.util.Random;

public class E5_1 {
	public static void main(String[] args){
		
		//printNumber(100);
		createRandomNumber(25);
		
		StringBuffer s1 = new StringBuffer(10);
		s1.append("1234");
		System.out.println(s1.length()+":"+s1.capacity());
	}

	public static void createRandomNumber(int num) {
		Random rand = new Random();
		for (int i = 0; i < num;) {
			int a = rand.nextInt(1000);
			int b = rand.nextInt(1000);
			print(a,b);
			if(a > b){
				print("a>b");
			}else if(a == b){
				print("a=b");
			}else
				print("a<b");		
			i+=2;		
		}	
	}
	public static void printNumber(int i) {
		for (int j = 1; j <= i; j++) {
			print(j);
		}
	}
	
	
	
	
	

}
