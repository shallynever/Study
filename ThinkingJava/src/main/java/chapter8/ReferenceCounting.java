package chapter8;
import static tools.Print.print;
class Shared{
	private int refcount = 0;
	private static long counter = 0;
	private final long id = counter++;
	public Shared(){
		print("Creating"+this);
	}
	public void addRef(){
		refcount++;
	}
	protected void dispose() {
		if(--refcount == 0){
			print("dispose"+this);
		}
	}
	public String toString(){
		return "Shared"+id;
	}
} 
class Composing{
	private Shared shared;
	private static long counter = 0;
	private final long id = counter++;
	public Composing(Shared shared){
		print("Creating"+this);
		this.shared = shared;
		this.shared.addRef();  // 在将一个共享对象附着到类上时，必须记住调用addRef()
	}
	protected void dispose() {
		print("dispose"+this);
		shared.dispose();
	}
	public String toString(){
		return "Composing"+id;
	}
}
public class ReferenceCounting {

	public static void main(String[] args) {
		Shared shared = new Shared();
		Composing[] composing = {new Composing(shared),new Composing(shared),new Composing(shared),};
		for (Composing comp : composing) {
			comp.dispose();
		}
	}

}
