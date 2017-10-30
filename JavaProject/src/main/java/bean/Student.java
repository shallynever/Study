package bean;

public class Student extends Person/* implements Comparable*/{
	@SuppressWarnings("unused")
	private String ID;
	public Student() {
				
	}
	public Student(String ID) {
		this.ID = ID;
	}

	@Override
	public String toString() {		
		return "Student:"+getName()+":"+getAge();
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
//		Student st = (Student)o;
		System.out.println("  Student compareTo‘À––");
//		return Integer.parseInt(this.ID)-Integer.parseInt(st.ID);
		return 1;
	}
}
