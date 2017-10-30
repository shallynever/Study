package downloadnetworksource;

import java.io.File;
import java.net.URL;
import java.net.URLConnection;

public class DownLoadManager {
	
private String downLoadURL;
	
	public DownLoadManager(String downLoadURL){
		super();
		this.downLoadURL = downLoadURL;
	}
	
	public void startDownLoad(){
		try {	
			
			URL url = new URL(downLoadURL);
			URLConnection connection = url.openConnection();
			int contentLength = connection.getContentLength();
			
			//获取文件名,构造文件保存路径
			String FileName = downLoadURL.substring(downLoadURL.lastIndexOf("/")+1);
			String pathName = "E:"+File.separator+"DownLoad"+File.separator+FileName;
			File file = new File(pathName);
			
			
			//分割任务，启动下载线程
			double Size = (38973688/37.1);
			System.out.println("下载文件总长度"+contentLength+"文件大小:"+contentLength/Size);
//			long sublen = contentLength/4;
//			System.out.println("每个线程下载文件长度"+sublen);
//			for (int i = 0; i < 4; i++) {
//				long startPos = sublen*i;
//				long endPos = sublen*(i+1)-1;
//				DownLoadThread thread = new DownLoadThread(startPos,endPos,file,url);			
//				new Thread(thread,"下载线程"+i).start();
//				Thread.sleep(1000);
//			}
			//整体下载
			if((contentLength/Size)<=20){
				long startPos = 0;
				long endPos = contentLength;
				DownLoadThread thread = new DownLoadThread(startPos,endPos,file,url);			
				Thread downloadThread = new Thread(thread,"下载线程");
				downloadThread.start();
				downloadThread.join();
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
