package chapter7;
import static tools.Print.print;
class Art{
	Art(){
		print("Art constructor");
	}
}
class Drawing extends Art{
	Drawing(){
		print("Drawing constructor");
	}
}
public class Cartoon extends Drawing {
	public Cartoon(){
		print("Cartoon constructor");
	}
	public static void main(String[] args){
		Cartoon x = new Cartoon();
	}
}
