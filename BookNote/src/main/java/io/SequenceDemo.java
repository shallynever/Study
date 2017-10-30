package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;

public class SequenceDemo {

	public static void main(String[] args) throws Exception {
			InputStream is1 = null;
			InputStream is2 = null;
			OutputStream os = null;
			SequenceInputStream sis = null;
			is1 = new FileInputStream("f:"+File.separator+"test.txt");
			is2 = new FileInputStream("f:"+File.separator+"demo.txt");
			os = new FileOutputStream("f:"+File.separator+"testdemo.txt");
			sis = new SequenceInputStream(is1,is2);
			int temp = 0;
			while((temp = sis.read())!= -1){
				os.write(temp);
			}
			sis.close();
			is1.close();
			is2.close();
			os.close();
	}

}
