package Network_Program;

import java.io.IOException;
import java.net.InetAddress;

public class IpDemo {

	public static void main(String[] args) throws IOException {
		
		InetAddress ip = InetAddress.getLocalHost();//返回本地主机的InetAddress对象
		System.out.println(ip.getAddress());//返回此 InetAddress 对象的原始 IP 地址。
		System.out.println(ip.hashCode());//返回地址的哈希值
		System.out.println(ip.getHostAddress());//获得本机对象的ip地址
		System.out.println(ip.isReachable(5000));
		
		InetAddress ip2 = InetAddress.getByName("10.20.215.84");//在给定主机名的情况下获取InetAddress对象。
		System.out.println(ip2.getCanonicalHostName());
		System.out.println("****************");
		System.out.println(ip2.toString());		
				
		System.out.println(ip2.getHostName()/*获取此 IP 地址的主机名*/+"::"+ip2.getHostAddress()/*返回 IP 地址字符串（以文本表现形式）*/);

		

	}

}
