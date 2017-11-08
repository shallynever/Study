package chapter9;
import static tools.Print.print;
interface Service{
	void method1();
	void method2();
}

interface ServiceFactories{
	Service getService();
}

class Implementation1 implements Service{
	public Implementation1() {
	}
	@Override
	public void method1() {
		print("Implementation1 method1()");
	}
	@Override
	public void method2() {
		print("Implementation1 method2()");
	}	
}

class Implementation1Factory implements ServiceFactories{

	@Override
	public Service getService() {
		return new Implementation1();
	}
}
class Implementation2 implements Service{
	public Implementation2() {
	}
	@Override
	public void method1() {
		print("Implementation2 method1()");
	}
	@Override
	public void method2() {
		print("Implementation2 method2()");
	}	
}
class Implementation2Factory implements ServiceFactories{

	@Override
	public Service getService() {
		return new Implementation2();
	}
}
public class Factories {
	
	public static void serviceConsumer(ServiceFactories fact){
		Service s = fact.getService();
		s.method1();
		s.method2();
	}	
	public static void main(String[] args) {
		serviceConsumer(new Implementation1Factory());
		serviceConsumer(new Implementation2Factory());
	}

}
