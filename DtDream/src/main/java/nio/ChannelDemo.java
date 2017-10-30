package nio;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @author 天启 zhouj@dtdream.com
 */
public class ChannelDemo {

    /*
    * Channel就是一个通道，用于传输数据，两端分别是缓冲区和实体（文件或者套接字）,通道的特点（也是NIO的特点）：
    * 通道中的数据总是要先读到一个缓冲区，或者总是要从一个缓冲区中读入。
    *
    * Channel的分类
    * 1) FileChannel：从文件中读写数据
    * 2) SocketChannel：通过TCP协议读写网络中的数据
    * 3) ServerSocketChannel：在服务器端可以监听新进来的TCP连接，像WEB服务器那样，
    * 对每一个新进来的请求创建一个SocketChannel
    * 4) DatagramChannel：通过UDP协议读写网络中的数据
    *
    * WritableByteChannel
    * ReadableByteChannel
    * ByteChannel
    *
    * 通道可以只读、只写或者同时读写，因为Channel类可以只实现只读接口ReadableByteChannel或者只实现只写接口WritableByteChannel，
    * 而我们常用的Channel类FileChannel、SocketChannel、DatagramChannel是双向通信的， 因为实现了ByteChannel接口。
    *
    *
    * */

    @Test
    public void writeFileUseChannel() throws IOException {
        String[] info = {"hangzhou","apocalypse"};
        File file = new File("F:"+File.separator+"test.txt");
        FileOutputStream output = new FileOutputStream(file);
        FileChannel fileChannel = output.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        for (String str : info) {
            byteBuffer.put(str.getBytes());
        }
        byteBuffer.flip();  // 该方法是用于将缓冲区从写模式切换到读模式
        fileChannel.write(byteBuffer);  // 一次性将内容写入文件
        fileChannel.close();
        output.close();
    }

    @Test
    public void readFileUseChannel() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("F:"+File.separator+"test.txt");
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        fileChannel.read(buffer);
        buffer.flip();
        while(buffer.hasRemaining()){
            System.out.print((char)buffer.get());
        }

        buffer.clear();
        fileInputStream.close();
    }

    @Test
    public void fileLock() throws IOException, InterruptedException {
        File file = new File("F:"+File.separator+"test.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file,true);
        FileChannel fileChannel = fileOutputStream.getChannel();
        FileLock lock = fileChannel.tryLock();
        if(lock != null){
            Thread.sleep(100000);
            lock.release();
        }
        fileChannel.close();
        fileOutputStream.close();
    }

    @Test
    public void mappedByteBuffer() throws IOException {
        File file = new File("F:"+File.separator+"test.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel fileChannel = fileInputStream.getChannel();
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
        byte[] data = new byte[(int)file.length()];
        int foot = 0;
        while(mappedByteBuffer.hasRemaining()){
            data[foot++] = mappedByteBuffer.get();
        }
        System.out.println(new String(data));
        fileChannel.close();
        fileInputStream.close();
    }


    @Test
    public void channel() throws IOException {
        File file = new File("F:"+File.separator+"test.txt");
        File outFile = new File("F:"+File.separator+"outTest.txt");

        FileChannel fileChannel = null;
        String str = "hangzhou apocalypse dt dream";

        ByteBuffer buffer =ByteBuffer.allocate(1024);
        /*========================将内容写入到文件中===========================*/
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        fileChannel = fileOutputStream.getChannel();
        buffer.put(str.getBytes());
        buffer.flip();
        fileChannel.write(buffer);
        buffer.clear();

        /*========================将文件内容读出来===========================*/
        FileInputStream fileInputStream = new FileInputStream(file);
        fileChannel = fileInputStream.getChannel();
        while(fileChannel.read(buffer)!=-1){
            buffer.flip();
            byte[] dst = new byte[1024];
            int i = 0;
            while(buffer.hasRemaining()){
                dst[i] = buffer.get();
                i++;
            }
            System.out.println(new String(dst));
            buffer.clear();
        }
        fileChannel.close();
        fileOutputStream.close();
        fileInputStream.close();
    }

}
