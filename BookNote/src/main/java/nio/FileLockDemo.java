package nio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockDemo {

	public static void main(String[] args) throws IOException, InterruptedException {
		File file = new File("F:"+File.separator+"test.txt");
		FileOutputStream output = new FileOutputStream(file,true);
		FileChannel fout = output.getChannel();
		FileLock lock = fout.tryLock();
		if(lock != null){
			System.out.println(file.getName()+"�ļ�����10��");
			Thread.sleep(100000);
			lock.release();
			System.out.println(file.getName()+"�ļ��ļ��������");
		}
		fout.close();
		output.close();
	}

}
