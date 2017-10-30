package CrackingtheCodingInterview;

public class CheckReverseEqualDemo {

	public boolean checkReverseEqual(String s1, String s2) {
		
		if(s1.length() != s2.length()){
			return false;
		}
		
		String str=s2+s2;
		if (str.contains(s1)) {
		    return true;
		}else {
		    return false;
		}
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "abc";
		String str2 = "cab";
		String str = str1+str1;
		System.out.println(str.indexOf(str2));
	}

}


