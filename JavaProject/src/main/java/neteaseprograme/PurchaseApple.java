package neteaseprograme;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*	��Ŀ������
 * 		������ȥ������ƻ�������ڳ��������ְ�װ��ƻ����һ��һ������װ6��ƻ������һ����һ������װ8��ƻ����
 * 		
 * 		���ڼ�����Ҫ��88��ƻ�����������¼�����ϣ�
 * 			6��ƻ���Ĵ���Ϊ��0  8��ƻ���Ĵ���Ϊ��11
 *			6��ƻ���Ĵ���Ϊ��4  8��ƻ���Ĵ���Ϊ��8
 *			6��ƻ���Ĵ���Ϊ��8  8��ƻ���Ĵ���Ϊ��5
 *			6��ƻ���Ĵ���Ϊ��12  8��ƻ���Ĵ���Ϊ��2
 *		����Ϊ���ܵĴ������٣���͵�ѡ��6��ƻ���Ĵ���Ϊ��0  8��ƻ���Ĵ���Ϊ��11
 * 
 * 
 * */


public class PurchaseApple {
	
	public static void main(String[] args) throws NumberFormatException, IOException{		
		while(true){
			int n6=0;   //6������
	 		int n8=0;   //8������
			int Num = 0;   //ƻ���ܵĸ���
			BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("�����빺��ƻ����������");
			Num = Integer.parseInt(buf.readLine());
			
			if(Num%(8)==0){
				n6=0;
				n8=Num/8;
			}else{
				for (int i = Num/8; i >= 0; i--) {
					int temp = Num-8*i;
					if((temp%6)==0){
						if(n6==0&&n8==0){  //��һ�θ�ֵ
							n6 = temp/6;
							n8 = i;
			 			}else if((n6+n8)>(i+(temp/6))){  //���˴�ƻ����������������һ�ν��бȽϣ����С���ϴδ����������������¸�ֵ
			 				n6 = temp/6;
							n8 = i;
			 			}							
					}
				}
			}		
	 		System.out.println("Two���ѡ��"+"\r"+"6��ƻ���Ĵ���Ϊ��"+n6+"  8��ƻ���Ĵ���Ϊ��"+n8);		
			for (int i = 0; i < (Num/6)+1 ; i++) {
				for (int j = 0; j < (Num/8)+1; j++) {
					if((6*i+8*j)==Num){
			 			System.out.println("6��ƻ���Ĵ���Ϊ��"+i+"  8��ƻ���Ĵ���Ϊ��"+j);
			 			if(n6==0&&n8==0){  //��һ�θ�ֵ
			 				n6=i;
			 	 			n8=j;
			 			}else if((n6+n8)>(i+j)){  //���˴�ƻ����������������һ�ν��бȽϣ����С���ϴδ����������������¸�ֵ
			 				n6=i;
			 	 			n8=j;
			 			}		 			
			 		}
				}
			} 		
	 		System.out.println("���ѡ��"+"\r"+"6��ƻ���Ĵ���Ϊ��"+n6+"  8��ƻ���Ĵ���Ϊ��"+n8);	
	 		
	 		Two(Num);
			if(n6==0 && n8==0){
				System.out.println("�޷�����");
			}	
		}
		
	}
	public static void Two(int Num) throws NumberFormatException, IOException{
			int n6=0;   //6������
	 		int n8=0;   //8������
			if(Num%(8)==0){
				n6=0;
				n8=Num/8;
			}else{
				for (int i = Num/8; i >= 0; i--) {
					int temp = Num-8*i;
					if((temp%6)==0){
						if(n6==0&&n8==0){  //��һ�θ�ֵ
							n6 = temp/6;
							n8 = i;
			 			}else if((n6+n8)>(i+(temp/6))){  //���˴�ƻ����������������һ�ν��бȽϣ����С���ϴδ����������������¸�ֵ
			 				n6 = temp/6;
							n8 = i;
			 			}							
					}
				}
			}		
	 		System.out.println("Two���ѡ��"+"\r"+"6��ƻ���Ĵ���Ϊ��"+n6+"  8��ƻ���Ĵ���Ϊ��"+n8);		
	}
}
