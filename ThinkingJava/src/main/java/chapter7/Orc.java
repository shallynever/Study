package chapter7;

/*Protected:包访问权限，也就是继承的类能够访问的成员*/

import static tools.Print.print;


class Villain
{
	private String name;
	protected void setName(String name){
		this.name = name;
	}
	public Villain(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "I am Villian and my name is "+name;
	}
}

public class Orc extends Villain {

	private int orcNumber;
	public Orc(String name, int orcNumber) {
		super(name);
		this.orcNumber = orcNumber;
	}
	public void change(String name, int orcNumber){
		setName(name);
		this.orcNumber = orcNumber;
	}
	@Override
	public String toString() {
		return "Orc [orcNumber=" + orcNumber + "]"+":"+super.toString();
	}
	public static void main(String[] args) {
		Orc orc = new Orc("zhoujing", 12);
		print(orc);
		orc.change("zhangge", 23);
		print(orc);
	}

}
