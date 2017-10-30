package io;

import org.junit.Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DateStreamDemo {

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
                temp = new char[200];    // ���ٿռ�
                len = 0;
                while ((c = dataInputStream.readChar()) != '\t') {    // ��������
                    temp[len] = c;
                    len++;    // ��ȡ���ȼ�1
                }
                name = new String(temp, 0, len);             // ���ַ������ΪString
                price = dataInputStream.readFloat();                // ��ȡ�۸�
                dataInputStream.readChar();                     // ��ȡ\t
                number = dataInputStream.readInt();             // ��ȡint
                dataInputStream.readChar();    // ��ȡ\n
                System.out.printf("���ƣ�%s���۸�%5.2f��������%d\n", name, price, number);
            }
        } catch (Exception e) {
        }
        dataInputStream.close();
    }

    @Test
    public void dateOutputStream() throws Exception {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
        String[] names = {"����", "����", "Χ��"};    // ��Ʒ����
        float[] prices = {98.3f, 30.3f, 50.5f};        // ��Ʒ�۸�
        int[] numbers = {3, 2, 1};    // ��Ʒ����
        for (int i = 0; i < names.length; i++) {    // ѭ�����
            dataOutputStream.writeChars(names[i]);    // д���ַ���
            dataOutputStream.writeChar('\t');    // д��ָ���
            dataOutputStream.writeFloat(prices[i]); // д��۸�
            dataOutputStream.writeChar('\t');    // д��ָ���
            dataOutputStream.writeInt(numbers[i]); // д������
            dataOutputStream.writeChar('\n');    // ����
        }
        dataOutputStream.close();
    }

}
