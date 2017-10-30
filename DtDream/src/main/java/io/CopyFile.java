package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFile{
	
	public static void main(String args[]){
		if(args.length!=2){		// �ж��Ƿ�����������
			System.out.println("����Ĳ�������ȷ��") ;
			System.out.println("����java Copy Դ�ļ�·�� Ŀ���ļ�·��") ;
			System.exit(1) ;	// ϵͳ�˳�
		}
		File file1 = new File(args[0]) ;	// Դ�ļ���File����
		File file2 = new File(args[1]) ;	// Ŀ���ļ���File����
		if(!file1.exists()){
			System.out.println("Դ�ļ������ڣ�") ;
			System.exit(1) ;
		}
		InputStream input = null ;		// ׼�������������󣬶�ȡԴ�ļ�
		OutputStream out = null ;		// ׼�������������д��Ŀ���ļ�
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
		if(input!=null && out!=null){	// �ж����������Ƿ�׼����
			int temp = 0 ;
			try{
				while((temp=input.read())!=-1){	// ��ʼ����
					out.write(temp) ;	// �߶���д
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