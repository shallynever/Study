package tools;

public class Print {
	@SafeVarargs
	public static <P> void print(P... p)	//·ºÐÍ
	{
		/*for (int i = 0; i < p.length; i++) {
			System.out.println(p[i]);
		}*/
		
		for(P x : p)
		{
			System.out.println(x);
		}
		
		
	}
}
