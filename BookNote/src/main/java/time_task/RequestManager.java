package time_task;

import java.util.Timer;

public class RequestManager {
	public static StringBuffer URL_Str = new StringBuffer();
	public static void main(String[] args){
		URL_Str.append("https://www.baidu.com/"+"flag");
		URL_Str.append("https://www.hao123.com/"+"flag");
		URL_Str.append("http://www.ifeng.com/"+"flag");
		URL_Str.append("https://www.baidu.com/s?word=test&tn=50000021_hao_pg&ie=utf-8&sc=UWY4PW64rjb1P7q1gv99UdqsuzuY5HDYPW61njnsPjm4PjThm1dCmytknWnhmynqPjfYn16sPjD1&ssl_sample=normal&srcqid=34381930165448763"+"\r\n");
		
		String[] url = URL_Str.toString().split("flag");	
		for (String req_url : url) {
			Timer t = new Timer();			
			RequestTask reqTask = new RequestTask(req_url);		
			t.schedule(reqTask, 1000, 10000);
		}		
	}

}
