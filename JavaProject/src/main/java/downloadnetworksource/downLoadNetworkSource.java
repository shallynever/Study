package downloadnetworksource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;

public class downLoadNetworkSource {

	public static void main(String[] args) {
		for (int i = 41; i < 6667; i++) {
			 String url =
			 "http://120.52.73.46/adultvideo.science/media/videos/iphone/"+i+".mp4";
//			String url = "http://opennetlinux.org/binaries/floodlight-vm.zip";
			if (URLCheck(url)) {
				System.out.println(url + "有效");
				File file = new File("E:" + File.separator + "Link.txt");

				try {
					PrintStream put = new PrintStream(new FileOutputStream(
							file, true));
					put.print(url + "\r\n");

					put.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				DownLoadManager manager = new DownLoadManager(url);
				manager.startDownLoad();
			} else {
				System.out.println(url + "无效");
			}

		}
	}

	public static boolean URLCheck(String StrURL) {
		boolean flag = false;
		URL url;
		try {
			url = new URL(StrURL);
			@SuppressWarnings("unused")
			InputStream in = url.openStream();
			flag = true;
		} catch (Exception e) {
		}
		return flag;
	}

}
