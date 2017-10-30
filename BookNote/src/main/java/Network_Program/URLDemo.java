package Network_Program;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDemo {

	public static void main(String[] args) throws IOException {
		
		URL url = new URL("http://www.hao123.com");
		System.out.println(url.openConnection().getContent().toString());
		URLConnection urlcon = url.openConnection();
		System.out.println("内容大小："+urlcon.getContentLength());
		System.out.println("内容类型："+urlcon.getContentType());
		
		String keyWord = "zhoujing 浙江工商大学";
		String encod = URLEncoder.encode(keyWord,"UTF-8");
		System.out.println("编码后的内容："+encod);
		String decod = URLDecoder.decode(encod,"UTF-8");
		System.out.println("解码后的内容："+decod);
		

	}

	

}
