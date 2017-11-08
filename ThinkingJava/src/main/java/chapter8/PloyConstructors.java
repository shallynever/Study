package chapter8;
import static tools.Print.print;
class Glyph{
	void draw(){
		print("Glyph.draw()");
	}
	Glyph(){
		print("Glyph() before draw()");
		draw();
		print("Glyph() after draw()");
	}
}
class RoundGlyph extends Glyph{
	private int radius = 1;
	public RoundGlyph(int r) {
		radius = r;
		print("RoundGlyph.RoundGlyph(),radius="+radius);
	}
	void draw(){
		print("RoundGlyph.draw(),radius="+radius);
	}
}
public class PloyConstructors {

	public static void main(String[] args) {
		new RoundGlyph(5);
	}

}
