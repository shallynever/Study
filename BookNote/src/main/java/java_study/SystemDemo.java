package java_study;

public class SystemDemo {

	public static void main(String[] args) {
		/*System.getProperties().list(System.out);
		System.out.println("系统版本为："+System.getProperty("os.name")
				+System.getProperty("os.version")+"--"+System.getProperty("os.arch"));*/
		int x = Integer.parseInt("123");
		System.out.println(x);
		Integer i = new Integer("123");		
		System.out.println(i.intValue());
		
		System.out.println(Integer.toBinaryString(60));
		System.out.println(Integer.toOctalString(60));
		System.out.println(Integer.toHexString(60));


		System.out.println(Integer.toBinaryString(2));
	}

}
