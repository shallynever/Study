package nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOSocket {
	private static final int CLIENT_PORT = 1111;
	private static final int SERVER_PORT = 2222;
	private static SocketChannel ch;
	private static Selector sel;
	
	public static void main(String[] args) throws IOException {
		ch = SocketChannel.open();
		sel = Selector.open();
		
		ch.socket().bind(new InetSocketAddress(CLIENT_PORT));
		ch.configureBlocking(false);
		ch.register(sel, SelectionKey.OP_READ | SelectionKey.OP_WRITE | SelectionKey.OP_CONNECT);
		sel.select();
		Iterator<SelectionKey> it = sel.selectedKeys().iterator();
		while(it.hasNext()){
			SelectionKey key = it.next();
			it.remove();
			if(key.isConnectable()){
				InetAddress addr = InetAddress.getLocalHost();
				System.out.println("Connect will not block");
				if(!ch.connect(new InetSocketAddress(addr, SERVER_PORT))){
					ch.finishConnect();
				}
				
			}
			if(key.isReadable()){
				System.out.println("Read will not block");
			}
			if(key.isWritable()){
				System.out.println("write will not block");
			}
			
			
		}
		ch.close();
		sel.close();
	
	
	}

}
