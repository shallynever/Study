package io;

import org.junit.Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * @author ���� zhouj@dtdream.com
 * @since
 */
public class DateStreamTest {

	/*
    * ���ݲ����������������������͵���
    * DataInputStream����һ��������޹أ���ǰ����ϵͳ�ȣ��ķ�ʽ��
    * ֱ�Ӵӵش��ֽ���������ȡJAVA�������ͺ�String���͵����ݣ����������紫��ȣ����紫������Ҫ����ƽ̨�޹أ�
    * DataOutputStream���ܹ�ֱ�ӽ�JAVA�������ͺ�String��������д�뵽�������ֽ���������
    *
	* DataInputStream��DataOutputStream�����л��õ���,Ҳ���ǿ��԰�Java������߻�������������������໥ת��,
	* ���˵DataInputStream��DataOutputStream�ṩ����ƽ̨�޹ص����ݲ�������
	* */

    String filePath = "F:" + File.separator + "io" + File.separator + "DateStream" + File.separator + "test.txt";
    File file = new File(filePath);


    @Test
    public void dateInputStream() throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        String name;    // ��������
        float price;    // ���ռ۸�
        int number;     // ��������
        char[] temp;    // ������Ʒ����
        int len;        // �����ȡ���ݵĸ���
        char c;         // '\u0000'
        try {
            while (true) {
                temp = new char[200];
                len = 0;
                while ((c = dataInputStream.readChar()) != '\t') {
                    temp[len] = c;
                    len++;    // ��ȡ���ȼ�1
                }
                name = new String(temp, 0, len);
                price = dataInputStream.readFloat();
                dataInputStream.readChar();
                number = dataInputStream.readInt();
                dataInputStream.readChar();
                System.out.printf("���ƣ�%s���۸�%5.2f��������%d\n", name, price, number);
            }
        } catch (Exception e) {
        }
        dataInputStream.close();
    }

    @Test
    public void dateOutputStream() throws Exception {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
        String[] names = {"����", "����", "Χ��"};
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
