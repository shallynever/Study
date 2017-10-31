package nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 天启 zhouj@dtdream.com
 */

public class SelectorClient {
    public static void main(String[] args){
        work();
    }

    public static void work(){
        int serverPort = 8888;
        ByteBuffer sendBuffer = ByteBuffer.wrap("client send message to server".getBytes());
        ByteBuffer receiveBuffer = ByteBuffer.allocate(1024);
        try {
            //创建通道，设置通道注册到selector中
            SocketChannel socketChannel = SocketChannel.open();
            Selector selector = Selector.open();

            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ | SelectionKey.OP_CONNECT);
            socketChannel.connect(new InetSocketAddress("localhost", serverPort));
            int executeTimes = 1;
            while(executeTimes > 0){
                executeTimes--;
                int readyChannelNum = selector.select();
                if(readyChannelNum == 0){
                    continue;
                }
                Set<SelectionKey> setOfSelectionKey = selector.selectedKeys();
                Iterator<SelectionKey> iterator = setOfSelectionKey.iterator();
                while(iterator.hasNext()){
                    SelectionKey selectionKey = iterator.next();
                    SocketChannel socketChannel1 = (SocketChannel) selectionKey.channel();
                    iterator.remove();
                    if(selectionKey.isConnectable()){
                        if(socketChannel1.isConnectionPending()){
                            socketChannel1.finishConnect();
                            System.out.println("connection complete.");
                            socketChannel1.write(sendBuffer);
                        }
                    } else if(selectionKey.isReadable()){
                        receiveBuffer.clear();
                        socketChannel1.read(receiveBuffer);
                        receiveBuffer.flip();
                        System.out.println("message from server: " + new String(receiveBuffer.array()));
                    } else if(selectionKey.isWritable()){
                        sendBuffer.flip();
                        socketChannel1.write(sendBuffer);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
