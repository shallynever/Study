package CrackingtheCodingInterview;

/*	请实现一个算法，确定一个字符串的所有字符是否全都不同。这里我们要求不允许使用额外的存储结构。
	给定一个string iniString，请返回一个bool值,True代表所有字符全都不同，False代表
	存在相同的字符。保证字符串中的字符为ASCII字符。字符串的长度小于等于3000。
*/
public class CheckDifferentString {
	
	public static boolean checkDifferent(String iniString){		
		boolean flag = true;
		int len = iniString.length();
		
		for(int i=0;i<len;i++){
			String temp = iniString.substring(i, i+1);
			String baseStr = iniString.substring(i+1, len);
			if(baseStr.indexOf(temp) != -1){
				flag = false;
				break;
			}		
		}
		return flag;	
	}
	public static void main(String[] args){
		System.out.println(checkDifferent("zhoujing"));
	}
}
