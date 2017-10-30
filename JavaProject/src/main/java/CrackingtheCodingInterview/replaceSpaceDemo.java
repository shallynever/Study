package CrackingtheCodingInterview;

public class replaceSpaceDemo {
	
	public static String replaceSpace(String iniString, int length) {
        // write code here
        return iniString.replaceAll(" ","%20");
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(replaceSpace("zhou ja as 3ra ", "zhou ja as 3ra ".length()));
	}

}
