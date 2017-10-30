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
			
			//��ȡ�ļ���,�����ļ�����·��
			String FileName = downLoadURL.substring(downLoadURL.lastIndexOf("/")+1);
			String pathName = "E:"+File.separator+"DownLoad"+File.separator+FileName;
			File file = new File(pathName);
			
			
			//�ָ��������������߳�
			double Size = (38973688/37.1);
			System.out.println("�����ļ��ܳ���"+contentLength+"�ļ���С:"+contentLength/Size);
//			long sublen = contentLength/4;
//			System.out.println("ÿ���߳������ļ�����"+sublen);
//			for (int i = 0; i < 4; i++) {
//				long startPos = sublen*i;
//				long endPos = sublen*(i+1)-1;
//				DownLoadThread thread = new DownLoadThread(startPos,endPos,file,url);			
//				new Thread(thread,"�����߳�"+i).start();
//				Thread.sleep(1000);
//			}
			//��������
			if((contentLength/Size)<=20){
				long startPos = 0;
				long endPos = contentLength;
				DownLoadThread thread = new DownLoadThread(startPos,endPos,file,url);			
				Thread downloadThread = new Thread(thread,"�����߳�");
				downloadThread.start();
				downloadThread.join();
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
