package verifyOperatingExperience;

public class Test {	
	
	public static String username = "zhoujng";
	public static void main(String[] args){	
		
//		String username = "zhoujing";
//		下面代码有什么不妥之处:应该将可能为null的变量username写在后面
		if(username.equals("zhoujing")){}
//		较为理想的写法为:
		if("zhoujing".equals(username)){}
		
	}
	
	public boolean show(){		
		int x = 1;
		return x==1?true:false;  /*x==1本来就是boolean类型的 故而后面是多余的。*/
	}
	/*如果两个方法的参数列表完全一样，是不可以让它们的返回值不同来实现重载（Overload）
	public  static int add(int a , int b){
		return 0;
	}
	public  static float add(int a , int b){
		return 1.2;
	}*/
	

}
