package nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo {

	public static void main(String[] args) throws IOException {
		
		String str1 = "hello";
		String str2 = "he"+new String("llo");
		System.err.println(str1 == str2);
//		FileChannelDemo1();
//		FileChannelDemo2(); //ʵ�ֽ�������������ֱ�����ָ�����ļ��У�����ʾ��ǰ�ļ��е�����
//		FileChannelDemo3();
		
		
				
	}

	public static void FileChannelDemo3() throws IOException {
		File file = new File("F:"+File.separator+"test.txt");
		
		FileInputStream input = new FileInputStream(file);
		FileChannel fin = input.getChannel();
		MappedByteBuffer mbb = fin.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
		byte[] data = new byte[(int)file.length()];
		int foot = 0;
		while(mbb.hasRemaining()){
			data[foot++] = mbb.get();
		}
		System.out.println(new String(data));
		
		fin.close();
		input.close();
		
		
		
	}

	public static void FileChannelDemo2() throws IOException {
		File file = new File("F:"+File.separator+"test.txt");
		FileInputStream input = null;
		FileOutputStream output = null;
		FileChannel finput = null;
		FileChannel foutput = null;
		BufferedReader buf = null;									
		String str = null;
		

		while(true){
			
			/*========================������д�뵽�ļ���===========================*/
			System.out.print("���������ݣ�");
			buf = new BufferedReader(new InputStreamReader(System.in));
			if(file.length()>0)
				str = "\r\n"+buf.readLine();
			else
				str = buf.readLine();
			output = new FileOutputStream(file, true);
			foutput = output.getChannel();
			
			
			ByteBuffer bbwrite =ByteBuffer.allocate(1024);
			bbwrite.put(str.getBytes());
			
			bbwrite.flip();
			foutput.write(bbwrite);
			bbwrite.clear();
			if(str.equals("over"))
				break;
			
			/*========================���ļ����ݶ�����===========================*/
			input = new FileInputStream(file);			
			finput = input.getChannel();
			ByteBuffer bbread =ByteBuffer.allocate(1024);	
			while(finput.read(bbread)!=-1){
				bbread.flip();		
				String strtemp = null;
				byte[] dst = new byte[1024];
				int i = 0;
				while(bbread.hasRemaining()){										
					dst[i] = bbread.get();

					i++;					
				}
				strtemp = new String(dst);
				System.out.println("�ļ��е�����Ϊ��"+strtemp);
				bbread.clear();
			}						
		}			
		foutput.close();
		finput.close();
		input.close();
		output.close();		
	}

	public static void FileChannelDemo1() throws IOException {
		File file = new File("F:"+File.separator+"test.txt");
		FileOutputStream output = null;
		FileChannel fout = null;
		String str = null;
		BufferedReader buf = null;
		while(true){
			System.out.print("���������ݣ�");
			buf = new BufferedReader(new InputStreamReader(System.in));
			str = buf.readLine()+"\\n";
			
			output = new FileOutputStream(file, true);
			fout = output.getChannel();
			
			ByteBuffer bb = ByteBuffer.allocate(1024);
			bb.put(str.getBytes());
			
			bb.flip();
			fout.write(bb);
			if(str.equals("over"))
				break;
		}			
		fout.close();
		output.close();
	}

}
