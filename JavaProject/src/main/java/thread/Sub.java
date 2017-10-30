package thread;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Stack;



public class Sub{
	
	
	public static void main(String[] args) throws Exception{
		System.out.println(URLDecoder.decode("%3A%2F%2B","UTF-8"));
		System.out.println(URLDecoder.decode("%3D%3D","UTF-8"));
		System.out.println(URLDecoder.decode("%25","UTF-8"));
		System.out.println(URLDecoder.decode("%B8%DF%C1%BD%C3%D7%CB%C4%BF%ED%D2%BB%C3%D7%B6%FE%CA%C7%BC%B8%C6%BD%B7%BD","gbk"));
		System.out.println(URLDecoder.decode("%E7%BD%91%E6%98%93%E4%BA%91%E9%9F%B3%E4%B9","UTF-8"));
		System.out.println(URLDecoder.decode("%BA%BC%D6%DD","gbk"));

		
		System.out.println(URLDecoder.decode("%BB%AA%CE%AA%BA%BC%D6%DD%D1%D0%BE%BF%CB%F9","gbk"));
		System.out.println(URLDecoder.decode("%E8%85%BE%E8%AE%AF%C2%B7%E5%A4%A7%E6%B5%99%E7%BD%91%20-%20%E6%B5%99%E6%B1%9F%E5%9F%8E%E5%B8%82%E7%94%9F%E6%B4%BB%E9%97%A8%E6%88%B7","utf-8"));
		
		System.out.println(URLDecoder.decode("%CA%B3%EA%AA%D6%AE%C1%E9%B5%DA%B6%FE%BC%BE","GBK"));
		System.out.println(URLDecoder.decode("%BB%F0%D0%C7%D2%EC%D6%D6%B5%DA%B6%FE%BC%BE","GBK"));
		System.out.println(URLDecoder.decode("%E6%98%AF%E5%90%A6%E7%99%BB%E5%BD%95%7C%E5%B7%B2%E7%99%BB%E5%BD%95%7C","UTF-8"));
		System.out.println(URLDecoder.decode("%E6%B5%99%E6%B1%9F%E7%9C%81,%E6%9D%AD%E5%B7%9E%E5%B8%82","UTF-8"));
		System.out.println(URLDecoder.decode("%3D%E5%9F%BA%E4%BA%8EP2P%E7%9A%84%E7%A4%BE%E5%8C%BA%E5%9E%8B%E8%B5%84%E6%BA%90%E5%85%B1%E4%BA%AB%E6%A8%A1%E5%9E%8B","UTF-8"));
		System.out.println(URLDecoder.decode("%E7%99%BD%E5%B2%A9%E6%9D%BE","UTF-8"));
		System.out.println(URLDecoder.decode("%E5%8D%95%E6%9C%BA%E6%B8%B8%E6%88%8F%E9%80%97%E6%B8%B8&pn=70&oq=%E5%8D%95%E6%9C%BA%E6%B8%B8%E6%88%8F%E9%80%97%E6%B8%B8","UTF-8"));
		System.out.println(URLDecoder.decode("%E6%B0%B4%E6%B5%92%E4%BC%A0","UTF-8"));
		System.out.println(URLDecoder.decode("%E6%9C%89%E6%95%88%E5%87%8F%E8%BD%BB%E7%97%9B%E7%BB%8F","UTF-8"));
		System.out.println(URLDecoder.decode("%e6%b8%9d%e5%8c%97%e4%b8%a4%e8%b7%af%e5%ae%ab%e9%a2%88%e7%99%8c%e8%83%bd%e6%b2%bb%e7%96%97%e5%a5%bd%e5%90%97","UTF-8"));
		System.out.println(URLDecoder.decode("%E5%91%A8%E6%95%AC","UTF-8"));
		System.out.println(URLDecoder.decode("%2F%E6%AF%95%E4%B8%9A%E8%AE%BA%E6%96%87%E8%AE%B0%2F%E6%AF%95%E4%B8%9A%E8%AE%BA%E6%96%87%E8%BF%9B%E5%BA%A6%E6%8A%A5%E5%91%8A%2F%E5%91%A8%E6%95%AC%E2%80%94%E2%80%94%E5%A4%A7%E8%AE%BA%E6%96%87%E8%BF%9B%E5%BA%A6%E6%8A%A5%E5%91%8A%E2%80%94%E2%80%94%765%2Edocx","UTF-8"));
		System.out.println(URLDecoder.decode("%2F%E7%A0%94%E7%A9%B6%E7%94%9F%E8%B5%84%E6%96%99%2F%E7%A1%95%E5%A3%AB%E8%AE%BA%E6%96%87%2F%E5%A4%A7%E8%AE%BA%E6%96%87%2F%E5%85%83%E8%83%BD%E5%8A%9B%E5%88%9B%E5%BB%BA%E6%B5%81%E7%A8%8B%2E","UTF-8"));
		System.out.println(URLDecoder.decode("%E9%A6%96%E9%A1%B5*web%E7%AB%AF%E6%80%BB%E5%85%B1query%E6%95%B0","UTF-8"));
		
		String data = "%5B%7B%22key%22%3A%22%E6%96%B0%E4%B8%89%E5%9B%BD%22%7D%2C%7B%22key%22%3A%22%E4%B8%89%E5%9B%BD%E6%BC%94%E4%B9%89%22%7D%2C%7B%22key%22%3A%22%E5%A4%A7%E5%A3%B0%E8%AF%B4%E5%87%BA%E6%9D%A5%22%7D%2C%7B%22key%22%3A%22hello%22%7D%2C%7B%22key%22%3A%22%E8%80%81%E4%B9%9D%E9%97%A8%22%7D%5D";
		System.out.println(URLDecoder.decode(URLDecoder.decode(data,"UTF-8"),"UTF-8"));
		
       
	}
	private static void testMethod(){
        System.out.println("testMethod");
   }
	public static String BinaryToHexStr(byte[] byteArr) {
		StringBuffer sb = new StringBuffer();
		int temp = 0;	
		ByteArrayInputStream byteInput = new ByteArrayInputStream(byteArr);
		while((temp=byteInput.read())!= -1){
			sb.append(DecimalToHexStr(temp));
		}
		if(sb.length() == 0){
			sb.append("0");
		}
		return sb.toString();
	}
	public static String DecimalToHexStr(int num) {
		StringBuffer sb = new StringBuffer();
		String digths = "0123456789abcdef";			
		Stack<Character> s = new Stack<Character>();
		while(num != 0)
		{
			s.push(digths.charAt(num%16));
			num/=16;
		}
		while(! s.isEmpty())
		{
			sb.append(s.pop());
		}
		return sb.toString();
	}
	
	
	
}