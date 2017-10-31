package io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * @author 天启 zhouj@dtdream.com
 */
public class SwitchStreamTest {
    /*
    * 作用：
    * InputStreamReader 的作用是将“字节输入流”转换成“字符输入流”。它继承于Reader。
    * OutputStreamWriter 的作用是将“字节输出流”转换成“字符输出流”。它继承于Writer。
    *
    * 其实比较容易懂的方法去理解这两个类那就是去看这两个类的构造函数
    *   InputStreamReader构造函数的参数为 InputStream，所以很好理解 它的作用就是将“字节输入流”转换成“字符输入流”。
    *   同理可以知道OutputStreamWriter的作用是将“字节输出流”转换成“字符输出流”。
    *
    *
    * 为什么会有OutputStreamWriter和InputStreamReader两个转换类的出现？
    * 1.首先要说一下字节流和字符流的区别：
    *
    * 1）读写单位不同：字节流以字节（8bit）为单位，字符流以字符为单位，根据码表映射字符，一次可能读多个字节。
    * 2）处理对象不同：字节流能处理所有类型的数据（如图片、avi等），而字符流只能处理字符类型的数据。
    * 结论：只要是处理纯文本数据，就优先考虑使用字符流。 除此之外都使用字节流。
    *
    * 2.接着说一下计算机的存储机制：
    *  计算机中任何数据都是二进制储存的，不管是文本、图片还是视频，所以我们可以采用字节流对所有数据的操作，
    *  但是有时候我们又想用字符流便捷操作，这个时候我们就要用到转换流了。
    * 下面举个例子说明一下：
    *  比方说，我们现在要读取一张相片的数据，这个时候我们应该选择用字节输入流，这样我们获得的数据就是字节的形式
    *  但是在程序中我们并不想以字节的形式储存，所以这个时候我们就需要将其转换成字符流，从而保存在字符串数组中。
    *  这里就用到InputStreamReader类，将“输入字节流”转换成“字符输入流”。
    *  同理可以理解OutputStreamWriter类的作用。
    *  */

    String filePath = "F:"+ File.separator+ "io" +File.separator+"CharsStream"+File.separator+"test.txt";
    File file = new File(filePath);


    @Test
    public void inputStreamReader() throws IOException {
        Reader reader = new InputStreamReader(new FileInputStream(file));
        char[] chars = new char[(int)file.length()];
        reader.read(chars);
        reader.close();
        System.out.println(new String(chars));
    }

    @Test
    public void outputStreamWriter() throws IOException {
        Writer out = new OutputStreamWriter(new FileOutputStream(file,true),"GBK");
        out.write("集合类的由来：对象用于封装特有数据，对象多了需要存储，如果对象的个数不确定。就使用集合容器进行存储。");
        out.close();
    }


}
