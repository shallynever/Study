package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * @author ���� zhouj@dtdream.com
 * @since
 */
public class CopyFile{
	
	public static void main(String[] args){
		// �ж��Ƿ�����������
		if(args.length != 2){
			System.out.println("����Ĳ�������ȷ��") ;
			System.out.println("����java Copy Դ�ļ�·�� Ŀ���ļ�·��") ;
			// ϵͳ�˳�
			System.exit(1) ;
		}
		// Դ�ļ���File����
		File file1 = new File(args[0]) ;
		// Ŀ���ļ���File����
		File file2 = new File(args[1]) ;
		if(!file1.exists()){
			System.out.println("Դ�ļ������ڣ�") ;
			System.exit(1) ;
		}
		// ׼�������������󣬶�ȡԴ�ļ�
		InputStream input = null ;
		// ׼�������������д��Ŀ���ļ�
		OutputStream out = null ;
		try{
			input = new FileInputStream(file1) ;
		}catch(FileNotFoundException e){
			e.printStackTrace() ;
		}
		try{
			out = new FileOutputStream(file2) ;
		}catch(FileNotFoundException e){
			e.printStackTrace() ;
		}
		// �ж����������Ƿ�׼����
		if(input!=null && out!=null){
			int temp = 0 ;
			try{
				while((temp=input.read())!=-1){
					out.write(temp) ;
				}
				System.out.println("������ɣ�") ;
			}catch(IOException e){
				e.printStackTrace() ;
				System.out.println("����ʧ�ܣ�") ;
			}
			try{
				input.close() ;		// �ر�
				out.close() ;		// �ر�
			}catch(IOException e){
				e.printStackTrace() ;
			}
		}
	}
}