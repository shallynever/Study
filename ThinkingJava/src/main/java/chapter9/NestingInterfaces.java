package chapter9;

import org.omg.CORBA.PRIVATE_MEMBER;

class A{
	interface B{
		void f();
	}
	public class BImp implements B{

		public void f() {
		}	
	}
	private class BImp2 implements B{
		public void f() {
		}		
	}
	public interface C{
		void f();
	}
	class CImp implements C{
		public void f() {
		}
	}
	private class CImp2 implements C{
		public void f() {
		}
	}
	private interface D{
		void f();
	}
	private class DImp implements D{
		public void f() {
		}
	}
	public class DImp2 implements D{
		public void f() {
		}
	}
	public D getD(){
		return new DImp2();
	}
	private D dRef;
	public void receiveD(D d){
		dRef = d;
		dRef.f();
	}
}

interface E{
	interface G{
		void f();
	}
	public interface H{
		void f();
	}
	void g();
	/*
	 * //The interface member type I can only be public
		private interface I{
		
		}
	*/
}
public class NestingInterfaces {
	public class BImp implements A.B{
		public void f() {
		}
	}
	class CImp implements A.C{
		public void f() {
		}	
	}
	/*
	 * //The type A.D is not visible
		class DImp implements A.D{
			@Override
			public void f() {
			}	
		}
	*/
	class EImp implements E{
		public void g() {
		}
	}
	class EGImp implements E.G{
		public void f() {
		}	
	}
	class EImp2 implements E{
		public void g() {
		}
		class EG implements E.G{
			public void f() {
			}
		}
	}
	public static void main(String[] args) {
		A a = new A();
		//A.D ad = a.getD(); //The type A.D is not visible
		//a.getD().f();   //The type A.D is not visible
		//A.DImp2 di2 = a.getD();   //Type mismatch: cannot convert from A.D to A.DImp2
		A a2 = new A();
		a2.receiveD(a.getD());
	}

}
