package chapter7;
import static tools.Print.print;
class Homer{
	char doh(char c){
		print("Homer_doh(char c)");
		return 'd';
	}
	float doh(float f){
		print("Homer_doh(float)");
		return 1.0f;
	}
}
class Milhouse{}
class Bart extends Homer{
	@Override
	char doh(char c){
		print("Bart_doh(char c)");
		return 'd';
	}
	
	void doh(Milhouse m){
		print("doh(Milhouse m)");
	}
}
public class Hide {

	public static void main(String[] args) {
		Bart b = new Bart();
		b.doh(1);
		b.doh('c');
		b.doh(new Milhouse());
		
	}

}
