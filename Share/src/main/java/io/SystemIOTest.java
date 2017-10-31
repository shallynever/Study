package io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
/**
 * @author ���� zhouj@dtdream.com
 * @since
 */
public class SystemIOTest {

	/*
	* System.in��һ�����͵����ӿ���̨����ͼ��������InputStream����
	* ͨ��������ͨ�������в������������ļ����ݸ�������Java�����ʱ��System.in�����Ǻܳ��á�
	* ͼ�ν������ͨ�����洫�ݲ�������������һ�鵥����Java IO������ơ�
	*
	* System.out��һ��PrintStream����
	* System.outһ������д�����е��������������̨�ϡ�
	* System.outͨ�����������������й��ߵĿ���̨�����ϡ�
	* System.outҲ�������ڴ�ӡ����ĵ�����Ϣ(���������ܲ����ǻ�ȡ���������Ϣ����ѷ�ʽ)��
	*
	* System.err��һ��PrintStream����
	* System.err��System.out�����з�ʽ���ƣ���������������ڴ�ӡ�����ı���
	* һЩ����Eclipse�ĳ���Ϊ���ô�����Ϣ�������ۣ��Ὣ������Ϣ�Ժ�ɫ�ı�����ʽͨ��System.err���������̨�ϡ�
	*
	* System.out ��System.err ������
	* System.out��System.err����PrintStream��ʵ�������󣬶���ͨ��������Է��֣����߶��������������Ϣ��
	* ����һ������System.out�ǽ���Ϣ��ʾ���û���������������Ϣ��ʾ����System.err�������෴�ǲ�ϣ���û������ģ�
	* ��ֱ���ں�̨��ӡ����ר����ʾ����ġ�
	* һ�����������Ҫ���������Ϣ��ʱ����ò�Ҫʹ��System.out����ֱ��ʹ��System.err ��һ��ֻ�ܴ�������ϻ��֡�
	* ���ϵĴ���Ҳ����ʹ��System.out�����ֻ�ܴӸ����ϻ��֡�
	* �мǣ�System.out��ϣ���û������ģ���System.err�ǲ�ϣ���û������ġ�
	*
	* */


	String filePath = "F:"+ File.separator+ "io" +File.separator+"SystemIO"+File.separator+"test.txt";
	File file = new File(filePath);

	@Test
	public void systemIn() throws Exception {
		//System.in�������ض���
		System.setIn(new FileInputStream(file));
		InputStream input = System.in;
		StringBuffer buf = new StringBuffer();
		byte[] b = new  byte[1024];
		System.out.println("���������ݣ�");

		int len = input.read(b);
		/*
		* ���ϵĲ���������������
		* ����һ��ָ�����������ݵĳ��ȣ����������������ݳ����˳��ȷ�Χ��ֻ�����벿�ֵ����ݡ�
		* ����������byte�����������Ļ����򻹿��ܳ�������������������Ϊһ���ַ��������ֽڡ�
		* */

		int temp;
		while((temp = input.read())!=-1){
			char c = (char)temp;
			if(c=='\n'){
				break;
			}
			buf.append(c);
		}
		/*
		* ���ϵĲ���������������
		* �������ľͻ�����,��Ϊÿ��ȡһ���ֽھͽ���תΪ�ַ�,
		* ��ĸ�����ֶ���ռ1���ֽ� ����������ʾ��
		* ������������ĵĻ������൱��ÿ��ȡ��һ���ֽھ��ǰ���ַ��ͽ���ת�������Ե�������Ĵ���
		*
		* ��������ı�׼��ʽ��
		* ��õ������ʽ�ǽ�ȫ�������������ʱ�����һ���ڴ�֮�ϣ�
		* ֮��һ���ԵĴ��ڴ��ж�ȡ���ݣ������������ݾ�����ֻ����һ�Σ��򲻻�������룬����Ҳ�����ܵ����ȵ����ơ�
		* ���Ҫ��ʵ�����ϵĹ��ܣ���ֻ��ͨ��IO�е���һ���� BufferedReader����ɡ�
		* */
		System.out.println("��������Ϊ��"+new String(b,0,len));
		input.close();
	}

	@Test
	public void systemOut() {
		try {
			System.setOut(new PrintStream(new FileOutputStream(file,true)));  // System.out�ض���
			OutputStream out  = System.out;
			out.write("�й���������ʮ�Ŵ�ȫ��������".getBytes());
			out.close();
		} catch (IOException e) {
			System.err.println(e);
		}

	}

	@Test
	public void systemErr() throws FileNotFoundException {
		System.setErr(new PrintStream(new FileOutputStream(file,true)));  //System.err����ض���
		String str  = "hello";
		System.err.println(str);
	}

}
