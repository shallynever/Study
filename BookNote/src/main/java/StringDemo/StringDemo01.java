package StringDemo;

public class StringDemo01 {
	public static void main(String[] args){
		StringBuffer sb = new StringBuffer(" wo zai zhe li ");
		String strNew = replaceSpace(sb);
		System.out.println(strNew);
	}
	public static  String replaceSpace(StringBuffer str) {
	
		/*StringBuffer sbNew = new StringBuffer();*/
		int index = 0;
		int spaceLocation = 0;
		
		
		while(true){
			spaceLocation = str.indexOf(" ",index);
			if(spaceLocation == -1)
				break;
			str.replace(spaceLocation, spaceLocation+1, "%20");
			index = spaceLocation+1;
		}
		
		
		
		/*String[] strArray = str.toString().split(" ");
		for (int i = 0; i < strArray.length; i++) {
		    if(i<strArray.length-1)
		    	sbNew.append(strArray[i]+"%20");
		    else
		    	sbNew.append(strArray[i]);
		}*/
		
		
		return str.toString();
    }

}
