package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class GetDemo {

	public static void main(String[] args) throws Exception {
//		GetIntaerfaceDemo();
//		GetSuperClassDemo();
		GetconstructorDemo();

	}

	public static void GetconstructorDemo() throws Exception {
		Class<?> c1 = Class.forName("reflection.Person");		
		Constructor<?> con[] = c1.getConstructors();
		
		for (Constructor<?> constructor : con) {
			Class<?> p[] = constructor.getParameterTypes();
			System.out.print("构造方法：");
			int mo = constructor.getModifiers();			
			System.out.print(Modifier.toString(mo)+" ");
			System.out.print(constructor.getName());
			System.out.print("(");
			int count = 0;
			for (Class<?> class1 : p) {
				System.out.print(class1.getName());				
				if(count<p.length-1){
					System.out.print(",");
				}				
				count++;
			}
			System.out.println("){}");			
		}		
	}

	public static void GetSuperClassDemo() throws Exception {
		Class<?> c = Class.forName("reflection.Person");		
		Class<?> cs = c.getSuperclass();
		System.out.println(cs);		
	}

	public static void GetIntaerfaceDemo() throws Exception {
		Class<?> c = Class.forName("reflection.Person");		
		Class<?> ci[] = c.getInterfaces();
		for (Class<?> class1 : ci) {
			System.out.println(class1);
		}
	}

}
