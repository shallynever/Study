package io.done;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * 字符流
 *
 * @author 天启 zhouj@dtdream.com
 */
public class CharsStreamTest {

    /*
    * 字符流与字节流的区别
    * 1.字节流操作的基本单元为字节；字符流操作的基本单元为Unicode码元。
    * 2.字节流默认不使用缓冲区；字符流使用缓冲区。
    * 3.字节流通常用于处理二进制数据，实际上它可以处理任意类型的数据，
    *   但它不支持直接写入或读取Unicode码元；字符流通常处理文本数据，
    *   它支持写入及读取Unicode码元。
    *
    * */


    String filePath = "F:" + File.separator + "io" + File.separator + "CharsStream" + File.separator + "test.txt";
    File file = new File(filePath);

    @Test
    public void writer() throws Exception {
        String str = new String("\r\nJAVA程序通过流来完成输入/输出".getBytes("GBK"));
        Writer writer;
        // 可追加内容
        writer = new FileWriter(file, true);
        writer.write(str);


        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "GBK"));
        writer.write(str);

        writer.flush();

        writer.close();

    }

    @Test
    public void reader() throws IOException {
        Reader reader = new FileReader(file);
        char[] chars = new char[(int) file.length()];
        int len = 0;
        int temp;
        reader.read(chars);
        while ((temp = reader.read()) != -1) {
            chars[len++] = (char) temp;
        }
        reader.close();
        System.out.println(new String(chars));
    }


    @Test
    public void copyFile() throws IOException {
        String sourcePath = null;
        String destinationPath = null;

        // 判断是否是两个参数
        if (sourcePath == null || destinationPath == null) {
            System.out.println("输入路径参数不正确");
        }
        // 源文件的File对象
        File sourceFile = new File(sourcePath);
        // 目标文件的File对象
        File destinationFile = new File(destinationPath);
        if (!sourceFile.exists()) {
            System.out.println("源文件不存在");
        }
        // 准备好输入流对象，读取源文件
        InputStream input = new FileInputStream(sourceFile);
        // 准备好输出流对象，写入目标文件
        OutputStream out = new FileOutputStream(destinationFile);

        // 判断输入或输出是否准备好
        if (input != null && out != null) {
            int temp = 0;
            try {
                // 开始拷贝
                while ((temp = input.read()) != -1) {
                    // 边读边写
                    out.write(temp);
                }
                System.out.println("拷贝完成！");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("拷贝失败！");
            } finally {
                input.close();
                out.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String path = "F:/";
        String str = "\r\n支付中心";
        File file = new File(path+"file");
        byte[] byteA = str.getBytes();
        for (byte aByte : byteA) {
            System.out.println(aByte);
        }

        FileWriter writer = new FileWriter(file,true);
        System.out.println(writer.getEncoding()+":"+System.getProperty("file.encoding"));
        writer.write(str);
        writer.flush();
        writer.close();

    }
}
