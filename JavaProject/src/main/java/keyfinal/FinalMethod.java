package keyfinal;


/*使用final方法的原因有两个。
 * 第一个原因是把方法锁定，以防任何继承类修改它得含义。
 * 这是出于设计的考虑：想要确保在继承中使方法行为保持不变，并不会被覆盖。
 * 第二个原因是效率，在JAVA的早起实现中，如果将一个方法指明为final，
 * 就同意编译器将针对该方法的调用转为内嵌调用
 * */

class WithFinal
{
	@SuppressWarnings("unused")
	private final void f(){
		System.out.println("WithFinal.f()");
	}
	@SuppressWarnings("unused")
	private void g(){
		System.out.println("WithFinal.g()");
	}
}


class OverridingPrivate extends WithFinal
{
	@SuppressWarnings("unused")
	private final void f(){
		System.out.println("OverridingPrivate.f()");
	}
	@SuppressWarnings("unused")
	private void g(){
		System.out.println("OverridingPrivate.g()");
	}
}

class OverridingPrivate2 extends OverridingPrivate
{
	public final void f(){
		System.out.println("OverridingPrivate2.f()");
	}
	public void g(){
		System.out.println("OverridingPrivate2.g()");
	}
}
public class FinalMethod {
	public static void main(String[] args){
		OverridingPrivate2 op2 = new OverridingPrivate2();
		op2.f();
		op2.g();
		@SuppressWarnings("unused")
		OverridingPrivate op = op2;
		@SuppressWarnings("unused")
		WithFinal wf = op2;
		/*上面两个类都是OverrindPrivate2的父类
		但是op和wf都不能访问自己类中的方法*/
		
	}

}
