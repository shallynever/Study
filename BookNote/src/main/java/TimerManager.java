
import java.util.Calendar;  
import java.util.Date;  
import java.util.Timer;  
  
  
public class TimerManager {  
	

	//ʱ����(һ��)
	private static final long PERIOD_TIME = 1000*60;  
    public static void main(String[] args) {  
        new TimerManager();    

    }  

    public TimerManager() {  
        Calendar calendar = Calendar.getInstance();  
        Date date=calendar.getTime(); //��һ��ִ�ж�ʱ�����ʱ��  
        //�����һ��ִ�ж�ʱ�����ʱ�� С�ڵ�ǰ��ʱ��  
        //��ʱҪ�� ��һ��ִ�ж�ʱ�����ʱ���һ�죬�Ա���������¸�ʱ���ִ�С��������һ�죬���������ִ�С�  
        Timer timer = new Timer();  
        Task task = new Task();  
        //����ָ��������ָ����ʱ�俪ʼ�����ظ��Ĺ̶��ӳ�ִ�С�  
        timer.schedule(task,date,PERIOD_TIME);    
    }  
}  