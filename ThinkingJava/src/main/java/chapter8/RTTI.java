package chapter8;
class Useful{
	public void f(){}
	public void g(){}
}
class MoreUseful extends Useful{
	@Override
	public void f() {}
	@Override
	public void g() {}
	public void u(){};
	public void v(){};
	
}
public class RTTI {
	public static void main(String[] args) {
		Useful[] x = {new Useful(),new MoreUseful()};
		x[0].f();
		x[1].g();
//		x[1].u();   //The method u() is undefined for the type Useful
		((MoreUseful)x[1]).u();   //向下转型
	}
}
