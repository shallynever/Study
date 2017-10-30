package Scoket;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private static final int SERVER_PORT = 30000;
	private Socket socket;
	private PrintStream ps;
	private BufferedReader brServer;
	private BufferedReader keyIn;
	public void init(){
		try {
			keyIn = new BufferedReader(new InputStreamReader(System.in));
			socket = new Socket("192.168.0.7", SERVER_PORT);
			
			ps = new PrintStream(socket.getOutputStream());
			brServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String tip = "";
			while(true){
				String userName = JOptionPane.showInputDialog(tip + "输入用户名");
				
				ps.println(CrazyitProtocol.USER_ROUND+userName+CrazyitProtocol.USER_ROUND);
				
				String result = brServer.readLine();
				
				if(result.equals(CrazyitProtocol.NAME_REP)){
					tip = "用户名重复！";
					continue;
				}
				if(result.equals(CrazyitProtocol.LOGIN_SUCCESS)){
					
					break;				
				}
			}
		} 
		catch (UnknownHostException e) {
			System.out.println("找不到服务器，请确定服务器已经开启");
			closeRs();
			System.exit(1);
		}
		catch(IOException ex){
			System.out.println("网络异常！请重新登陆");
			closeRs();
			System.exit(1);
		}
		new ClientThread(brServer).start();
	}
	private void readAndSend(){
		try {
			String line = null;
			while((line = keyIn.readLine()) != null){
				if(line.indexOf(":") > 0 && line.startsWith("//")){
					line = line.substring(2);
					ps.println(CrazyitProtocol.PRIVATE_ROUND + 
							line.split(":") [0] + CrazyitProtocol.SPLIT_SIGN +
							line.split(":") [1] +CrazyitProtocol.PRIVATE_ROUND);
				}
				else
				{
					ps.println(CrazyitProtocol.MSG_ROUND + line 
							+ CrazyitProtocol.MSG_ROUND);
				}
			}
		} catch (IOException e) {
			System.out.println("网络通信异常！请重新登陆");
			closeRs();
			System.exit(1);
		}
	}
	private void closeRs() {
		try {
			if(keyIn != null){
				ps.close();
			}
			if(brServer != null){
				ps.close();
			}
			if(ps != null){
				ps.close();
			}
			if(socket != null){
				keyIn.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args){
		Client client = new Client();
		client.init();
		client.readAndSend();
	}
	
	
}
