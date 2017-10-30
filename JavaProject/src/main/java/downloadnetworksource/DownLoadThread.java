package downloadnetworksource;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.URL;
import java.net.URLConnection;

public class DownLoadThread implements Runnable{
	private long starPos;//���صĿ�ʼλ��
	private long endPos;//���صĽ���λ��
	private File saveFile;//�ļ�����
	private URL url;//���ص�URL
	private long curPos;//��ǰ���ص�λ��
	
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
		System.out.println(Thread.currentThread().getName()+"�����ɹ�");
		this.download();
		System.out.println(Thread.currentThread().getName()+"ִ�н���");

	}
	public synchronized void download() {
		RandomAccessFile fos = null;
		byte[] buf = new byte[256];
		URLConnection conn;
		BufferedInputStream bis = null;
		try {
			//����һ���µ����ӣ��������صĿ�ʼ�ͽ���λ��
			conn = url.openConnection();
			conn.setAllowUserInteraction(true);
			conn.setRequestProperty("Range", "bytes=" + starPos + "-" + endPos);
			
			//��ȡ�����ȡ�������ļ�ģʽ
			fos = new RandomAccessFile(saveFile, "rw");
			fos.seek(starPos);
			
			//���������ж�ȡ���ݣ���д�뵽�����ļ���
			bis = new BufferedInputStream(conn.getInputStream());
			while(curPos < endPos){
				int len = bis.read(buf, 0, 256);
				if(len == -1){
					break;
				}
				fos.write(buf, 0, len);
				curPos = curPos + len;
			}
			System.out.println("��ǰִ���߳�"+Thread.currentThread().getName()+"Download " + starPos + " - " + endPos + " finish!");
			bis.close();
			fos.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{			
		}		
	}
}
