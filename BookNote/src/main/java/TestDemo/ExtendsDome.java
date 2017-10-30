package TestDemo;


class Fu{
//	String name;
//	int age;	
	Fu(){
		show();
	}
	void show(){
		System.out.println("Fu show");
	}
}

class Zi extends Fu{
	String name = "zhoujing";
	int age = 8;
	
	Zi(){
		show();
	}
	void show(){
		System.out.println("Zi show");
	}
}

public class ExtendsDome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Zi();
	}

}
