package io;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

/**
 * @author 天启 zhouj@dtdream.com
 * @since 内存中操作流
 */
public class ByteArrayStreamDemo {

	/*
	* ByteArrayInputStream 可以将字节数组转化为输入流 。
	* ByteArrayOutputStream 可以捕获内存缓冲区的数据，转换成字节数组。
	*
	* ByteArrayInputStream使用场景：
	* 	客户端和服务器端交互，当连接建立之后，如果只是根据协议用DataInputStream的
	* 	readInt() 或者readByte() 等固定方法一个一个的读，那是相当消耗资源的，
	* 	如果一次将所需要的数据读取完毕，然后剩下的就是本地解析，那就省了不少交互资源
	* ByteArrayOutputStream使用场景：
	* 	服务器端处理完毕需要往客户端返回数据，如果使用DataOutputStream的
	* 	writeInt(int v)或者writeByte(int v)等方法一个一个的写，那么和
	* 	读取的场景性质就一样了：交互资源是相当消耗的；因此如果现在本地把数据
	* 	组织完毕之后，能一次传送，就好了。
	* */

	String str = "hangzhou";


	@Test
	public void byteArray() throws Exception {
		/*ByteArrayInputStream使用场景*/
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
		DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
		//此时的输入流已经是本地的输入流了，在本地你可以随心所欲
		dataInputStream.readByte();
		dataInputStream.readInt();

		byteArrayInputStream.close();
		dataInputStream.close();

		/*ByteArrayOutputStream使用场景*/
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
		// 往流当中写入数据
		dataOutputStream.writeInt(29);
		dataOutputStream.writeChars("SGIP_BIND_RESP");
		dataOutputStream.writeByte(0);
		byte[] reserve = new byte[8];
		dataOutputStream.write(reserve);
		dataOutputStream.flush();
		// 从字节数组输出流当中将数据读取出来
		byte[] result = byteArrayOutputStream.toByteArray();
		String resultStr = byteArrayOutputStream.toString();

		byteArrayOutputStream.close();  //关闭 ByteArrayOutputStream 无效。此类中的方法在关闭此流后仍可被调用，而不会产生任何IOException
		dataOutputStream.close();
	}

}
