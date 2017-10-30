package interview;

/*编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截
取的字符串，但要保证汉字不被截取半个，如“我 ABC”， 4，应该截取“我 AB”，
输入“我 ABC 汉 DEF”， 6，应该输出“我 ABC”，而不是“我 ABC+汉的半个”*/

import java.io.IOException;

public class CutStringByConstantByte {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String str = "我不道你xia我gsm是hai你shi那个地方那条街";
		System.out.println(CutStringMethod(str.getBytes("GBK"),12)); 
	}

	public static String CutStringMethod(byte[] bs,int count) {
		// TODO Auto-generated method stub
		int countNum = 0;
		int cutNum = 0;
		//汉字的2个字节的ASCII码都大于128,统计要截取的字节中汉字字节的数目
		for (int i = 0; i < count;i++) {
			if(bs[i]<0){  //判断是否为汉字
				countNum++;
			}
		}
		/*一个汉字是由两个字节组成的*/
		if(countNum%2==0){ //如果汉字的字节数为偶数时，则截取的字节数不变
			cutNum = count;
		}else{   //如果汉字的字节数为奇数时，则截取的字节数要少一个
			cutNum = count-1;
		}
		
		return new String(bs, 0, cutNum);
		
	}

}
