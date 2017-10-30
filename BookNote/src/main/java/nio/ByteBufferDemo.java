package nio;

import java.nio.ByteBuffer;

public class ByteBufferDemo {

	public static void main(String[] args) {
		
		/**
		  * ��ֱ���ڴ滺������ֱ���ڴ滺����������
		  * ֱ���ڴ滺������ֱ�ӻ�����ʹ�õ��ڴ��ɲ���ϵͳֱ�ӷ��䣬����JVM��ջ��֧��
		  *
		  *��ֱ���ڴ滺������ByteBuffer.allocate() �ڶ��ڴ��д����������һ��ͨ���д���һ����ֱ��ByteBuffer����д�룬
		  *ͨ�����ܻ������������������
		  *��ͨ���д�����ʱ������������ֱ��ByteBuffer�е����ݸ��Ƶ���ʱ�������У�ִ�еͲ��io������
		  *�������뿪������ʱ������������ݣ��ȴ�����
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
}
