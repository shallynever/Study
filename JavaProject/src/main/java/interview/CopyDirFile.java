package interview;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class CopyDirFile {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String fileSRCPath = "F:"+File.separator+"Java";
		
		String fileDSTPath = "F:"+File.separator+"Jad";
		
		copyFile(fileSRCPath, fileDSTPath);		
	}
	public static void copyFile(String fileSRCPath,String fileDSTPath) throws Exception{
		File fileSRC = new File(fileSRCPath);   //源文件夹
		File fileDST = new File(fileDSTPath);
		fileDST.mkdir();
		
		File[] file = fileSRC.listFiles();			
		for (int i = 0; i < file.length; i++) {
			//判断是否是文件，如果是文件直接复制，否则执行else
			if(file[i].isFile()){
				if(file[i].getName().endsWith(".java")){
					
					String sourceFileName = file[i].getName();
					
					InputStream in = new FileInputStream(fileSRCPath+File.separator+sourceFileName);
					BufferedReader buf = new BufferedReader(new InputStreamReader(in));
					StringBuffer sb = new StringBuffer();
					String temp = null;
					while((temp=buf.readLine()) != null){
						sb.append(temp+"\r\n");
					}
					PrintStream out = new PrintStream(fileDSTPath+File.separator+sourceFileName);
					out.print(sb.toString());
					
					buf.close();
					out.close();		
				}
			}else{				
				copyFile(file[i].toString(), fileDSTPath+File.separator+file[i].getName());
			}
		}
	}

}
