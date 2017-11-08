package chapter8;
import static tools.Print.print;

import java.util.Random;

class Shape{
	public void draw(){};
	public void erase(){};
}
class Circle extends Shape{
	@Override
	public void draw() {
		print("Circle.draw()");
	}
	@Override
	public void erase() {
		print("Circle.erase()");
	}	
}
class Square extends Shape{
	@Override
	public void draw() {
		print("Square.draw()");
	}
	@Override
	public void erase() {
		print("Square.erase()");
	}	
}
class Triangle extends Shape{
	@Override
	public void draw() {
		print("Triangle.draw()");
	}
	@Override
	public void erase() {
		print("Triangle.erase()");
	}	
}
class RandomShapeGenerator{
	private Random rand = new Random(20);
	public Shape next(){
		switch (rand.nextInt(3)) {
		case 0:	
			return new Circle();
		case 1:	
			return new Square();
		case 2:	
			return new Triangle();
		default:
			return null;
		}
	}
}
public class Shapes {
	private static RandomShapeGenerator gen = new RandomShapeGenerator();
	public static void main(String[] args) {
		Shape[] s = new Shape[9];
		for (int i = 0; i < s.length; i++) {
			s[i] = gen.next();
		}
		for (Shape shape : s) {
			shape.draw();
		}
	}
}
