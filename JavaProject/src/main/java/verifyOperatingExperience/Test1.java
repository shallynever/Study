package verifyOperatingExperience;


import java.util.Date;


public class Test1 extends Date{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		System.out.println(new Test1().test());
		
		
	}
	@SuppressWarnings("finally")
	public int test(){
		System.out.println(getClass().getSuperclass().getName());
		
		
		try {
			show1();
			return 1;
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			show2();
			return 3;
		}
				
	}
	public int show2() {
		// TODO Auto-generated method stub
		System.out.println("show2");
		return 2;

		
	}
	public int show1() {
		// TODO Auto-generated method stub
		System.out.println("show1");
		return 1;

		
	}
}

