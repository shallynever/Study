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
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(false);
			ServerSocket serverSocket = serverSocketChannel.socket();
			InetSocketAddress address = new InetSocketAddress(port);
			serverSocket.bind(address);
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("server listen on :"+port);
		}

		int keyAdd;
		while((keyAdd = selector.select())>0){
			System.out.println(keyAdd);
			Set<SelectionKey> selectedKeys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = selectedKeys.iterator();
			while(iterator.hasNext()){
				SelectionKey key = iterator.next();
				if(key.isAcceptable()){
					ServerSocketChannel server = (ServerSocketChannel) key.channel();
					SocketChannel client = server.accept();
					client.configureBlocking(false);
					ByteBuffer outBuf = ByteBuffer.allocateDirect(1024);
					outBuf.put(("current time:"+new Date()).getBytes());
					outBuf.flip();
					client.write(outBuf);
					client.close();
				}
			}
			selectedKeys.clear();
		}
	}
}
