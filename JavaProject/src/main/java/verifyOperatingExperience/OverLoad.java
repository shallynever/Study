package verifyOperatingExperience;

class BigFu{
	
}

class FuLei extends BigFu{
	
}

class ZiLei extends FuLei{
	
}
public class OverLoad {
	
	String show(String name) {
		System.out.println(name+"��������");
		return name;
	}
	public int show(int age) {
		System.out.println(age+"��������");
		return age;
	}
	
	public FuLei show() {
		System.out.println("�޲η���");
		return new FuLei();
	}
	
	public static void main(String[] args) {
		OverLoad overLoad = new OverLoad();
		
		overLoad.show();
		
		overLoad.show(22);
		
		overLoad.show("zhoujing");
	}	
}

class OvserLoadZi extends OverLoad{

	@Override
	public String show(String name) {
		return super.show(name);
	}

	@Override
	public int show(int age) {
		return super.show(age);
	}

	@Override
	public FuLei show() {
		return new FuLei();
	}

	
	
	
}
