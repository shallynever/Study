package io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * �ֽ���
 * @author ���� zhouj@dtdream.com
 * *
 */
public class ByteStreamTest {

    String filePath = "F:"+ File.separator+ "io" +File.separator+"ByteStream"+File.separator+"test.txt";

    @Test
    public void outputStream() throws IOException {
        File file = new File(filePath);
        // ��׷������
        OutputStream outputStream = new FileOutputStream(file,true);

        String str = "\r\nJAVA����ͨ�������������/���";
        byte[] bytes = str.getBytes();
        // ��byte����ֱ��д���ļ�
        outputStream.write(bytes);
        // ѭ����ÿ���ֽ�һ����д���ļ�
        for (int i = 0; i < bytes.length; i++) {
            outputStream.write(bytes[i]);
		}

        outputStream.close();

         /*
         * ���FileOutputStream������������
         * �ַ�������������ģ��ͻ�������룬������ΪFileOutputStream���ֽ�����
         * ���ı����ֽ�д���ļ�����һ�������������ֽڣ��޷�һ��д�룬�ͻ�������룬
         * ���������ʹ��OutputStreamWriter���ֽ���ת��Ϊ�ַ���д�룬ͬʱָ��gbk���롣
         * */
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "GBK");
        outputStreamWriter.append(str);
        outputStreamWriter.close();
    }

    @Test
    public void inputStream() throws IOException {
        File file = new File(filePath);
        InputStream inputStream = new FileInputStream(file);
//        byte[] bytes = new byte[1024];  //��ȡ���������ݿ��ܴ��ڴ����Ŀո�
        //����һ���ռ�
        byte[] bytes = new byte[(int)file.length()];
        inputStream.read(bytes);

        int temp = 0;
        int count = 0;
        // �ļ�����ĩβ���򷵻ص�����Ϊ-1
        while((temp = inputStream.read())!= -1){
            bytes[count++] = (byte) temp;
        }
        inputStream.close();
        System.out.println(new String(bytes));
    }

}
