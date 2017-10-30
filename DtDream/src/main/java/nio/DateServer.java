package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class DateServer {

	public static void main(String[] args) throws IOException {
		int[]  ports = {1111,2222,3333,4444};
		Selector selector = Selector.open();
		for (int port : ports) {
			ServerSocketChannel ssc = null;
			ssc = ServerSocketChannel.open();
			ssc.configureBlocking(false);
			ServerSocket ss = ssc.socket();
			InetSocketAddress address = null;
			address = new InetSocketAddress(port);
			ss.bind(address);
			ssc.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("������������"+port+"�˿���");
		}
//		System.out.println("==================");

		@SuppressWarnings("unused")
		int keyAdd = 0;
		while((keyAdd = selector.select())>0){
//			System.out.println(keyAdd);
			Set<SelectionKey> selectedKeys = selector.selectedKeys();
			Iterator<SelectionKey> it = selectedKeys.iterator();
			while(it.hasNext()){
				SelectionKey key = (SelectionKey)it.next();
				if(key.isAcceptable()){
					ServerSocketChannel server = (ServerSocketChannel) key.channel();
					SocketChannel client = server.accept();
					client.configureBlocking(false);
					ByteBuffer outBuf = ByteBuffer.allocateDirect(1024);
					outBuf.put(("��ǰʱ��Ϊ��"+new Date()).getBytes());
					
					outBuf.flip();
					client.write(outBuf);
					client.close();
				
				}
			}
			selectedKeys.clear();
		
		}
	}

}
