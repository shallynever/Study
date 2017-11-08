package chapter4;

import static tools.Print.print;

public class LabeledFor {

	public static void main(String[] args) {
		int i = 0;
		outer:
			for(;true;)
			{
				inner:
					/* 
					 * 注意：break会中断for循环，而且在抵达for循环的末尾之前，
					 * 递增表达式(就是for循环中的步进)是不会执行的.
					 * 
					 * */
					for(;i<10;i++,print("**"))
					{
						print("i="+i);
						if(i == 2){
							print("continue");
							continue;
						}						
						if(i == 3){
							print("break");
							i++;
							break;
						}						
						if(i == 7){
							print("continue oouter");
							i++;
							continue outer;
						}						
						if(i == 8){
							print("break outer");
							break outer;
						}
						for(int k=0; k<5; k++){
							if(k == 3)
							{
								print("continue inner");
								continue inner;
							}
						}	
					}				
			}
	}
}
