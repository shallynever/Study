package io;

import java.io.ByteArrayInputStream;
import java.io.PushbackInputStream;

public class PushInputStreamDemo {

	public static void main(String[] args) throws Exception {
		String str = "zhejiang1gongshang.daxue";
		PushbackInputStream push = null;
		ByteArrayInputStream bai = null;
		
		bai = new ByteArrayInputStream(str.getBytes());
		push = new PushbackInputStream(bai);
		
		System.out.println("��ȡ֮�������Ϊ��");
		int temp = 0;
		while((temp = push.read())!= -1){
			if(temp == '1'){
				push.unread(temp);
				temp = push.read();
				System.out.print("(�˻�"+(char)temp+")");
			}else{
				System.out.print((char)temp);
			}
		}
		

	}

}
