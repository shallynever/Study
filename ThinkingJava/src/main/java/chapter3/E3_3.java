package chapter3;
import static tools.Print.print;
/**
 * @author jing
 * ���������еı�������
 */
class Letter
{
	char c;
}

public class E3_3 {
	
	public static void f(Letter l)
	{
		l.c = 'w';
	}
	public static void main(String[] args) 
	{
		Letter x = new Letter();
		x.c = 'a';
		print("x.c:"+x.c);
		f(x);
		print("x.c:"+x.c);		
	}

}
