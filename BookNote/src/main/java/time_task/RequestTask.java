package time_task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.TimerTask;

public class RequestTask extends TimerTask {
	
	String req_URL = null;
	URL url = null;
	BufferedReader buf = null;
	
	public RequestTask(String req_URL) {
		this.req_URL = req_URL;
	}
	@Override
	public void run() {
		try {
			url = new URL(req_URL);
			buf = new BufferedReader(new InputStreamReader(url.openStream()));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
