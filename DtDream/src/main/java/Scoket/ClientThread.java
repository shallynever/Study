package Scoket;

import java.io.BufferedReader;
import java.io.IOException;

public class ClientThread extends Thread {
	BufferedReader br = null;
	public ClientThread(BufferedReader br){
		this.br = br;		
	}
	@Override
	public void run() {
		try {
			String line = null;
			while((line = br.readLine()) != null){
				System.out.println(line);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally{
			try {
				if(br != null){
					br.close();
				}
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	
	}
	
}
