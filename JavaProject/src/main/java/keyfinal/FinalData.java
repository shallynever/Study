package keyfinal;

import java.util.Random;

/*finalÊý¾Ý*/

class Value
{
	int i ;
	public Value(int i) {
		this.i = i;
	}
}

public class FinalData {
	
	private static Random rand = new Random(50);
	private String id;
	public FinalData(String id){
		this.id = id;	
	}
	
	@SuppressWarnings("unused")
	private final int valueOne = 9;
	
	@SuppressWarnings("unused")
	private static int VALUE_TTWO = 21;
	public static int VALUE_THREE = 34;
	private final int i4 = rand.nextInt(20);
	static final int  INT_5 = rand.nextInt(20);
	
	@SuppressWarnings("unused")
	private Value v1 = new Value(11);
	private final Value v2 = new Value(22);
	
	@SuppressWarnings("unused")
	private static final Value V3 = new Value(33);
	
	private final int[] a = {1,2,3,4,5,6};
		
	@Override
	public String toString() {
		return id+":"+"i4="+i4+",INT_5="+INT_5;
	}
	
	public static void main(String[] args) {
		FinalData fd = new FinalData("fd1");
//		fd.valueOne++;  Error:can't change value of final
		fd.v2.i++;    
//		fd.v2 = new Value(9);  Error 
		fd.v1 = new Value(10);
		
		for (int i = 0; i < fd.a.length; i++) {
			fd.a[i]++;
		}		
	}

}
