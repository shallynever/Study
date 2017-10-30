package interview;

public class ReverseWord {
	public static final StringBuffer sb = new StringBuffer();
	public static void main(String[] args){
		String str = "Many People In Room GHHSAaasABt";
		String[] strArray = str.split(" ");
		for (String temp : strArray) {
			reverseArray(temp);
		}
		System.out.println(sb);
		
	}	
	public static void reverseArray(String arr) {
		// TODO Auto-generated method stub
		char[] cha = arr.toCharArray();
		for(int start=0,end=cha.length-1;start<end;end--,start++)
		{
			int[] flag = new int[cha.length];
			int index = 0;
			if(Character.isUpperCase(cha[start]) && Character.isUpperCase(cha[end]) ){  //如果交换的两个字符都是大写，则直接交换				
				char temp = cha[start];
				cha[start] = cha[end];
				cha[end] = temp;				
			}else{
				char temp = cha[start];
				if(Character.isUpperCase(temp)){
					flag[index] = start;
					index++;	
					temp = Character.toLowerCase(temp);
				}
				cha[start] = cha[end];
				cha[end] = temp;
				for (int i : flag) {
					 cha[i] =  Character.toUpperCase(cha[i]);
				}				
			}			
		}
		sb.append(new String(cha)+" ");
	}

}
