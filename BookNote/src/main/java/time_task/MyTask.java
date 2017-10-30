package time_task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.TimerTask;

public class MyTask extends TimerTask {
	
	@Override
	public void run() {
		
		File f = new File("F:"+File.separator+"test.txt");
		Writer out = null;
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));	
		String str = null;		
		try {
			out = new FileWriter(f, true);
			
			str = buf.readLine();
			out.write(str);
			out.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	
	}
	
	

}
