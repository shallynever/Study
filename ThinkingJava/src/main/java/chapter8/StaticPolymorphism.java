package chapter8;
import static tools.Print.print;

class StaticSuper{
	public static String staticGet(){
		return "Base staticGet()";
	}
	public String dynamicGet(){
		return "Base dynamicGet()";
	}
}
class StaticSub extends StaticSuper{
	public static String staticGet(){
		return "StaticSub staticGet()";
	}
	@Override
	public String dynamicGet() {
		return "StaticSub dynamicGet()";
	}
}
public class StaticPolymorphism {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		StaticSuper sup = new StaticSub();
		print(sup.staticGet());  
		//The static method staticGet() from the type StaticSuper should be accessed in a static way
		print(sup.dynamicGet());
	}

}
