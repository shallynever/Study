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
 * 字节流
 * @author 天启 zhouj@dtdream.com
 * *
 */
public class ByteStreamTest {

    String filePath = "F:"+ File.separator+ "io" +File.separator+"ByteStream"+File.separator+"test.txt";

    @Test
    public void outputStream() throws IOException {
        File file = new File(filePath);
        // 可追加内容
        OutputStream outputStream = new FileOutputStream(file,true);

        String str = "\r\nJAVA程序通过流来完成输入/输出";
        byte[] bytes = str.getBytes();
        // 将byte数组直接写入文件
        outputStream.write(bytes);
        // 循环把每个字节一个个写入文件
        for (int i = 0; i < bytes.length; i++) {
            outputStream.write(bytes[i]);
		}

        outputStream.close();

         /*
         * 解决FileOutputStream中文乱码问题
         * 字符串如果包含中文，就会出现乱码，这是因为FileOutputStream是字节流，
         * 将文本按字节写入文件，而一个汉字是两个字节，无法一次写入，就会出现乱码，
         * 解决方法是使用OutputStreamWriter将字节流转换为字符流写入，同时指定gbk编码。
         * */
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "GBK");
        outputStreamWriter.append(str);
        outputStreamWriter.close();
    }

    @Test
    public void inputStream() throws IOException {
        File file = new File(filePath);
        InputStream inputStream = new FileInputStream(file);
//        byte[] bytes = new byte[1024];  //读取出来的内容可能存在大量的空格
        //开辟一定空间
        byte[] bytes = new byte[(int)file.length()];
        inputStream.read(bytes);

        int temp = 0;
        int count = 0;
        // 文件读到末尾，则返回的内容为-1
        while((temp = inputStream.read())!= -1){
            bytes[count++] = (byte) temp;
        }
        inputStream.close();
        System.out.println(new String(bytes));
    }

}
