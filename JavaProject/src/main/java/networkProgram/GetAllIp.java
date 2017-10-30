package networkProgram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GetAllIp {
	
	public static List<String> list = new ArrayList<String>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		List<String> ipList = GetAllIPMethod();
		
		for (String ipStr : ipList) {
			System.out.println(ipStr);
		}
		
		
		
		
	}

	public static List<String> GetAllIPMethod() throws IOException {
		// TODO Auto-generated method stub
		String NetworkSegment = getNetworkSegment();		

		for (int i = 215; i <= 216; i++) {
			for (int j = 0; j <= 255; j++) {
				String IP = NetworkSegment + i + "." + j;
				String comand = IP + " -w 280 -n 1";
				if (CheckIP(comand)) {
					list.add(IP);
					System.out.println(IP);
				}
			}
		}
		return list;
	}

	public static boolean CheckIP(String iP) throws IOException {
		Runtime run = Runtime.getRuntime();
		
		Process process = run.exec("ping "+iP);
		
		BufferedReader buf = new BufferedReader(
				new InputStreamReader(process.getInputStream()));	
		
		StringBuffer sb = new StringBuffer();
		String temp = null;
		while((temp = buf.readLine())!= null){
			if(temp.contains("数据包")){
				sb.append(temp.trim());
			}
			
		}
		String PacketInfo = sb.toString();
		String lastRatio = PacketInfo.substring(PacketInfo.indexOf("(")+1, PacketInfo.indexOf(")")).trim();
		if("0% 丢失".equals(lastRatio)){
			return true;
		}else if("100% 丢失".equals(lastRatio)){
			return false;
		}else{
			return false;
		}	
	}

	public static String getNetworkSegment() throws IOException {
		// TODO Auto-generated method stub
						
		StringBuffer sb = new StringBuffer();
		
		Map<String, String> map = new TreeMap<String, String>();
		
		
		Runtime run = Runtime.getRuntime();
		
		Process process = run.exec("ipconfig");
		
		BufferedReader buf = new BufferedReader(new InputStreamReader(process.getInputStream()));
			
		
		String str = null;
		
		while((str = buf.readLine())!= null){
			if(!(map.containsKey("子网掩码")&&map.containsKey("默认网关"))){
				if(str.contains("子网掩码")){
					map.put("子网掩码",str.trim().substring(str.indexOf(":")-1) );
				}else if(str.contains("默认网关")){
					map.put("默认网关",str.trim().substring(str.indexOf(":")-1) );
				}	
			}			
		}
		
		String MaskStr = map.get("子网掩码");
		String GatewayStr = map.get("默认网关");
				
		String[] partMaskArr = MaskStr.split("\\.");
		int count = 0;
		for (int i = 0; i < partMaskArr.length; i++) {
			System.out.println(partMaskArr[i]);
			if("255".equals(partMaskArr[i])){
				count++;
			}
		}
		String[] partGatewayArr = GatewayStr.split("\\.");
		for (int i = 0; i < count; i++) {
			sb.append(partGatewayArr[i]+".");
		}
		
		return sb.toString();
	}
}
