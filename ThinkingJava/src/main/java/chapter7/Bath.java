package chapter7;
/*
 初始化引用的四种方式
	初始化方式一：在定义一个对象是初始化
	初始化方式二：在构造器中初始化
	初始化方式三：在使用之前初始化，也称为惰性初始化。在生成对象不值得以及不必每次生成对象的情况下，这种方
			    式可以减少额外的开销
	初始化方式四：实例初始化
*/
import static tools.Print.print;
class Soap
{
	private String s;
	
	public Soap() {
		print("Soap()");
		s = "Constructed";  //初始化方式二：在构造器中初始化
	}
	@Override
	public String toString() {
		return s;
	}
}
public class Bath {
	private String s1 ="zhou"; //初始化方式一：在定义一个对象是初始化
	private String s2 ="jing";
	private String s3;
	private String s4;	
	private Soap castille;
	private int i;
	private float toy;
	public Bath() {
		print("(Inside Bath)");
		s3 = "Joy"; //初始化方式二：在构造器中初始化
		toy = 3.14f;
		castille = new Soap();
	}
	{
		print("在Bath构造器中我最先运行");
		i = 47; //初始化方式四：实例初始化
	}	
	@Override
	public String toString() {
		if(s4 == null)
			s4 = "Joy"; /*初始化方式三：在使用之前初始化，也称为惰性初始化。
						在生成对象不值得以及不必每次生成对象的情况下，这种方
						式可以减少额外的开销*/
		
		return "Bath [s1=" + s1 + ", s2=" + s2 + ", s3=" + s3 + ", s4=" + s4
				+ ", castille=" + castille + ", i=" + i + ", toy=" + toy + "]";
	}
	public static void main(String[] args) {
		Bath b = new Bath();
		print(b);
	}
}
