package bean;


public class Person implements Comparable<Object> {

	private String name;
	private int age;
	
	public Person() {
		
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());		
		System.out.println("当添加name="+this.name+":age="+this.age+"时，hahCode方法运行");
		return name.hashCode()+age;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		System.out.println("当添加name="+this.name+":age="+this.age+"时，equals方法运行");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
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
		
		return "Person:"+getName()+":"+getAge();
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Person per = (Person)o;
		System.out.println("  Person compareTo运行");
		int temp = this.age - per.age;
		return temp==0?this.name.compareTo(per.name):temp;
	}
}
