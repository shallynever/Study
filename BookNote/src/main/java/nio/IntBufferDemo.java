package nio;

import java.nio.IntBuffer;

public class IntBufferDemo {

	public static void main(String[] args) {
//		IntBufferDemo1();
		IntBufferDemo2();
	}

	public static void IntBufferDemo2() {
		IntBuffer buf = IntBuffer.allocate(10);
		IntBuffer readOnlyBuffer = null;
		for (int i = 0; i < buf.capacity(); i++) {
			buf.put(2*i);
		}
		readOnlyBuffer = buf.asReadOnlyBuffer();	//��buf����Ϊֻ��
		readOnlyBuffer.flip();
		while(readOnlyBuffer.hasRemaining()){
			System.out.println(readOnlyBuffer.get());
		}
		
		readOnlyBuffer.put(1);	//����ʱ�쳣������д������
		
		
		
		
		
	}

	public static void IntBufferDemo1() {
		IntBuffer buf = IntBuffer.allocate(10);
		System.out.println("д������ǰ"+buf.position()+":"+buf.limit()+":"+buf.capacity());
		int temp[] = {4,6,8};
		buf.put(2);
		buf.put(temp);
		System.out.println("д�����ݺ�"+buf.position()+":"+buf.limit()+":"+buf.capacity());
		buf.flip();    //��hasRemainingһ���ã��ڻ�ȡ����������ʱ
		System.out.println("flip()����֮��"+buf.position()+":"+buf.limit()+":"+buf.capacity());
		System.out.println("������ݣ�");
		while(buf.hasRemaining()){
			System.out.println(buf.get());
		}
		
		
	}

}
