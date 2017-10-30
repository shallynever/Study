package downloadnetworksource;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.URL;
import java.net.URLConnection;

public class DownLoadThread implements Runnable{
	private long starPos;//下载的开始位置
	private long endPos;//下载的结束位置
	private File saveFile;//文件保存
	private URL url;//下载的URL
	private long curPos;//当前下载的位置
	
	DownLoadThread(long starPos, long endPos, File saveFile, URL url) {
		super();
		this.starPos = starPos;
		this.endPos = endPos;
		this.saveFile = saveFile;
		this.url = url;
		curPos = starPos;
	}
	@Override
	public void run(){
		System.out.println(Thread.currentThread().getName()+"启动成功");
		this.download();
		System.out.println(Thread.currentThread().getName()+"执行结束");

	}
	public synchronized void download() {
		RandomAccessFile fos = null;
		byte[] buf = new byte[256];
		URLConnection conn;
		BufferedInputStream bis = null;
		try {
			//创建一个新的连接，设置下载的开始和结束位置
			conn = url.openConnection();
			conn.setAllowUserInteraction(true);
			conn.setRequestProperty("Range", "bytes=" + starPos + "-" + endPos);
			
			//获取随机读取的下载文件模式
			fos = new RandomAccessFile(saveFile, "rw");
			fos.seek(starPos);
			
			//从网络流中读取数据，并写入到保存文件中
			bis = new BufferedInputStream(conn.getInputStream());
			while(curPos < endPos){
				int len = bis.read(buf, 0, 256);
				if(len == -1){
					break;
				}
				fos.write(buf, 0, len);
				curPos = curPos + len;
			}
			System.out.println("当前执行线程"+Thread.currentThread().getName()+"Download " + starPos + " - " + endPos + " finish!");
			bis.close();
			fos.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{			
		}		
	}
}
