package io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;


/**
 * 合并流
 *
 * @author 天启 zhouj@dtdream.com
 */
public class SequenceStreamTest {

    String filePath1 = "F:"+ File.separator+ "io" +File.separator+"SequenceStream"+File.separator+"privateKey.txt";
    String filePath2 = "F:"+ File.separator+ "io" +File.separator+"SequenceStream"+File.separator+"publicKey.txt";
    String filePath = "F:"+ File.separator+ "io" +File.separator+"SequenceStream"+File.separator+"key.txt";



    @Test
    public void sequence() throws Exception {
        InputStream inputStream1 = new FileInputStream(filePath1);
        InputStream inputStream2 = new FileInputStream(filePath2);
        OutputStream outputStream = new FileOutputStream(filePath);
        SequenceInputStream sequenceInputStream = new SequenceInputStream(inputStream1, inputStream2);
        int temp;
        while ((temp = sequenceInputStream.read()) != -1) {
            outputStream.write(temp);
        }
        sequenceInputStream.close();
        inputStream1.close();
        inputStream2.close();
        outputStream.close();
    }

}
