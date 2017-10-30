package neteaseprograme;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*	题目描述：
 * 		假设你去超市买苹果，现在超市有两种包装的苹果：一种一袋里面装6个苹果，另一种是一袋里面装8个苹果。
 * 		
 * 		现在假设你要买88个苹果，就有如下几种组合：
 * 			6个苹果的袋数为：0  8个苹果的袋数为：11
 *			6个苹果的袋数为：4  8个苹果的袋数为：8
 *			6个苹果的袋数为：8  8个苹果的袋数为：5
 *			6个苹果的袋数为：12  8个苹果的袋数为：2
 *		但是为了总的袋数最少，你就的选择6个苹果的袋数为：0  8个苹果的袋数为：11
 * 
 * 
 * */


public class PurchaseApple {
	
	public static void main(String[] args) throws NumberFormatException, IOException{		
		while(true){
			int n6=0;   //6个袋数
	 		int n8=0;   //8个袋数
			int Num = 0;   //苹果总的个数
			BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("请输入购买苹果的总数：");
			Num = Integer.parseInt(buf.readLine());
			
			if(Num%(8)==0){
				n6=0;
				n8=Num/8;
			}else{
				for (int i = Num/8; i >= 0; i--) {
					int temp = Num-8*i;
					if((temp%6)==0){
						if(n6==0&&n8==0){  //第一次赋值
							n6 = temp/6;
							n8 = i;
			 			}else if((n6+n8)>(i+(temp/6))){  //将此次苹果袋数的总数与上一次进行比较，如果小于上次袋数的总数，则重新赋值
			 				n6 = temp/6;
							n8 = i;
			 			}							
					}
				}
			}		
	 		System.out.println("Two最后选择："+"\r"+"6个苹果的袋数为："+n6+"  8个苹果的袋数为："+n8);		
			for (int i = 0; i < (Num/6)+1 ; i++) {
				for (int j = 0; j < (Num/8)+1; j++) {
					if((6*i+8*j)==Num){
			 			System.out.println("6个苹果的袋数为："+i+"  8个苹果的袋数为："+j);
			 			if(n6==0&&n8==0){  //第一次赋值
			 				n6=i;
			 	 			n8=j;
			 			}else if((n6+n8)>(i+j)){  //将此次苹果袋数的总数与上一次进行比较，如果小于上次袋数的总数，则重新赋值
			 				n6=i;
			 	 			n8=j;
			 			}		 			
			 		}
				}
			} 		
	 		System.out.println("最后选择："+"\r"+"6个苹果的袋数为："+n6+"  8个苹果的袋数为："+n8);	
	 		
	 		Two(Num);
			if(n6==0 && n8==0){
				System.out.println("无法购买");
			}	
		}
		
	}
	public static void Two(int Num) throws NumberFormatException, IOException{
			int n6=0;   //6个袋数
	 		int n8=0;   //8个袋数
			if(Num%(8)==0){
				n6=0;
				n8=Num/8;
			}else{
				for (int i = Num/8; i >= 0; i--) {
					int temp = Num-8*i;
					if((temp%6)==0){
						if(n6==0&&n8==0){  //第一次赋值
							n6 = temp/6;
							n8 = i;
			 			}else if((n6+n8)>(i+(temp/6))){  //将此次苹果袋数的总数与上一次进行比较，如果小于上次袋数的总数，则重新赋值
			 				n6 = temp/6;
							n8 = i;
			 			}							
					}
				}
			}		
	 		System.out.println("Two最后选择："+"\r"+"6个苹果的袋数为："+n6+"  8个苹果的袋数为："+n8);		
	}
}
