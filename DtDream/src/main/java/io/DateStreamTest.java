package io;

import org.junit.Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * @author 天启 zhouj@dtdream.com
 * @since
 */
public class DateStreamTest {

	/*
    * 数据操作流：操作基本数据类型的流
    * DataInputStream能以一种与机器无关（当前操作系统等）的方式，
    * 直接从地从字节输入流读取JAVA基本类型和String类型的数据，常用于网络传输等（网络传输数据要求与平台无关）
    * DataOutputStream则能够直接将JAVA基本类型和String类型数据写入到其他的字节输入流。
    *
	* DataInputStream和DataOutputStream是序列化用的流,也就是可以把Java对象或者基本数据类型与二进制相互转换,
	* 因此说DataInputStream和DataOutputStream提供了与平台无关的数据操作流。
	* */

    String filePath = "F:" + File.separator + "io" + File.separator + "DateStream" + File.separator + "test.txt";
    File file = new File(filePath);


    @Test
    public void dateInputStream() throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        String name;    // 接收名称
        float price;    // 接收价格
        int number;     // 接收数量
        char[] temp;    // 接收商品名称
        int len;        // 保存读取数据的个数
        char c;         // '\u0000'
        try {
            while (true) {
                temp = new char[200];
                len = 0;
                while ((c = dataInputStream.readChar()) != '\t') {
                    temp[len] = c;
                    len++;    // 读取长度加1
                }
                name = new String(temp, 0, len);
                price = dataInputStream.readFloat();
                dataInputStream.readChar();
                number = dataInputStream.readInt();
                dataInputStream.readChar();
                System.out.printf("名称：%s；价格：%5.2f；数量：%d\n", name, price, number);
            }
        } catch (Exception e) {
        }
        dataInputStream.close();
    }

    @Test
    public void dateOutputStream() throws Exception {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
        String[] names = {"衬衣", "手套", "围巾"};
        float[] prices = {98.3f, 30.3f, 50.5f};
        int[] numbers = {3, 2, 1};
        for (int i = 0; i < names.length; i++) {
            dataOutputStream.writeChars(names[i]);
            dataOutputStream.writeChar('\t');
            dataOutputStream.writeFloat(prices[i]);
            dataOutputStream.writeChar('\t');
            dataOutputStream.writeInt(numbers[i]);
            dataOutputStream.writeChar('\n');
        }
        dataOutputStream.close();
    }

}
