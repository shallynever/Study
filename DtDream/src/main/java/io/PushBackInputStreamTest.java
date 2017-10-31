package io;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.PushbackInputStream;


/**
 * 回退流
 * @author 天启 zhouj@dtdream.com
 * @since
 */
public class PushBackInputStreamTest {

	@Test
	public void pushBackInputStream() throws Exception {
		String str = "hangzhou1apocalypse";
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
		PushbackInputStream push = new PushbackInputStream(byteArrayInputStream);

		int temp;
		while((temp = push.read())!= -1){
			if(temp == '1'){
				push.unread(temp);
				temp = push.read();
				System.out.print("(pushBack:"+(char)temp+")");
			}else{
				System.out.print((char)temp);
			}
		}
		

	}

}
