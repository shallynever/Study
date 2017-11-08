package chapter9;
import static tools.Print.print;
enum Note{
	MIDDLE_C,C_SHARP,B_FLAT;
}
abstract class Instrument{
	public abstract void play(Note n);
	String what(){
		return "Instrument";
	}
	public abstract void adjust();
}
class Wind extends Instrument{
	@Override
	public void play(Note n) {
		print("Wind.play()"+n);
	}
	@Override
	String what() {
		return "Wind";
	}
	@Override
	public void adjust() {}	
}
class Percussion extends Instrument{
	@Override
	public void play(Note n) {
		print("Percussion.play()"+n);
	}
	@Override
	String what() {
		return "Percussion";
	}
	@Override
	public void adjust() {}	
}
class Stringed extends Instrument{
	@Override
	public void play(Note n) {
		print("Stringed.play()"+n);
	}	
	@Override
	String what() {
		return "Stringed";
	}
	@Override
	public void adjust() {}	
}
class Brass extends Wind{
	@Override
	public void play(Note n) {
		print("Brass.play()"+n);
	}	
	@Override
	public void adjust() {
		print("Adjust Brass");
	}	
}
class Woodwind extends Wind{
	@Override
	public void play(Note n) {
		print("Woodwind.play()"+n);
	}	
	@Override
	String what() {
		return "Woodwind";
	}
}


public class AbstractMusic {

	public static void tune(Instrument i){
		i.play(Note.MIDDLE_C);
	}
	public static void tuneAll(Instrument[] e){
		for (Instrument i : e) {
			tune(i);
		}
	}
	public static void main(String[] args) {
		Instrument[] orchestra = {new Wind(),new Percussion(),
									new Stringed(),new Brass(),new Woodwind()};
		tuneAll(orchestra);
	}

}
