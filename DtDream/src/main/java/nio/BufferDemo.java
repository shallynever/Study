package nio;


import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

/**
 * @author 天启 zhouj@dtdream.com
 */
public class BufferDemo {

    /*
    * NIO中的buffer用于和通道交互，数据是从通道读入缓冲区，从缓冲区中写入通道的。
    * Buffer就像一个数组，可以保存多个类型相同的数据。每种基本数据类型都有对应的Buffer类。
    *
    * 缓冲区的属性：
    * 1、capacity(容量)：buffer本质是一个数组，在初始化时有固定的大小，这个值就是容量。
    * 容量不可改变，一旦缓冲区满了，需要将其清空才能将继续进行读写操作。
    * 2、position(位置)：表示当前的位置，初始化时为0，当一个基本数据类型的数据写入buffer时，
    * position会向前移动到下一个可插入数据的Buffer单元。position最大值可以是capacity-1。
    * 3、limit（限制）：在缓冲区写模式下，limit表示你最多能往Buffer里写多少数据，大小等于capacity；
    * 在缓冲区读模式下，limit表示能从缓冲区内读取到多少数据，因此，当切换Buffer到读模式时，
    * limit会被设置成写模式下的position值。
    *
    * Buffer的分配
    * Buffer对象的获取需要进行分配，每种类型的Buffer对象都有一个allocate方法
    *
    * Buffer模式的切换
    * 调用flip()方法会将position设回0，并将limit设置成之前position的值。该方法是用于将缓冲区从写模式切换到读模式
    *
    * clear方法
    * 1、一旦完成对buffer中数据的读取，需要让buffer做好再次被写入的准备，这时候可以调用clear方法来完成。
    * 2、clear方法将position设置为0，limit设置为容量的值，也就意味着buffer被清空了，
    * 但是这个清空的概念是写入数据可以从缓冲区的指定位置开始，但buffer里面的数据并没有删除。
    * 3、如果buffer里面还有数据没有被读取，这个时候调用clear方法会导致那些数据被“遗忘”，
    * 因为没有标记告诉你哪些是读取过哪些没有被读取。
    *
    * rewind方法
    * 将position的位置设置为0，并丢弃标志位，表示可以重新读取Buffer中的所有数据，limit保持不变。
    *
    * 向buffer中写入数据
    * 1、通过channel写入；
    * 2、通过buffer的put方法写入：
    *
    * 从buffer中读取数据
    * 1、通过channel读取；
    * 2、通过buffer的get方法读取：
    * */

    @Test
    public void intBuffer() {

        IntBuffer intBuffer = IntBuffer.allocate(10);
        System.out.println("写入数据之前："+intBuffer.position()+":"+intBuffer.limit()+":"+intBuffer.capacity());
        int temp[] = {4,6,8};
        intBuffer.put(2);
        intBuffer.put(temp);
        System.out.println("写入数据后"+intBuffer.position()+":"+intBuffer.limit()+":"+intBuffer.capacity());
//        intBuffer = intBuffer.asReadOnlyBuffer();	//将buf设置为只读
        intBuffer.flip();    	 //将缓冲区从写模式切换到读模式
        System.out.println("flip()操作之后"+intBuffer.position()+":"+intBuffer.limit()+":"+intBuffer.capacity());
        System.out.println("输出内容：");
        int number = 0;
        while(intBuffer.hasRemaining()){
            System.out.println(intBuffer.get()+":"+number++);
        }

//        intBuffer.put(1);	//运行时异常，不可写入数据
    }

    @Test
    public void byteBuffer(){
        /*
		 * 在缓冲区操作类中，只有ByteBuffer可以创建直接缓冲区。如果为直接字节缓冲区，
		 * 则 Java 虚拟机会尽最大努力直接在此缓冲区上执行本机 I/O 操作。
		 * 也就是说，在每次调用基础操作系统的一个本机 I/O 操作之前（或之后），
		 * 虚拟机都会尽量避免将缓冲区的内容复制到中间缓冲区中（或从中间缓冲区中复制内容）。
		 * 直接字节缓冲区可以通过调用此类的 allocateDirect 工厂方法来创建。
		 * 此方法返回的缓冲区进行分配和取消分配所需成本通常高于非直接缓冲区。
		 * 直接缓冲区的内容可以驻留在常规的垃圾回收堆之外，
		 * 因此，它们对应用程序的内存需求量造成的影响可能并不明显。
		 * 所以，建议将直接缓冲区主要分配给那些易受基础系统的本机 I/O 操作影响的大型、持久的缓冲区。
		 * 一般情况下，最好仅在直接缓冲区能在程序性能方面带来明显好处时分配它们。
		 * 直接字节缓冲区还可以通过 mapping 将文件区域直接映射到内存中来创建。
		 * Java 平台的实现有助于通过 JNI 从本机代码创建直接字节缓冲区。
		 * 如果以上这些缓冲区中的某个缓冲区实例指的是不可访问的内存区域，
		 * 则试图访问该区域不会更改该缓冲区的内容，并且将会在访问期间或稍后的某个时间导致抛出不确定的异常。
		 * 字节缓冲区是直接缓冲区还是非直接缓冲区可通过调用其 isDirect 方法来确定。
		 * 提供此方法是为了能够在性能关键型代码中执行显式缓冲区管理。
		 *
		 * 直接内存缓冲区：使用的内存由操作系统直接分配，不受JVM堆栈的支配
		 *
		 * 非直接内存缓冲区：ByteBuffer.allocate()在堆内存中创建，如果向一个通道中传入一个非直接ByteBuffer用于写入，
		 * 通道可能会进行如下隐含操作：
		 * 在通道中创建临时缓冲区，将非直接ByteBuffer中的内容复制到临时缓冲区中，执行低层次IO操作，
		 * 当对象离开作用域时，变成无用数据，等待清理
		 *
		 */
        ByteBuffer buf = ByteBuffer.allocateDirect(10);
        byte[] b = {1,2,3,4,5};
        buf.put(b);
        buf.flip();
        while(buf.hasRemaining()){
            System.out.println(buf.get());
        }
    }


    @Test
    public void copyFileUseBuffer() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("F:"+ File.separator+"publicKey.txt");
        FileChannel fileInChannel = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("F:"+ File.separator+"copyPublicKey.txt");
        FileChannel fileOutChannel = fileOutputStream.getChannel();
        //初始化缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(20);
        System.out.println("通道文件的大小：" + fileInChannel.size());
        System.out.println("缓冲区初始化时当前位置：" + buffer.position());
        System.out.println("缓冲区初始化时可写的限制：" + buffer.limit());
        System.out.println("---------循环开始-----");
        int number = 1;
        //判断通道内数据是否读取完成
        while(-1 != fileInChannel.read(buffer)){
            System.out.println("第"+number+"读取");
            System.out.println("缓冲区写模式下当前位置：" + buffer.position());
            System.out.println("缓冲区写模式下的限制：" + buffer.limit());
            //将缓冲区从写模式切换到读模式
            buffer.flip();
            System.out.println("缓冲区读模式下当前位置：" + buffer.position());
            System.out.println("缓冲区读模式下的限制：" + buffer.limit());
            //判断缓冲区内是否还有数据可读取
            while(buffer.hasRemaining()){
                fileOutChannel.write(buffer);
            }
            buffer.clear();
            number++;
        }
        fileInChannel.close();
        fileOutChannel.close();
        fileInputStream.close();
    }

}
