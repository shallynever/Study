package chapter8;
import static tools.Print.print;

class Meal{
	Meal(){
		print("Meal()");
	}
}
class Bread{
	Bread(){
		print("Bread()");
	}
}
class Cheese{
	Cheese(){
		print("Cheese()");
	}
}
class Lettuce{
	Lettuce(){
		print("Lettuce()");
	}
}
class Lunch extends Meal{
	Lunch(){
		print("Lunch()");
	}
}
class PortableLunch extends Lunch{
	PortableLunch(){
		print("PortableLunch()");
	}
}
public class Sandwich extends PortableLunch{
	@SuppressWarnings("unused")
	private Bread b = new Bread();
	@SuppressWarnings("unused")
	private Cheese c = new Cheese();
	@SuppressWarnings("unused")
	private Lettuce l = new Lettuce();
	public Sandwich(){
		print("Sandwich()");
	}
	public static void main(String[] args) {
		new Sandwich();
	}
}
