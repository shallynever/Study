package nio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDmeo01 {

	/*
	 * ��ͨ�������ô������ǿ��Խ��п������
	 * 
	 * */
	
	public static void main(String[] args) throws IOException {
		String[] info = {"zhoujing","zhejianggongshangdaxue","xindian","dianzitongxingongcheng"};
		File file = new File("F:"+File.separator+"test.txt");
		FileOutputStream output = new FileOutputStream(file);
		FileChannel fchan = null;
		fchan = output.getChannel();
		ByteBuffer bufw = ByteBuffer.allocate(1024);
//		ByteBuffer bufr = ByteBuffer.allocate(1024);
		for (String str : info) {
			bufw.put(str.getBytes());
		}
		bufw.flip();
		/*fchan.write(bufw);
		int temp = 0;
		while((temp = fchan.read(bufw))!= -1){
			System.out.println((char)temp);
		}
		���˾���javaͨ������Ʋ��Ǻܺã�Ӧ�������õ�һ���ļ���ͨ������֮�󣬾Ϳ��Զ�����ļ����ж���д����
		������Ҫ��������ʵ������
		*/
		
		fchan.close();
		output.close();
		
	
	}

}
