package chapter8;
import static tools.Print.print;
class Super{
	public int filed = 0;
	public int getFiled(){
		return filed;
	}
}
class Sub extends Super{
	 public int filed = 1;
	 public int getFiled(){
		 return filed;
	 }
	 public int getSuperFiled(){
		 return super.filed;
	 }
}
public class FiledAccess {
	public static void main(String[] args){
		Super sup = new Sub();   //向上转型
		print("sup.filed="+sup.filed+", sup.getFild()="+sup.getFiled());
		Sub sub = new Sub();
		print("sub.filed="+sub.filed+", sub.getFild()="+sub.getFiled());		
	}
}
