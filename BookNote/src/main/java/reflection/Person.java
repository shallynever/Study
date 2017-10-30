package reflection;



interface China{
	public static final String NATIONAL = "CHINA";
	public static final String AUTHOR = "ZHOUJING";
	public void sayChina();
	public String sayHello(String name, int age);
}

public class Person implements China {
	private String name;
	private int age;
	
	public Person(String name) {
		this.name = name;
	}
	public Person(int age) {
		this.age = age;
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		
		return "姓名:"+this.name+" ==>年龄:"+this.age;
	}
	@Override
	public void sayChina() {
	
		System.out.println("作者："+AUTHOR+",国籍"+NATIONAL);
	}
	@Override
	public String sayHello(String name, int age) {
		
		return "my name is:"+this.name+":"+this.age;
	}
	

}
