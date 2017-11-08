package chapter7;
import static tools.Print.print;
class Plate{
	Plate(int i){
		print("Plate constructor");
	}
}
class DinnerPlate extends Plate{
	DinnerPlate(int i) {
		super(i);
		print("DinnerPlate constructor");
	
	}
}
class Utensil{
	Utensil(int i){
		print("Utensil constructor");
	}
}
class Spoon extends Utensil{
	Spoon(int i) {
		super(i);
		print("Spoon constructor");
	}
}
class Fork extends Utensil{
	Fork(int i){
		super(i);
		print("Fork constructor");
	}
}
class Knife extends Utensil{
	Knife(int i) {
		super(i);
		print("Knife constructor");
	}
}
class Custom{
	Custom(int i){
		print("Custom constructor");
	}
}
public class PlaceSetting extends Custom {
	private Spoon sp;
	private Fork fk;
	private Knife kf;
	private DinnerPlate pl;
	public PlaceSetting(int i) {
		super(i+1);
		sp = new Spoon(i);
		fk = new Fork(i);
		kf = new Knife(i);
		pl = new DinnerPlate(i);
		print("PlaceSetting constructor");
	}
	public static void main(String[] args) {
		PlaceSetting x = new PlaceSetting(10);
	}

}
