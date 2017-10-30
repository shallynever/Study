package keyfinal;


/*ʹ��final������ԭ����������
 * ��һ��ԭ���ǰѷ����������Է��κμ̳����޸����ú��塣
 * ���ǳ�����ƵĿ��ǣ���Ҫȷ���ڼ̳���ʹ������Ϊ���ֲ��䣬�����ᱻ���ǡ�
 * �ڶ���ԭ����Ч�ʣ���JAVA������ʵ���У������һ������ָ��Ϊfinal��
 * ��ͬ�����������Ը÷����ĵ���תΪ��Ƕ����
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
		/*���������඼��OverrindPrivate2�ĸ���
		����op��wf�����ܷ����Լ����еķ���*/
		
	}

}
