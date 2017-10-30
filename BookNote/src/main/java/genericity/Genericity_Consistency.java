package genericity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Point<T>
{
	private T x;
	private T y;
	public T getX() {
		return this.x;
	}
	public void setX(T x) {
		this.x = x;
	}
	public T getY() {
		return this.y;
	}
	public void setY(T y) {
		this.y = y;
	}	
}

public class Genericity_Consistency {

	public static void main(String[] args) throws Exception, IOException {

		BufferedReader buf = null;
		Point<Integer> p = new Point<Integer>();		
		int setx;
		int sety;
		
		System.out.print("������X������ֵ:");
		buf = new BufferedReader(new InputStreamReader(System.in));
		setx = Integer.parseInt(buf.readLine());
		System.out.print("������Y������ֵ:");
		buf = new BufferedReader(new InputStreamReader(System.in));
		sety = Integer.parseInt(buf.readLine());
		
		p.setX(setx);
		p.setY(sety);
		int x = p.getX();
		int y = p.getY();
			
		System.out.println("������ʾ��x����Ϊ��"+x);
		System.out.println("������ʾ��y����Ϊ��"+y);	
	}

}
