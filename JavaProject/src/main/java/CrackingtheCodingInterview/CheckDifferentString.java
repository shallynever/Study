package CrackingtheCodingInterview;

/*	��ʵ��һ���㷨��ȷ��һ���ַ����������ַ��Ƿ�ȫ����ͬ����������Ҫ������ʹ�ö���Ĵ洢�ṹ��
	����һ��string iniString���뷵��һ��boolֵ,True���������ַ�ȫ����ͬ��False����
	������ͬ���ַ�����֤�ַ����е��ַ�ΪASCII�ַ����ַ����ĳ���С�ڵ���3000��
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
