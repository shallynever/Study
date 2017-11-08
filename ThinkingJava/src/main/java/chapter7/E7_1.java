package chapter7;

import static tools.Print.print;

class Simple
{
	private String s;

	public Simple(String s) {
		this.s = s;
	}
	@Override
	public String toString() {
		return s;
	}
	public void setString(String sNew){
		s = sNew;
	}
}

class Second
{
	Simple simple;
	String s;
	
	public Second(String s) {
		this.s = s;
	}
	public void check(){
		if(simple == null)
			print("not initialized");
		else
			print("initialized");
	}
	
	private Simple lazy(){
		if(simple == null){
			print("Create Simple");
			simple = new Simple(s);
		}	
		return simple;
	}
	
	public Simple getSimple(){
		return lazy();
	}
	@Override
	public String toString() {
		return lazy().toString();
	}
	public void setSimple(String sNew){
		lazy().setString(sNew);
	}
}

public class E7_1 {

	public static void main(String[] args) {
		Second second = new Second("zhoujing");
		second.check();
		print(second.getSimple());
		second.check();
		print(second);
		second.setSimple("new zhoujing");
		print(second);
	}
}
