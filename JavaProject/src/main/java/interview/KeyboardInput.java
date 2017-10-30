package interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardInput {
	
	public static void main(String[] args)
	{
		BufferedReader buf = null;		
		buf = new BufferedReader(new InputStreamReader(System.in));		
		String str = null;
		try {
			str = buf.readLine();
			System.out.println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(str);
	}
	
	
	

}
