package verifyOperatingExperience;

class Base {
    
    private String name = "base";

    public Base() {
        tellName();
        printName();
    }
    public void tellName() {
        System.out.println("Base tell name: " + name);
    }
    public void tellName(String str1) {
    	System.out.println("Base tell name: " + name);
    }
    public void tellName(String str1 , String str2) {
    	System.out.println("Base tell name: " + name);
    }
    
    public void printName() {
        System.out.println("Base print name: " + name);
    }
}

abstract class di extends Base{
	
}
class Dervied extends Base {

    private String name = "dervied";

    public Dervied() {
        tellName();
        printName();
    }
    
    public void tellName() {
        System.out.println("Dervied tell name: " + name);
    }
    
    public void printName() {
        System.out.println("Dervied print name: " + name);
    }  
}

class Fu
{
	public static  void show()
	{
		System.out.println("fu show run");
	}
}
class  Zi extends Fu
{
	public static void show()
	{
		System.out.println("Zi show run");
	}
}


public class OverrideTest {

	public static void main(String[] args) {
		
//		new Dervied();
		
		new Base();
		int[] num = {1,2,3,4};
		num.clone();
		
		Zi.show();
	}

}
