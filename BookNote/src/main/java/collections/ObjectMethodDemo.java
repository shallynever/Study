package collections;

class Student{
	String name;
	int age;
	int classNum;
	public Student(){
		
	}
	public Student(String name, int age, int classNum) {
		this.name = name;
		this.age = age;
		this.classNum = classNum;
	}
	/*hasCode()方法和equals()方法必须同时重写*/
	@Override
	public int hashCode() {
		return this.name.hashCode()+Integer.valueOf(this.age).hashCode()
				+Integer.valueOf(this.classNum).hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj){
			return true;
		}
		if(obj==null){
			return false;
		}
		if(!(obj instanceof Student)){
			return false;
		}
		Student s = (Student) obj;
		if(this.name.equals(s.name) && this.age == s.age && this.classNum == s.classNum){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public String toString() {
		return "姓名:"+name+"学号:"+classNum+"年龄"+age;
	}
	
	
}
public class ObjectMethodDemo {
	public static void main(String[] args){
		Student s1 = new Student("zhoujing",25,123456);
		Student s2 = new Student("zhoujing",25,3456);
		System.out.println(s1.equals(s2));
	}

}
