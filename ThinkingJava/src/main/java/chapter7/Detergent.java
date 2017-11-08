package chapter7;

import static tools.Print.print;

class Cleanser
{
	private String s = "Cleanser"+"\n";
	public void append(String s1){
		s += s1;
	}
	public void dilute(){
		append("dilute()"+"\n");
	}
	public void apply(){
		append("apply()"+"\n");
	}
	public void scrub(){
		append("scrub()"+"\n");
	}
	@Override
	public String toString() {
		return s;
	}
	public static void main(String[] args){
		Cleanser cleanser = new Cleanser();
		cleanser.dilute();
		cleanser.apply();
		cleanser.scrub();
		print(cleanser);
	}
}
public class Detergent extends Cleanser{
	
	@Override
	public void scrub() {	
		append("Detergent.scrub()"+"\n");
		super.scrub();
	}
	public void foam(){
		append("foam()"+"\n");
	}
	public static void main(String[] args) {
		Detergent d = new Detergent();
		d.dilute();
		d.apply();
		d.scrub();
		d.foam();
		print(d);
		print("Test the base class"+"\n");
		Cleanser.main(args);
	}

}
