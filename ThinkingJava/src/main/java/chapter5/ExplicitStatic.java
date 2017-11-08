package chapter5;



import static tools.Print.print;

class Cup
{
	public Cup(int marker) {
		print("Cup("+marker+")");
	}
	void f(int marker){
		print("f("+marker+")");
	}
}

class Cups
{
	static Cup cup1;
	static Cup cup2;
	static{
		cup1 = new Cup(1);
		cup2 = new Cup(2);
	}
	public Cups() {
		print("Cups()");
	}
}

public class ExplicitStatic {

	public static void main(String[] args) {
		print("In main");
//		Cups.cup1.f(99);
		
		Cups.cup1.getClass();

	}

}
