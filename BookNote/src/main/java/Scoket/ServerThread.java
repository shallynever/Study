package Scoket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread extends Thread {
	private Socket socket;
	BufferedReader br = null;
	PrintStream ps = null;
	public ServerThread(Socket socket) {
		
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
			 br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			 ps = new PrintStream(socket.getOutputStream());
			 String line = null;
			 while((line = br.readLine()) != null){
				 
				if(line.startsWith(CrazyitProtocol.USER_ROUND) 
						&& line.endsWith(CrazyitProtocol.USER_ROUND))
				{
					String usrName = getRealMag(line);
					if(Server.clients.map.containsKey(usrName)){
						System.out.println("用户名重复");
						ps.println(CrazyitProtocol.NAME_REP);	
					}
					else
					{
						System.out.println("登陆成功");
						ps.println(CrazyitProtocol.LOGIN_SUCCESS);
						Server.clients.put(usrName, ps);
					}
				}
				else if(line.startsWith(CrazyitProtocol.PRIVATE_ROUND) 
						&& line.endsWith(CrazyitProtocol.PRIVATE_ROUND))
				{
					String usrAndMsg = getRealMag(line);
					
					String user = usrAndMsg.split(CrazyitProtocol.SPLIT_SIGN)[0];
					String msg = usrAndMsg.split(CrazyitProtocol.SPLIT_SIGN)[1];
				
					Server.clients.map.get(user).println(Server.clients.getKeyByValue(ps)+"::::"+msg);				
				}
				else
				{
					String msg = getRealMag(line);
					for(PrintStream clientPs : Server.clients.valueSet())
					{
						clientPs.println(Server.clients.getKeyByValue(ps)+"对大家说:"+msg);
					}
				}
			 }
			
		} 
		catch (IOException e) 
		{
			Server.clients.removeByValue(ps);
			System.out.println(Server.clients.map.size());
			try {
				if(br != null)
				{
					br.close();					
				}
				if(ps != null)
				{
					ps.close();					
				}
				if(socket != null)
				{
					socket.close();					
				}
				
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		
		
	}
	private String getRealMag(String line) {
		
		return line.substring(CrazyitProtocol.PROTOCOL_LEN, 
				line.length()-CrazyitProtocol.PROTOCOL_LEN);
	}

}
