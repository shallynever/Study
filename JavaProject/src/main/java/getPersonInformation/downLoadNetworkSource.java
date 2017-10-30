package getPersonInformation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;

public class downLoadNetworkSource {
	public static InputStream inputStream = null;
	public static URL url = null;
	public static BufferedReader buf = null;

	public static void main(String[] args) throws IOException {
		
		
		
		for (long Number = 479186; Number < 479187; Number++) {
			
			String str_URL ="http://hgnc.91wllm.com/vip/talents/preview/id/"+Number;
			 
			if (URLCheck(str_URL)) {
				
				try {
					String temp = null;	
					File save_Link = new File("F:" + File.separator+"PersonalInformation"+File.separator+"Link.txt");
					File save_Information = new File("F:" + File.separator+"PersonalInformation"+File.separator+Number+".txt");
					
					//��������
					PrintStream putLink = new PrintStream(new FileOutputStream(save_Link, true));
					putLink.print(str_URL + "\r\n");
					putLink.close();
					
					//���������Ϣ
					url = new URL(str_URL);  //�����ṩ��REST API���ʵ�ַ��ʵ����URL����				
					inputStream = url.openStream();  //��������
					buf = new BufferedReader(new InputStreamReader(inputStream));
					int flag = 0;			
					while ((temp = buf.readLine()) != null) {						
						System.out.println(temp+"\r\n");					
						
					}		
					
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				System.out.println(url + "��Ч");
			}

		}
	}

	public static boolean URLCheck(String StrURL) {
		boolean flag = false;
		URL url;
		try {
			url = new URL(StrURL);
			@SuppressWarnings("unused")
			InputStream in = url.openStream();
			flag = true;
		} catch (Exception e) {
		}
		return flag;
	}

}
