package interview;

/*编写一个程序，将 a.txt 文件中的单词与 b.txt 文件中的单词交替合并到 c.txt
文件中， a.txt 文件中的单词用回车符分隔， b.txt 文件中用回车或空格进行分隔。*/


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Date;



public class CombineFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File filea = new File("F:"+File.separator+"a.txt");
		File fileb = new File("F:"+File.separator+"b.txt");
		File fileab = new File("F:"+File.separator+"ab.txt");
		
		PrintStream out = new PrintStream(fileab);
				
		String[] a = ReadFileWord(filea);	
		String[] b = ReadFileWord(fileb);	
		
		int lenghtA = a.length;
		int lenghtB = b.length;
		
		int count = lenghtA>=lenghtB?lenghtB:lenghtA;
		
		for (int i = 0; i < 2*count; i++) {
			if(i%2 == 0){
				out.print(a[i/2]+" ");	
			}else{
				out.print(b[i/2]+" ");
			}
		}
		
		if(lenghtA>=lenghtB){ //如果a文件的中的内容比b文件中的内容多，则把a文件中的内容直接保存到ab文件中。否则执行else
			for (int j = count; j < a.length; j++) {
				out.print(a[j]);
			}
		}else{
			for (int j = count; j < b.length; j++) {
				out.print(b[j]);
			}
		}
		out.close();
		
	}
	/*读取文件中的单词，并将读取到的单词以字符串返回*/
	public static String[] ReadFileWord(File file) throws IOException {		
		StringBuffer sb = new StringBuffer();		
		BufferedReader buf = null;
		String temp = null;
		buf = new BufferedReader(new InputStreamReader(new FileInputStream(file)));		
		while((temp=buf.readLine())!=null){
			sb.append(temp+" ");
		}
		buf.close();	
		System.out.println(sb.toString());
		return sb.toString().split(" ");	
	}
}
