package time_task;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.TimerTask;

public class MyTask1 extends TimerTask{

	@Override
	public void run() {
		File f = new File("F:"+File.separator+"test.txt");
		Reader r = null;
		try {
			r = new FileReader(f);
			int len = 0;
			char c[] = new char[(int)f.length()];
			int temp = 0;
			while((temp = r.read()) != -1){
				c[len] = (char)temp;
				len++;			
			}
			r.close();
			System.out.println("ÄÚÈÝÎª£º"+new String(c,0,len));			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

}
