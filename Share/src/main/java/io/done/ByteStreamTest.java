package io.done;


import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * @author 天启 zhouj@dtdream.com
 * @since
 */
public class ByteStreamTest {

    /*
    * 乱码是怎样形成的？
    * 简单来说，就是编码解码采用了不同的标准。
    *
    * 怎样解决乱码问题？
    * 因为乱码是由编码解码采用了不同的标准导致的，因此在程序中保证编码和解码采用同一个编码格式就能避免出现乱码问题
    *
    * 使用IDEA注意：
    * 依次检查setting中的file Encodings中的Global Encoding/Project Encoding/Default encoding for properties files
    * 以及项目文件.idea文件夹下的encodings.xml四个地方的编码是否一直。
    *
    * 特别注意encodings.xml中的编码设置。
    *
    * 在写文件时,避免乱码的几种做法：
    * 1. 指定中文字符串编码方式(系统编码一致)
    * 2. 使用OutputStreamWriter将字节流转换为字符流写入，同时指定编码(与系统编码一致)
    * */

    // 获取系统的编码方式
    String systemEncoding = System.getProperty("file.encoding");
    String filePath = "F:"+ File.separator+ "io" +File.separator+"ByteStream"+File.separator+"test.txt";

    @Test
    public void outputStream() throws IOException {
        File file = new File(filePath);
        // 可追加内容
        OutputStream outputStream = new FileOutputStream(file,true);
        String str = "\r\n支付中心";
        System.out.println(str);

        System.out.println("系统的编码方式:"+systemEncoding);


        byte[] bytes = str.getBytes();

        // 将byte数组直接写入文件
        outputStream.write(bytes);

        // 循环把每个字节一个个写入文件
        for (int i = 0; i < bytes.length; i++) {
            outputStream.write(bytes[i]);
		}


        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        outputStreamWriter.append(str);
        outputStreamWriter.flush();

        outputStream.close();
        outputStreamWriter.close();

    }

    @Test
    public void inputStream() throws IOException {
        File file = new File(filePath);
        InputStream inputStream = new FileInputStream(file);
        // 根据文件大小开辟空间
        byte[] bytes = new byte[(int)file.length()];
        inputStream.read(bytes);

        int temp;
        int count = 0;
        // 文件读到末尾，则返回的内容为-1
        while(-1 != (temp = inputStream.read())){
            bytes[count++] = (byte) temp;
        }
        inputStream.close();
        System.out.println(new String(bytes));
    }

}
