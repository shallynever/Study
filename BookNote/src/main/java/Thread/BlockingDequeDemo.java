package Thread;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockingDequeDemo {
	public static void main(String[] args) throws InterruptedException{
		BlockingDeque<String> blockingStack = new LinkedBlockingDeque<String>(8);
		for (int i = 0; i < 8; i++) {
			blockingStack.putFirst(i+"");
		}
		System.out.println("�ɹ���ջ�����8��Ԫ��");
		for (int i = 0; i < 8; i++) {
			blockingStack.putFirst((i+8)+"");
		}
		System.out.println("�ֳɹ���ջ�����8��Ԫ��");
	}
	
}
