package reflection;

import java.lang.reflect.Constructor;

public class InstanceDemo {

	public static void main(String[] args) throws Exception {
		
//		InstanceDemo1();
		InstanceDemo2();

	}
			
	public static void InstanceDemo2() throws Exception {
		
		Class<?> c = null;
		c  = Class.forName("reflection.Person");
		
		Person per = null;
		Constructor<?> cons[] = null;
		cons = c.getConstructors();
		for (Constructor<?> constructor : cons) {
			System.out.println(constructor+":"+constructor.getParameterCount());
		}
		Constructor<?> constructor = null;
		constructor = c.getConstructor(String.class,int.class);
		
		per = (Person)constructor.newInstance("÷‹æ¥",23);
		System.out.println(per);
		
		
		
	}

	public static void InstanceDemo1() throws Exception {
		Class<?> c = null;
		c = Class.forName("reflection.Person");
		
		Person per = null;
		
		per = (Person)c.newInstance();
			
		per.setAge(25);
		per.setName("zhoujing");
		
		System.out.println(per);
	
	
	}

}
