package CrackingtheCodingInterview;
import java.util.Arrays;


public class CheckStringSame {
	
	public static boolean checkSam(String stringA,String stringB){
		
		if (stringA.length() != stringB.length()) {
	            return false;
	    }
		char arraychaA[] = stringA.toCharArray();
		char arraychaB[] = stringB.toCharArray();
		
		Arrays.sort(arraychaA);
		Arrays.sort(arraychaB);
		
		if(!new String(arraychaA).equals(new String(arraychaB))){
			return false;
		}
		return true;
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkSam("zhe jiang gong shang", "shang gong zhe jiang"));
	}

}
