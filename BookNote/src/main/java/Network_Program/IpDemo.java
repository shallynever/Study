package Network_Program;

import java.io.IOException;
import java.net.InetAddress;

public class IpDemo {

	public static void main(String[] args) throws IOException {
		
		InetAddress ip = InetAddress.getLocalHost();//���ر���������InetAddress����
		System.out.println(ip.getAddress());//���ش� InetAddress �����ԭʼ IP ��ַ��
		System.out.println(ip.hashCode());//���ص�ַ�Ĺ�ϣֵ
		System.out.println(ip.getHostAddress());//��ñ��������ip��ַ
		System.out.println(ip.isReachable(5000));
		
		InetAddress ip2 = InetAddress.getByName("10.20.215.84");//�ڸ���������������»�ȡInetAddress����
		System.out.println(ip2.getCanonicalHostName());
		System.out.println("****************");
		System.out.println(ip2.toString());		
				
		System.out.println(ip2.getHostName()/*��ȡ�� IP ��ַ��������*/+"::"+ip2.getHostAddress()/*���� IP ��ַ�ַ��������ı�������ʽ��*/);

		

	}

}
