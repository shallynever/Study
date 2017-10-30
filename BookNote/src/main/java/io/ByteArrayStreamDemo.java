package io;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

/**
 * @author ���� zhouj@dtdream.com
 * @since �ڴ��в�����
 */
public class ByteArrayStreamDemo {

	/*
	* ByteArrayInputStream ���Խ��ֽ�����ת��Ϊ������ ��
	* ByteArrayOutputStream ���Բ����ڴ滺���������ݣ�ת�����ֽ����顣
	*
	* ByteArrayInputStreamʹ�ó�����
	* 	�ͻ��˺ͷ������˽����������ӽ���֮�����ֻ�Ǹ���Э����DataInputStream��
	* 	readInt() ����readByte() �ȹ̶�����һ��һ���Ķ��������൱������Դ�ģ�
	* 	���һ�ν�����Ҫ�����ݶ�ȡ��ϣ�Ȼ��ʣ�µľ��Ǳ��ؽ������Ǿ�ʡ�˲��ٽ�����Դ
	* ByteArrayOutputStreamʹ�ó�����
	* 	�������˴��������Ҫ���ͻ��˷������ݣ����ʹ��DataOutputStream��
	* 	writeInt(int v)����writeByte(int v)�ȷ���һ��һ����д����ô��
	* 	��ȡ�ĳ������ʾ�һ���ˣ�������Դ���൱���ĵģ����������ڱ��ذ�����
	* 	��֯���֮����һ�δ��ͣ��ͺ��ˡ�
	* */

	String str = "hangzhou";


	@Test
	public void byteArray() throws Exception {
		/*ByteArrayInputStreamʹ�ó���*/
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
		DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
		//��ʱ���������Ѿ��Ǳ��ص��������ˣ��ڱ����������������
		dataInputStream.readByte();
		dataInputStream.readInt();

		byteArrayInputStream.close();
		dataInputStream.close();

		/*ByteArrayOutputStreamʹ�ó���*/
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
		// ��������д������
		dataOutputStream.writeInt(29);
		dataOutputStream.writeChars("SGIP_BIND_RESP");
		dataOutputStream.writeByte(0);
		byte[] reserve = new byte[8];
		dataOutputStream.write(reserve);
		dataOutputStream.flush();
		// ���ֽ�������������н����ݶ�ȡ����
		byte[] result = byteArrayOutputStream.toByteArray();
		String resultStr = byteArrayOutputStream.toString();

		byteArrayOutputStream.close();  //�ر� ByteArrayOutputStream ��Ч�������еķ����ڹرմ������Կɱ����ã�����������κ�IOException
		dataOutputStream.close();
	}

}
