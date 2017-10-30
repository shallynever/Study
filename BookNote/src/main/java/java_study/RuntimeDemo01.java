package java_study;

public class RuntimeDemo01 {

	public static void main(String[] args) {
		
		Runtime run = Runtime.getRuntime();
		
		System.out.println(run.maxMemory());
		System.out.println(run.freeMemory());
		String str = "nihao";
		for(int i=0;i<1000;i++){
			str+=i;
		}		
		System.out.println(str);
		System.out.println(run.freeMemory());
		run.gc();
		System.out.println(run.freeMemory());
		try {
			run.exec("notepad.exe");
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
