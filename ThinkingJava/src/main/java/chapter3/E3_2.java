package chapter3;
import static tools.Print.print;
/**
 * @author jing
 * 别名现象
 */

class Number
{
	float f;
}
public class E3_2 {
	public static void main(String[] args) {
		
	Number num1 = new Number();
	Number num2 = new Number();
	num1.f = 12.0f;
	num2.f = 18.0f;
	print("num1.f:"+num1.f+"\n"+"num2.f:"+num2.f);
	num1 = num2;	
	print("num1.f:"+num1.f+"\n"+"num2.f:"+num2.f);	
	num1.f = 27.0f;
	print("num1.f:"+num1.f+"\n"+"num2.f:"+num2.f);
	}

}
