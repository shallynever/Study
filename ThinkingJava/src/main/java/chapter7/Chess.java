package chapter7;
import static tools.Print.print;
class Game{
	Game(int i){
		print("Game constructor");
	}
}
class BoardGame extends Game{
	BoardGame(int i){
		super(i);
		print("Game constructor");
	}
}
public class Chess extends BoardGame {
	Chess(){
		super(11);
		print("Chess Constructor");
	}
	public static void main(String[] args){
		Chess x = new Chess();
	}
}
