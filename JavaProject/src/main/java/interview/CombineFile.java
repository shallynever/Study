package interview;

/*��дһ�����򣬽� a.txt �ļ��еĵ����� b.txt �ļ��еĵ��ʽ���ϲ��� c.txt
�ļ��У� a.txt �ļ��еĵ����ûس����ָ��� b.txt �ļ����ûس���ո���зָ���*/


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
		
		if(lenghtA>=lenghtB){ //���a�ļ����е����ݱ�b�ļ��е����ݶ࣬���a�ļ��е�����ֱ�ӱ��浽ab�ļ��С�����ִ��else
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
	/*��ȡ�ļ��еĵ��ʣ�������ȡ���ĵ������ַ�������*/
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
