package time_task;

import java.util.Timer;

public class TestTask1 {

	public static void main(String[] args) {
		
		Timer t1 = new Timer();
		
		MyTask1 mytask1 = new MyTask1();
		
		
		t1.schedule(mytask1, 1000, 5000);
	}

}
