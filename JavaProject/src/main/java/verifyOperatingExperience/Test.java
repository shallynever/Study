package verifyOperatingExperience;

public class Test {	
	
	public static String username = "zhoujng";
	public static void main(String[] args){	
		
//		String username = "zhoujing";
//		���������ʲô����֮��:Ӧ�ý�����Ϊnull�ı���usernameд�ں���
		if(username.equals("zhoujing")){}
//		��Ϊ�����д��Ϊ:
		if("zhoujing".equals(username)){}
		
	}
	
	public boolean show(){		
		int x = 1;
		return x==1?true:false;  /*x==1��������boolean���͵� �ʶ������Ƕ���ġ�*/
	}
	/*������������Ĳ����б���ȫһ�����ǲ����������ǵķ���ֵ��ͬ��ʵ�����أ�Overload��
	public  static int add(int a , int b){
		return 0;
	}
	public  static float add(int a , int b){
		return 1.2;
	}*/
	

}
