package chapter8;
import static tools.Print.print;
enum Note{
	MIDDLE_C,C_SHARP,B_FLAT;
}
class Instrument{
	public void play(Note n){
		print("Instrument.play()");
	}
	String what(){
		return "Instrument";
	}
	void adjust(){
		print("Adjust Instrument");
	}
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
	void adjust() {
		print("Adjust Wind");
	}	
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
	void adjust() {
		print("Adjust Percussion");
	}	
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
	void adjust() {
		print("Adjust Stringed");
	}	
}
class Brass extends Wind{
	@Override
	public void play(Note n) {
		print("Brass.play()"+n);
	}	
	@Override
	void adjust() {
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
public class Music {	
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
