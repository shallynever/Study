package CrackingtheCodingInterview;


public class ZipperStringDemo {
	 
	
	public static String zipString(String iniString) {
		
		StringBuffer sb = new StringBuffer();
		char[] chs = iniString.toCharArray();
		int flag = 1;
		int len = chs.length;
		for(int i=0;i<len-1;i++){			
			if(chs[i] == chs[i+1] && i<len-2){
				flag++;
				continue;				
			}else if(chs[i] == chs[i+1] && i==len-2){
				sb.append(chs[i]).append(flag+1);
			}
			else if(chs[i] != chs[i+1] && i<len-2){
				sb.append(chs[i]).append(flag);
				flag = 1;
			}else if(chs[i] != chs[i+1] && i == len-2){
				sb.append(chs[i]).append(flag).append(chs[i+1]).append(flag);
				flag = 1;
			}
			
		}
		if(sb.toString().length() >= len){
			return iniString;
		}	
		return sb.toString();
	        
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(zipString("jjjjjjxxxxxxxooZLLLLLLLLQQQQQQQQQLLLLLLLLECXXXXXXXIIIIIIIIIhjjyyySSooooooooommmuuEEEEEEEEEnnnnnnnffffffAAAAAllllllllbbbbkkkkkkkkkkkkKKKKKKhhhhhhhhhooooooooooYCCCCCCOOOOOOOOOMMMMMMMMMMiiiiiivvvvvvvWWWWkkkkkkwwwwwwwMmmmmmmmmLLLwwwwwwwkkkjjjjjjttttQQQQQQQQQaaaaaaaFFFFFFFlllllllllggggggggggPPPPPPuuuuuuuuaYYYYYYwQQQFFFFFFFFFFaaaaapXXXXXXXxxxxxxQQQQQQQQQsssssGGGGfffffffddddddpppQQQQQQHHHTTTaaaaaaGGGGGGddyyyyyMhhllllllllllNNNNNNNNUUUWWWWWWLLLLLLLLLYYYYYYYYYYTTKKKKKKKKiiiiiiitttttttXXXXXXXXXLLLHZZZZZZZssssjjJJJEEEEEOOOOOttttttttttBBttttttTTTTTTTTTTrrrrttttRRRRRyyooooooaaaaaaaaarrrrrrrPPPPPPPjjPPPPddddddddddHHHHnnnnnnnnnnSSSSSSSSSSzzHHHHHHHHHddddddDDDzzzhhhhhfffffffffftttttteeeeeeeeEEEEEEEEEaaaaaaccccccccccFFFFFFFF"));
	}

}
