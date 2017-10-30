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
		System.out.println("���ݴ�С��"+urlcon.getContentLength());
		System.out.println("�������ͣ�"+urlcon.getContentType());
		
		String keyWord = "zhoujing �㽭���̴�ѧ";
		String encod = URLEncoder.encode(keyWord,"UTF-8");
		System.out.println("���������ݣ�"+encod);
		String decod = URLDecoder.decode(encod,"UTF-8");
		System.out.println("���������ݣ�"+decod);
		

	}

	

}
