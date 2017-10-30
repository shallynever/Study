package enumeration;



enum Color{

	RED,BLUE,GREEN,HAHA;
	
}
public class EnumDemo {

	public static void main(String[] args) {
		
		Color c1 = Color.HAHA;
		System.out.println(c1);
		
		for (Color c : Color.values()) {
			System.out.println(c.ordinal()+"-->"+c.name());
		}
		
	}

}
