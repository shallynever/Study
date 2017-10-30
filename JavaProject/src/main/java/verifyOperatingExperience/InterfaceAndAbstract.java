package verifyOperatingExperience;

import verifyOperatingExperience.C.InnerD;


interface A{
	public abstract void show();
	public static final String name = "zhoujing";
}

abstract class B implements A{
	public abstract void show1();
}

class C extends B{

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	static class InnerD{
		static String str = "zhoujing";
		static void show(String name){
			System.out.println(str+name);
		}
	}
	@Override
	public void show1() {
		// TODO Auto-generated method stub
		
	}
	
}



public class InterfaceAndAbstract {
	public static void main(String[] args){
//		new C.InnerD();
		InnerD.show(A.name);
		
	}
}
