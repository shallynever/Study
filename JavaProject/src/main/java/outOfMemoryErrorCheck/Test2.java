package outOfMemoryErrorCheck;

class JavaVMStackSOF{
	int stackLenght = 1;
	
	public void stackLeak(){
		stackLenght++;
		stackLeak();
	}	
}


public class Test2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JavaVMStackSOF oom = new JavaVMStackSOF();
		try {
			oom.stackLeak();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("StackLenght:"+oom.stackLenght);
		} 
		
	}

}
