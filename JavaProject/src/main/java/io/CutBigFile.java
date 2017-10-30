package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;


public class CutBigFile {
	
	public static final String src_FilePath = "G:"+File.separator+"Experiment"+File.separator+"20160801.txt";
	public static final String dst_FilePath = "G:"+File.separator+"Experiment"+File.separator;
	public static Writer out;
	public static File dstFile;
	
	
	public static void main(String[] args) throws IOException {
		
		int num = 1;
				
		Reader in = new FileReader(src_FilePath);
		
		BufferedReader buf = new BufferedReader(in);
		String temp = null;
		while((temp=buf.readLine()) != null){
			dstFile = new File(dst_FilePath+num+".txt");
			out = new FileWriter(dstFile,true);
			if(dstFile.length() <= 200*1024*1024){
				out.write(temp+"\r\n");
				out.flush();
			}else{
				num++;
			}
			
		}
		buf.close();
		out.close();

	}

}
