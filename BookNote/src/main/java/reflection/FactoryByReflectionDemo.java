package reflection;

/*
 * ���÷�����ƵĹ���ģʽ�������ŵ��ǣ����۴����������࣬�����඼�������κθı�
 * 
 * 
 * */
interface Fruit{
	public void eat();
}

class Apple implements Fruit{

	@Override
	public void eat() {
		System.out.println("eat apple");
	}
}
class Orange implements Fruit{
	
	@Override
	public void eat() {
		System.out.println("eat orange");
	}	
}
class Factory{
	public static Fruit getInstance(String classname) throws Exception{
		
		Fruit fruit = null;
		fruit = (Fruit)Class.forName(classname).newInstance();
		
		return fruit;
		
	}
}
public class FactoryByReflectionDemo {

	public static void main(String[] args) throws Exception {
		Fruit f = Factory.getInstance("reflection.Apple");
		
		
		if(f != null){
			f.eat();
		}
	}

}
